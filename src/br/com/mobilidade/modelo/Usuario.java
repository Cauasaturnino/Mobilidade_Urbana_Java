package br.com.mobilidade.modelo;

    public class Usuario {
    private String nome;
    private String id; //numeros simples: 001,002
    private boolean temLocacaoAtiva; // saber se ta ok ou nao 
    
    //Construtor
    public Usuario (String nome, String id){
    this.nome = nome;
    this.id = id;
    this.temLocacaoAtiva = false; 
    /*temLocacaoAtiva = false -> pessoa livre (pode alugar)
    temLocacaoAtiva = true -> pessoa ocupada (nao pode alugar) 
    */
    }

        // Metodos
        public boolean podeAlugar() { // vai devolover uma resposta
        return !this.temLocacaoAtiva;
        }

        public void iniciarLocacao(){ // vai mudar o status 
        this.temLocacaoAtiva = true;
        }

        public void finalizarLocacao(){
        this.temLocacaoAtiva = false;
        }

        public String exibirDados(){
        return "Nome: " + this.nome + " | id: " + this.id + " | Status da Locação: " + this.temLocacaoAtiva;
        }


   
    
}