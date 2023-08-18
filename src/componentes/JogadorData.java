package componentes;

import graphics.JanelaNomeJogador;

public class JogadorData {
    private String nome;
    private int vitorias;
    public JogadorData(String nome, int vitorias){
        this.nome = nome;
        this.vitorias = vitorias;
    }

    public String setNome(JanelaNomeJogador nomeJogador1){
        this.nome=nome;
        return nome;
    }
    public String getNome() {
        return nome;
    }
    public int getVitorias() {
        return vitorias;
    }
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }
    public void incrementVitorias() {
        vitorias++;
    }
}
