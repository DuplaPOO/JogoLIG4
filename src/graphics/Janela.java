package graphics;

import javax.swing.*;

public class Janela extends JFrame {
    JFrame frame,frame1,frame2;

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
        frame1 = new JFrame();
        frame1.setTitle("lig 4 Turbo");
        frame1.setSize(900, 900);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        JanelaTurbo velha2 = new JanelaTurbo();
        velha2.setBounds(0, 0, 600, 600);
        frame1.add(velha2);
        frame1.addMouseListener(velha2);
    }

    public void JanelaTurboMaluco(){
        frame2 = new JFrame();
        frame2.setTitle("lig 4 Turbo Maluco");
        frame2.setSize(900, 900);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        JanelaTurboMaluco velha3 = new JanelaTurboMaluco();
        velha3.setBounds(0, 0, 600, 600);
        frame2.add(velha3);
        frame2.addMouseListener(velha3);
    }







}