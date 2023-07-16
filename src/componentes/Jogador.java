package componentes;

public class Jogador {

    private String nome;
    private Peca peca;
    private int vitorias;

    public Jogador(String nome, String peca){
        this.nome = nome;
        this.peca = new Peca(peca);
        this.vitorias = 0;
    }

    public void addVitoria(){
        this.vitorias++;
    }
    
    public String getNome(){
        return this.nome;
    }

    public String getCor(){
        return this.peca.getCor();
    }


}
