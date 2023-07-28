package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton sair;
    JButton jogar;JButton jogarTurbo;JButton jogarMaluco, voltar,rank;
    JLabel jLabel;
    public Menu(){

    }

    public void telaMenu(){
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
        Menu menu = new Menu();

        jogar = menu.buttonJogar();
        jogar.setBounds(220,100,250,50);
        add(jogar);

        jogarTurbo = menu.buttonJogarTurbo();
        jogarTurbo.setBounds(220,200,250,50);
        add(jogarTurbo);

        jogarMaluco = menu.buttonJogarTurboMaluco();
        jogarMaluco.setBounds(220,300,250,50);
        add(jogarMaluco);

        rank =menu.buttonRanking();
        rank.setBounds(220,400,250,50);
        add(rank);

        sair = menu.buttonSair();
        sair.setBounds(220, 500, 250, 50);
        add(sair);

    }


    //BOTÕES
    public JButton buttonVoltar(){
        voltar = new JButton();
        voltar.setText("VOLTAR");
        voltar.setFont(new Font("Arial", Font.BOLD, 15));
        voltar.setForeground(new Color(0, 0, 0));
        voltar.setBackground(new Color(255, 255, 255));

        voltar.addActionListener(this::voltar);
        return voltar;
    }
    public JButton buttonRanking(){
        rank = new JButton();
        rank.setText("RANKING");
        rank.setFont(new Font("Arial", Font.BOLD, 15));
        rank.setForeground(new Color(0, 0, 0));
        rank.setBackground(new Color(255, 255, 255));
        add(rank);
        rank.addActionListener(this::ranking);
        return rank;
    }
    public JButton buttonSair(){
        sair = new JButton();
        sair.setText("SAIR");
        sair.setFont(new Font("Arial", Font.BOLD, 15));
        sair.setForeground(new Color(255, 255, 255));
        sair.setBackground(new Color(222, 20, 20));
        add(sair);
        sair.addActionListener(this::sair);
        return sair;
    }
    public JButton buttonJogar(){
        jogar = new JButton();
        jogar.setText("JOGO NORMAL");
        jogar.setFont(new Font("Arial", Font.BOLD, 15));
        jogar.setForeground(new Color(0, 0, 0));
        jogar.setBackground(new Color(255, 255, 255));
        add(jogar);
        jogar.addActionListener(this::jogoNormal);
        return jogar;
    }
    public JButton buttonJogarTurbo(){
        jogarTurbo = new JButton();
        jogarTurbo.setText("JOGO TURBO");
        jogarTurbo.setBounds(220,200,250,50);
        jogarTurbo.setFont(new Font("Arial", Font.BOLD, 15));
        jogarTurbo.setForeground(new Color(0, 0, 0));
        jogarTurbo.setBackground(new Color(255, 255, 255));
        add(jogarTurbo);
        jogarTurbo.addActionListener(this::jogoTurbo);
        return jogarTurbo;
    }
    public JButton buttonJogarTurboMaluco(){
        jogarMaluco = new JButton();
        jogarMaluco.setText("JOGO MALUCO");
        jogarMaluco.setBounds(220,300,250,50);
        jogarMaluco.setFont(new Font("Arial", Font.BOLD, 15));
        jogarMaluco.setForeground(new Color(0, 0, 0));
        jogarMaluco.setBackground(new Color(255, 255, 255));
        add(jogarMaluco);
        jogarMaluco.addActionListener(this::jogoMaluco);
        return jogarMaluco;
    }

    //EVENTOS DOS CLICKS DOS BOTOES
    private void jogoNormal(ActionEvent actionEvent) {
        Janela janela= new Janela();
        this.dispose();
        janela.janelaNormal();
    }
    private void jogoTurbo(ActionEvent actionEvent) {
        Janela janela2= new Janela();
        this.dispose();
        janela2.janelaTurbo();
    }
    private void jogoMaluco(ActionEvent actionEvent) {
        Janela janela3= new Janela();
        this.dispose();
        janela3.JanelaTurboMaluco();
    }
    private void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
    private void ranking(ActionEvent actionEvent) {
    }
    private void voltar(ActionEvent actionEvent) {
        Menu menu =new Menu();
        this.dispose();
        menu.telaMenu();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
