package br.com.mobilidade.servico;

import br.com.mobilidade.modelo.Estacao;
import br.com.mobilidade.modelo.Locacao;
import br.com.mobilidade.modelo.Usuario;
import br.com.mobilidade.modelo.Veiculo;
import java.util.ArrayList;

public class SistemaLocacao {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Estacao> estacoes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Locacao> locacoes;

    public SistemaLocacao() {
        this.usuarios = new ArrayList<>();
        this.estacoes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.locacoes = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void cadastrarEstacao(Estacao estacao) {
        this.estacoes.add(estacao);
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Locacao realizarLocacao(Usuario usuario, Veiculo veiculo, Estacao estacaoOrigem) {
        if (!this.usuarios.contains(usuario)
                || !this.veiculos.contains(veiculo)
                || !this.estacoes.contains(estacaoOrigem)) {
            return null;
        }

        if (veiculo.getEstacaoAtual() != estacaoOrigem) {
            return null;
        }

        if (!usuario.podeAlugar()) {
            return null;
        }

        if (!veiculo.tornarIndisponivel()) {
            return null;
        }

        usuario.iniciarLocacao();

        Locacao locacao = new Locacao(usuario, veiculo, estacaoOrigem);
        this.locacoes.add(locacao);

        return locacao;
    }

    public boolean finalizarLocacao(Locacao locacao, Estacao estacaoDevolucao) {
        if (!this.locacoes.contains(locacao)
                || !this.estacoes.contains(estacaoDevolucao)) {
            return false;
        }

        return locacao.finalizar(estacaoDevolucao);
    }

    public void exibirVeiculos() {
        for (Veiculo veiculo : this.veiculos) {
            System.out.println(veiculo.exibirDadosVeiculo());
        }
    }
}