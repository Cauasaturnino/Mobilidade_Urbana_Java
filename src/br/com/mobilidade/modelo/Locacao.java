package br.com.mobilidade.modelo;

public class Locacao {

    private Usuario usuario;
    private Veiculo veiculo;
    private Estacao estacaoOrigem;
    private Estacao estacaoDevolucao;
    private boolean locacaoAtiva;

    public Locacao(Usuario usuario, Veiculo veiculo, Estacao estacaoOrigem) {
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.estacaoOrigem = estacaoOrigem;
        this.locacaoAtiva = true;
    }

    public double calcularValor(int minutos) {
        return this.veiculo.calcularTarifa(minutos);
    }

    public boolean finalizar(Estacao estacaoDevolucao) {
        if (!this.locacaoAtiva) {
            return false;
        }

        boolean veiculoDevolvido = this.veiculo.tornarDisponivel(estacaoDevolucao);

        if (!veiculoDevolvido) {
            return false;
        }

        this.usuario.finalizarLocacao();
        this.estacaoDevolucao = estacaoDevolucao;
        this.locacaoAtiva = false;

        return true;
    }
}