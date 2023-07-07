package componentes;

public class Jogador {

    private String nome;
    private int vitorias;

    public Jogador(String nome){
        this.nome = nome;
        this.vitorias = 0;
    }

    public void addVitorias(){
        this.vitorias++;
    }
    

}
