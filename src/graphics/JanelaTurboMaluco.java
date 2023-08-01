package graphics;

import componentes.tabuleiro.TabuleiroTurboMaluco;

import java.awt.*;
import java.awt.event.MouseEvent;


public class JanelaTurboMaluco extends JanelaTurbo{

    public JanelaTurboMaluco(){
        super();
        this.tabuleiro = new TabuleiroTurboMaluco();
    }

    @Override
    public void paintComponent(Graphics g){


        //funções como desing tabuleiro, verificar ganhador, talvez dê para economizar código
        designTabuleiro(g);

        g.setColor(Color.yellow);
        g.drawString("Maluquice: " + String.format("%.1f", tabuleiro.getMaluquice()*100) + "%", 550, 50);

        if(!vezDoJogador){
            g.setColor(Color.blue);
            g.drawString("Vez do Azul", 50, 750);
        } else{
            g.setColor(Color.yellow);
            g.drawString("Vez do amarelo", 50, 750);
        }

        tabuleiro.verificarGanhador(vezDoJogador, g);

    }

    @Override
    public void mouseClicked(MouseEvent e){
        boolean jogadaFeita = false;

        if(e.getX()>=100 && e.getX() <=800 && e.getY()>=100 && e.getY() <=700){
            int coluna = (e.getX())/100;
            if(vezDoJogador){
                jogadaFeita = tabuleiro.registrarPeca(coluna-1, "Amarelo");
                tabuleiro.modificarPecasVizinhas(coluna-1, "Amarelo");
            } else{
                jogadaFeita = tabuleiro.registrarPeca(coluna-1, "Azul");
                tabuleiro.modificarPecasVizinhas(coluna-1, "Azul");
            }
            
            if(jogadaFeita){
                vezDoJogador = !vezDoJogador;
                tabuleiro.atualizarMaluquice();
            }

            repaint();
    
        }
        
    }

}
