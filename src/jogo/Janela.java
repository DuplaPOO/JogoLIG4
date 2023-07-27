package jogo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Janela {

    public static void main(String[] args){

        JFrame frame = new JFrame("Lig4");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JogoJanela velha = new JogoJanela();
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);

        frame.addMouseListener(velha);
    }

	
    
}