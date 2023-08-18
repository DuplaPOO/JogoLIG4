package graphics;

import componentes.Jogador;
import componentes.tabuleiro.TabuleiroTurboMaluco;


import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;


public class JanelaTurboMaluco extends JanelaTurbo{

    public JanelaTurboMaluco(Jogador jogador1, Jogador jogador2){
        super(jogador1, jogador2);
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
        if(!jogadaFeita){
            if(!partidaFinalizada){
            if(e.getX()>=100 && e.getX() <=800 && e.getY()>=100 && e.getY() <=700){
                this.coluna = (e.getX())/100;
                this.linha = tabuleiro.pegarLinha(coluna-1);
                if(this.linha!=-1){
                    this.jogadaFeita = true;
                }
                
                if(this.jogadaFeita){
                    this.yAtual = this.yInicial;
                    Timer timer = new Timer(10,this);
		            timer.start();
                    if(this.yAtual== 125 + linha * 100){
                        timer.stop();
                        this.jogadaFeita = false;
                        
                    }
                    tabuleiro.atualizarMaluquice();
                    vezDoJogador = !vezDoJogador;
                }

                repaint();
            }
        } else{
            fecharEAbrirMenu();
        }
        }
        
        
    }

}
