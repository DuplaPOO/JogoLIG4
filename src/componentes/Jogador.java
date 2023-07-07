package componentes;

public class Jogador {

    private String nome;
    private Peca peca;
    private int vitorias;

    public Jogador(String nome, Peca peca){
        this.nome = nome;
        this.peca = peca;
        this.vitorias = 0;
    }

    public void addVitorias(){
        this.vitorias++;
    }
    
    public String getNome(){
        return this.nome;
    }

    public String getCor(){
        return this.peca.getCor();
    }

    public void aumentarPontuacao(){
        this.vitorias++;
    }
    

}
