package br.com.mobilidade.modelo;

public abstract class Veiculo {

    private String codigo;
    private boolean disponivel;
    private Estacao estacaoAtual;

    public Veiculo(String codigo, Estacao estacaoAtual) {
        this.codigo = codigo;
        this.estacaoAtual = estacaoAtual;
        this.disponivel = true;
    }

    public Estacao getEstacaoAtual() {
        return this.estacaoAtual;
    }

    public boolean verificarDisponibilidade() {
        return this.disponivel;
    }

    public boolean tornarIndisponivel() {
        if (!this.disponivel) {
            return false;
        }

        this.disponivel = false;
        return true;
    }

    public boolean tornarDisponivel(Estacao novaEstacao) {
        if (this.disponivel) {
            return false;
        }

        this.estacaoAtual = novaEstacao;
        this.disponivel = true;
        return true;
    }

    public String exibirDadosVeiculo() {
        return "Código: " + this.codigo
                + " | " + this.estacaoAtual.exibirDadosEstacao()
                + " | Disponível: " + this.disponivel;
    }

    public abstract double calcularTarifa(int minutos);
}