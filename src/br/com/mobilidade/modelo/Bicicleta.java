package br.com.mobilidade.modelo;

public class Bicicleta extends Veiculo {

    private static final double tarifaPorMinuto = 0.10;

    public Bicicleta(String codigo, Estacao estacaoAtual) {
        super(codigo, estacaoAtual);
    }

    @Override
    public double calcularTarifa(int minutos) {
        return minutos > 0 ? minutos * tarifaPorMinuto : 0;
    }
}