package graphics;


import componentes.tabuleiro.InterfaceTabuleiro;
import componentes.tabuleiro.Tabuleiro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class JanelaNormal extends JPanel implements MouseListener, MouseMotionListener{

    protected InterfaceTabuleiro tabuleiro;
    protected boolean vezDoJogador;
    protected boolean partidaFinalizada;
    Font minhaFont = new Font("Arial", Font.BOLD , 30 );
    protected Image imgTrofeu;
    int col=0;
    Menu menu;



    public JanelaNormal(){
        
        addMouseMotionListener(this);
        addMouseListener(this);
        this.tabuleiro = new Tabuleiro();
        this.vezDoJogador = true;
        menu = new Menu();

        try{
            imgTrofeu = ImageIO.read(getClass().getResource("/images/imgTrofeu.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    protected void fecharEAbrirMenu() {
        
        menu.telaMenu();

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    @Override
    public void paintComponent(Graphics g){


        designTabuleiro(g);
        
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


    public void designTabuleiro(Graphics g){
        g.setFont(minhaFont);

        Color vinho = new Color(128, 0, 0);
        Color azulClaro = new Color(135, 185, 205);

        //Fundo da janela
        g.setColor(azulClaro);
        g.fillRect(0, 0, 900, 900);

        //Fundo do tabuleiro
        g.setColor(Color.red);
        g.fillRect(100, 100, 700, 600);

        //coluna que o mouse passa por cima
        if(col >=1 & col<=7){
            g.setColor(vinho);
            g.fillRect(col*100, 100, 100, 600);
            if(!vezDoJogador){
                g.drawImage(tabuleiro.getCirculoAzul(), 127 + (col-1) * 100, 40, 50, 50, null);
            } else{
                g.drawImage(tabuleiro.getCirculoAmarelo(), 127 + (col-1) * 100, 40, 50, 50, null);
            }
        }

        tabuleiro.imprimirPecasTabuleiro(g);
    }


    @Override
    public void mouseClicked(MouseEvent e){
        if(!partidaFinalizada){
            boolean jogadaFeita = false;
            if(e.getX()>=100 && e.getX() <=800 && e.getY()>=100 && e.getY() <=700){
                int coluna = (e.getX())/100;
                if(vezDoJogador){
                    jogadaFeita = tabuleiro.registrarPeca(coluna-1, "Amarelo");
                } else{
                    jogadaFeita = tabuleiro.registrarPeca(coluna-1, "Azul");
                }
                
                if(jogadaFeita){
                    vezDoJogador = !vezDoJogador;
                }

                repaint();
            }
        } else{
            fecharEAbrirMenu();
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    public void mouseMoved(MouseEvent e) {
        col = -1;
        if(e.getPoint().getX()>=100 && e.getPoint().getX() <=800 && e.getPoint().getY()>=100 && e.getPoint().getY() <=700){
            col=(int)e.getPoint().getX()/100;
        }
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    
    
}
