package graphics;

import componentes.tabuleiro.InterfaceTabuleiro;
import componentes.tabuleiro.TabuleiroTurboMaluco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class JanelaTurboMaluco extends JPanel implements MouseListener, MouseMotionListener{

    protected InterfaceTabuleiro tabuleiro;
    protected boolean vezDoJogador;
    Font minhaFont = new Font("Arial", Font.BOLD , 30 );
    int col=0;
    Menu menu;

    public JanelaTurboMaluco(){
        addMouseMotionListener(this);
        addMouseListener(this);
        this.tabuleiro = new TabuleiroTurboMaluco();
        this.vezDoJogador = true;
        menu = new Menu();

        JButton voltar = menu.buttonVoltar();
        voltar.setBounds(400, 50, 250, 50);
        add(voltar);
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
        }

        tabuleiro.imprimirPecasTabuleiro(g);
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
