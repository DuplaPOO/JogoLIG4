package componentes;

import org.json.simple.JSONObject;
public class Jogador  {


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
    public int getVitorias(){
        return this.vitorias;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }
    public String getCor(){
        return this.peca.getCor();
    }



}
