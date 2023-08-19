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
        JanelaNormal jogoNormal = new JanelaNormal(jogador1,jogador2);
        jogoNormal.setBounds(0, 0, 600, 600);
        frame.add(jogoNormal);
        frame.addMouseListener(jogoNormal);
    }

    public void janelaTurbo(Jogador jogador1, Jogador jogador2){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaTurbo jogoTurbo = new JanelaTurbo(jogador1,jogador2);
        jogoTurbo.setBounds(0, 0, 600, 600);
        frame.add(jogoTurbo);
        frame.addMouseListener(jogoTurbo);
    }

    public void janelaTurboMaluco(Jogador jogador1, Jogador jogador2){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo Maluco");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaTurboMaluco jogoTurboMaluco = new JanelaTurboMaluco(jogador1,jogador2);
        jogoTurboMaluco.setBounds(0, 0, 600, 600);
        frame.add(jogoTurboMaluco);
        frame.addMouseListener(jogoTurboMaluco);
    }
    public void janelaRanking(){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo Maluco");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaRanking ranking = new JanelaRanking();
        ranking.setBounds(0, 0, 600, 600);
        frame.add(ranking);
    }







}