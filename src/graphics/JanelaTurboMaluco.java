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

        designTabuleiro(g);
        g.setColor(Color.red);
        g.drawString("Maluquice: " + String.format("%.1f", tabuleiro.getMaluquice()*100) + "%", 50, 750);

        partidaFinalizada = tabuleiro.verificarGanhador();
        
        if(partidaFinalizada){
            Color azulClaro = new Color(135, 185, 205);
            g.setColor(azulClaro);
            g.fillRect(0, 0, 900, 900);
            g.setColor(Color.red);
            g.fillRect(100, 100, 700, 250);
            g.drawImage(imgTrofeu, 100, 100, 250, 250, null);

            if(vezDoJogador){
                g.setColor(Color.blue);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
                g.drawString("Azul venceu!", 360, 250);
                g.setColor(Color.white);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                g.drawString("Clique em qualquer lugar para voltar...", 300, 650);
            } else{
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
                g.drawString("Amarelo venceu!", 340, 250);
                g.setColor(Color.white);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                g.drawString("Clique em qualquer lugar para voltar...", 300, 650);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(!partidaFinalizada){
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
        } else {
            fecharEAbrirMenu();
        }
        
    }

}
