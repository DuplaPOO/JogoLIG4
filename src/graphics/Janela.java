package graphics;

import javax.swing.*;

import componentes.Jogador;

public class Janela extends JFrame {
    JFrame frame;


    public void janelaNormal(Jogador jogador1, Jogador jogador2){
        frame = new JFrame();
        frame.setTitle("lig 4");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaNormal velha = new JanelaNormal(jogador1,jogador2);
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);
        frame.addMouseListener(velha);
    }

    public void janelaTurbo(Jogador jogador1, Jogador jogador2){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaTurbo velha = new JanelaTurbo(jogador1,jogador2);
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);
        frame.addMouseListener(velha);
    }

    public void janelaTurboMaluco(Jogador jogador1, Jogador jogador2){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo Maluco");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaTurboMaluco velha = new JanelaTurboMaluco(jogador1,jogador2);
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);
        frame.addMouseListener(velha);
    }
    public void janelaRanking(){
       JanelaRanking velha = new JanelaRanking();

    }







}