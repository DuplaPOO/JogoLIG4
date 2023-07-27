package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    JButton sair;
    JButton jogar;JButton jogarTurbo;JButton jogarMaluco;
    JLabel jLabel;
    public Gui(){
        setVisible(true);
        setSize(750,650);
        setTitle("LIG 4 -- ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        jLabel = new JLabel("LIG 4");
        jLabel.setBounds(300,0,180,50);
        jLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(jLabel);
        menu();
    }

    public void menu(){

        jogar = new JButton();
        jogar.setText("JOGO NORMAL");
        jogar.setBounds(220,100,250,50);
        jogar.setFont(new Font("Arial", Font.BOLD, 15));
        jogar.setForeground(new Color(0, 0, 0));
        jogar.setBackground(new Color(255, 255, 255));
        add(jogar);
        jogar.addActionListener(this::jogoNormal);

        jogarTurbo = new JButton();
        jogarTurbo.setText("JOGO TURBO");
        jogarTurbo.setBounds(220,200,250,50);
        jogarTurbo.setFont(new Font("Arial", Font.BOLD, 15));
        jogarTurbo.setForeground(new Color(0, 0, 0));
        jogarTurbo.setBackground(new Color(255, 255, 255));
        add(jogarTurbo);
        jogarTurbo.addActionListener(this::jogoNormal);

        jogarMaluco = new JButton();
        jogarMaluco.setText("JOGO MALUCO");
        jogarMaluco.setBounds(220,300,250,50);
        jogarMaluco.setFont(new Font("Arial", Font.BOLD, 15));
        jogarMaluco.setForeground(new Color(0, 0, 0));
        jogarMaluco.setBackground(new Color(255, 255, 255));
        add(jogarMaluco);
        jogarMaluco.addActionListener(this::jogoNormal);

        sair = new JButton();
        sair.setText("SAIR");
        sair.setBounds(220,400,250,50);
        sair.setFont(new Font("Arial", Font.BOLD, 15));
        sair.setForeground(new Color(255, 255, 255));
        sair.setBackground(new Color(222, 20, 20));
        add(sair);
        sair.addActionListener(this::sair);
    }

    private void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
    private void jogoNormal(ActionEvent actionEvent) {
        NormalGui normalGui = new NormalGui();
        this.dispose();
        normalGui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }



    public static void main(String[] args) {

        Gui gui = new Gui();

    }



}
