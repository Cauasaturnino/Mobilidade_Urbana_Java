package br.com.mobilidade.modelo;

public class Estacao {
    private String nomeEstacao;
    private String endereco; 

        // construtor
    public Estacao(String nomeEstacao, String endereco){
    this.nomeEstacao = nomeEstacao;
    this.endereco = endereco;
    } 

        // metodo 
        public String exibirDadosEstacao (){
            return "Nome: " + this.nomeEstacao + " | Endereço: " + this.endereco;
        }

}