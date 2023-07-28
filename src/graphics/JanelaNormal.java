package graphics;

import componentes.tabuleiro.Tabuleiro;
import componentes.tabuleiro.TabuleiroTurbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class JanelaNormal extends JPanel implements MouseListener, MouseMotionListener{

    protected Tabuleiro tabuleiro;
    protected boolean vezDoJogador;
    Font minhaFont = new Font("Arial", Font.BOLD , 30 );
    int col=0;
    Menu menu;

    public JanelaNormal(){
        addMouseMotionListener(this);
        addMouseListener(this);
        this.tabuleiro = new TabuleiroTurbo();
        this.vezDoJogador = true;
        menu = new Menu();

        JButton voltar = menu.buttonVoltar();
        voltar.setBounds(400, 50, 250, 50);
        add(voltar);
    }
    @Override
    public void paintComponent(Graphics g){

        g.setFont(minhaFont);

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 900, 900);

        if(col >=1 & col<=7){
            g.setColor(Color.gray);
            g.fillRect(col*100, 100, 100, 600);
        }

        
        

        g.setColor(Color.white);
        
        for(int i=0; i<=700; i+=100){
            g.drawLine(100, i, 800, i);
        }

        for (int i = 0; i <= 800; i+=100) {
            g.drawLine(i, 100, i, 700);
        }



        tabuleiro.imprimirPecasTabuleiro(g);

        if(tabuleiro.verificarGanhador()){
                if(vezDoJogador){
                    g.setColor(Color.blue);
                    g.drawString("Azul Venceu", 50, 50);
                } else{
                    g.setColor(Color.red);
                    g.drawString("Vermelho Venceu", 50, 50);
                }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        boolean jogadaFeita = false;

        if(e.getX()>=100 && e.getX() <=800 && e.getY()>=100 && e.getY() <=700){
            int coluna = (e.getX())/100;
            System.out.println("Clicou na coluna "+coluna);
            if(vezDoJogador){
                jogadaFeita = tabuleiro.registrarPeca(coluna-1, "V");
            } else{
                jogadaFeita = tabuleiro.registrarPeca(coluna-1, "A");
            }
            
            if(jogadaFeita){
                vezDoJogador = !vezDoJogador;
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
        if(e.getPoint().getX()>=100 && e.getPoint().getX() <=800 && e.getPoint().getY()>=100 && e.getPoint().getY() <=700){
            col=(int)e.getPoint().getX()/100;
        }
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
}
