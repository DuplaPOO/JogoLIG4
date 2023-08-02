package graphics;

import javax.swing.*;

public class Janela extends JFrame {
    JFrame frame;


    public void janelaNormal(){
        frame = new JFrame();
        frame.setTitle("lig 4");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaNormal velha = new JanelaNormal();
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);
        frame.addMouseListener(velha);
    }

    public void janelaTurbo(){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaTurbo velha = new JanelaTurbo();
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);
        frame.addMouseListener(velha);
    }

    public void JanelaTurboMaluco(){
        frame = new JFrame();
        frame.setTitle("lig 4 Turbo Maluco");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaTurboMaluco velha = new JanelaTurboMaluco();
        velha.setBounds(0, 0, 600, 600);
        frame.add(velha);
        frame.addMouseListener(velha);
    }

    public void janelaNomeJogador(){
        frame = new JFrame();
        frame.setTitle("REGISTRAR JOGADORES DO MODO NORMAL");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JanelaNomeJogador velha = new JanelaNomeJogador();
        frame.add(velha);
    }







}