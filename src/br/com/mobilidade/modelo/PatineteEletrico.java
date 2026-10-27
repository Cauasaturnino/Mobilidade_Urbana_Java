package br.com.mobilidade.modelo;

public class PatineteEletrico extends Veiculo implements Recarregavel {

    private static final double tarifaPorMinuto = 0.20;
    private int nivelBateria;

    public PatineteEletrico(String codigo, Estacao estacaoAtual, int nivelBateria) {
        super(codigo, estacaoAtual);
        this.nivelBateria = Math.max(0, Math.min(nivelBateria, 100));
    }

    @Override
    public double calcularTarifa(int minutos) {
        return minutos > 0 ? minutos * tarifaPorMinuto : 0;
    }

    @Override
    public void recarregar() {
        this.nivelBateria = 100;
    }

    public int getNivelBateria() {
        return this.nivelBateria;
    }
}