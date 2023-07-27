package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton sair;
    JButton jogar;JButton jogarTurbo;JButton jogarMaluco;
    JLabel jLabel;
    public Menu(){
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
        jogarTurbo.addActionListener(this::jogoTurbo);

        jogarMaluco = new JButton();
        jogarMaluco.setText("JOGO MALUCO");
        jogarMaluco.setBounds(220,300,250,50);
        jogarMaluco.setFont(new Font("Arial", Font.BOLD, 15));
        jogarMaluco.setForeground(new Color(0, 0, 0));
        jogarMaluco.setBackground(new Color(255, 255, 255));
        add(jogarMaluco);
        jogarMaluco.addActionListener(this::jogoMaluco);

        sair = new JButton();
        sair.setText("SAIR");
        sair.setBounds(220,400,250,50);
        sair.setFont(new Font("Arial", Font.BOLD, 15));
        sair.setForeground(new Color(255, 255, 255));
        sair.setBackground(new Color(222, 20, 20));
        add(sair);
        sair.addActionListener(this::sair);
    }

    private void jogoNormal(ActionEvent actionEvent) {
        Janela janela= new Janela();
        this.dispose();
        janela.janelaNormal();
    }
    private void jogoTurbo(ActionEvent actionEvent) {
    }
    private void jogoMaluco(ActionEvent actionEvent) {
    }
    private void sair(ActionEvent actionEvent) {
        System.exit(0);
    }





    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
