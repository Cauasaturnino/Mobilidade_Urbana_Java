package br.com.mobilidade;

import br.com.mobilidade.modelo.Bicicleta;
import br.com.mobilidade.modelo.Estacao;
import br.com.mobilidade.modelo.Locacao;
import br.com.mobilidade.modelo.PatineteEletrico;
import br.com.mobilidade.modelo.Recarregavel;
import br.com.mobilidade.modelo.Usuario;
import br.com.mobilidade.modelo.Veiculo;
import br.com.mobilidade.servico.SistemaLocacao;

public class Main {

    public static void main(String[] args) {
        SistemaLocacao sistema = new SistemaLocacao();

        Estacao centro = new Estacao("Centro", "Rua Principal");
        Estacao campus = new Estacao("Campus", "Avenida da Universidade");

        Usuario ana = new Usuario("Ana", "001");
        Usuario bruno = new Usuario("Bruno", "002");

        Bicicleta bicicleta1 = new Bicicleta("B001", centro);
        Bicicleta bicicleta2 = new Bicicleta("B002", centro);
        PatineteEletrico patinete1 = new PatineteEletrico("P001", centro, 40);
        PatineteEletrico patinete2 = new PatineteEletrico("P002", campus, 75);

        sistema.cadastrarEstacao(centro);
        sistema.cadastrarEstacao(campus);

        sistema.cadastrarUsuario(ana);
        sistema.cadastrarUsuario(bruno);

        sistema.cadastrarVeiculo(bicicleta1);
        sistema.cadastrarVeiculo(bicicleta2);
        sistema.cadastrarVeiculo(patinete1);
        sistema.cadastrarVeiculo(patinete2);

        System.out.println("Veículos antes da locação:");
        sistema.exibirVeiculos();

        if (sistema.realizarLocacao(ana, bicicleta1, campus) == null) {
            System.out.println("Retirada em estação incorreta bloqueada.");
        }

        Locacao locacaoAna = sistema.realizarLocacao(ana, bicicleta1, centro);

        if (locacaoAna != null) {
            System.out.println("Locação da Ana realizada.");
            System.out.println("Tarifa por 30 minutos: R$ "
                    + locacaoAna.calcularValor(30));
        }

        Locacao tentativaBruno =
                sistema.realizarLocacao(bruno, bicicleta1, centro);

        if (tentativaBruno == null) {
            System.out.println("Locação do Bruno bloqueada: veículo indisponível.");
        }

        System.out.println("Estado durante a locação:");
        sistema.exibirVeiculos();

        boolean devolucaoConcluida =
                sistema.finalizarLocacao(locacaoAna, campus);

        if (devolucaoConcluida) {
            System.out.println("Veículo devolvido no Campus.");
        }

        System.out.println("Veículos depois da devolução:");
        sistema.exibirVeiculos();

        Veiculo[] veiculosParaCalcular = { bicicleta1, patinete1 };

        System.out.println("Tarifas polimórficas por 30 minutos:");
        for (Veiculo veiculo : veiculosParaCalcular) {
            System.out.println(veiculo.calcularTarifa(30));
        }

        System.out.println("Tarifa para tempo negativo: R$ " + bicicleta1.calcularTarifa(-5));

        Recarregavel itemParaRecarregar = patinete1;

        System.out.println("Bateria antes: " + patinete1.getNivelBateria());
        itemParaRecarregar.recarregar();
        System.out.println("Bateria depois: " + patinete1.getNivelBateria());
    }
}