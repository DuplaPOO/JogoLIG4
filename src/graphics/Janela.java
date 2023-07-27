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







}