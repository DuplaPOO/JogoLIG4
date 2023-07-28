package graphics;

import javax.swing.*;

import componentes.tabuleiro.Tabuleiro;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JanelaNormal extends JPanel implements MouseListener{

    protected Tabuleiro tabuleiro;
    protected boolean vezDoJogador;
    Font minhaFont = new Font("Arial", Font.BOLD , 30 );
    int[][] matriz = new int[6][7];

    Menu menu;

    public JanelaNormal(){
        this.tabuleiro = new Tabuleiro();
        this.vezDoJogador = true;
        menu = new Menu();

        for(int lin = 0; lin<6;lin++){
            for(int col = 0; col<7; col++){
                System.out.print(matriz[lin][col]);
            }
            System.out.println();
        }
        JButton voltar = menu.buttonVoltar();
        voltar.setBounds(400, 50, 250, 50);
        add(voltar);

    }
    @Override
    public void paintComponent(Graphics g){
        menu = new Menu();

        g.setFont(minhaFont);

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 900, 900);

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


                    JButton sair = menu.buttonSair();
                    sair.setBounds(400, 0, 250, 50);
                    add(sair);
                    JButton voltar = menu.buttonVoltar();
                    voltar.setBounds(400, 50, 250, 50);
                    add(voltar);

                } else{
                    g.setColor(Color.red);
                    g.drawString("Vermelho Venceu", 50, 50);



                    JButton sair = menu.buttonSair();
                    sair.setBounds(400, 0, 250, 50);
                    add(sair);
                    JButton voltar = menu.buttonVoltar();
                    voltar.setBounds(400, 50, 250, 50);
                    add(voltar);

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
    
}
