package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JogoJanela extends JPanel implements MouseListener{

    @Override
    public void paintComponent(Graphics g){

        g.setColor(Color.blue);
        g.fillRect(0, 0, 900, 900);

        g.setColor(Color.white);
        
        for(int i=0; i<=700; i+=100){
            g.drawLine(100, i, 800, i);
        }

        for (int i = 0; i <= 800; i+=100) {
            g.drawLine(i, 100, i, 700);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e){

        int coluna = (e.getX())/100;
        System.out.println("Clicou na coluna "+coluna);


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
