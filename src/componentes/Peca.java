package componentes;

import java.awt.Color;
import java.awt.Graphics;

public class Peca {
    private String cor;
    private Color color;
    
//Tudo public para os arquivos do subpacote tabuleiro conseguirem acessar os métodos

    public Peca(){
        this.cor = null;
    }

    public Peca(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public void desenhar(Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(x - 40, y - 40, 80, 80); // Desenha um círculo em torno das coordenadas (x, y)
    }


}
