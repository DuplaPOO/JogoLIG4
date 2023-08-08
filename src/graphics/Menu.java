package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton sair;
    JButton jogar;JButton jogarTurbo;JButton jogarMaluco, voltar,rank;
    JLabel jLabel;
    Janela janela;
    JPanel jPanel;


    public Menu(){

    }

    public void inicioJogo(){
        janela = new Janela();
        janela.janelaNomeJogador();
    }

    public void telaMenu(){
        setVisible(true);
        setSize(900,900);
        setTitle("LIG 4 -- ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.red);

        jLabel = new JLabel("LIG 4");
        jLabel.setBounds(375,0,300,60);
        jLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        jLabel.setForeground(Color.yellow);
        add(jLabel);
        menu();
    }

    public void menu(){
        janela = new Janela();

        setLayout(null);
        jogar = buttonJogar();
        jogar.setBounds(295,150,300,60);
        add(jogar);

        jogarTurbo = buttonJogarTurbo();
        jogarTurbo.setBounds(295,250,300,60);
        add(jogarTurbo);

        jogarMaluco = buttonJogarTurboMaluco();
        jogarMaluco.setBounds(295,350,300,60);
        add(jogarMaluco);

        rank = buttonRanking();
        rank.setBounds(295,450,300,60);
        add(rank);



    }

    //BOTÕES
    public JButton buttonVoltar() {
        JButton voltar = new JButton();
        voltar.setText("VOLTAR");
        voltar.setFont(new Font("Arial", Font.BOLD, 15));
        voltar.setForeground(new Color(0, 0, 0));
        voltar.setBackground(new Color(255, 255, 255));

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        return voltar;
    }





    private JButton buttonRanking() {
        rank = new JButton();
        rank.setText("RANKING");
        rank.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        rank.setForeground(Color.YELLOW);
        rank.setBackground(Color.BLUE);
        add(rank);
        rank.addActionListener(this::ranking);
        return rank;
    }
    private JButton buttonSair() {
        sair = new JButton();
        sair.setText("SAIR");
        sair.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        sair.setForeground(Color.YELLOW);
        sair.setBackground(Color.BLACK);
        add(sair);
        sair.addActionListener(this::sair);
        return sair;
    }
    private JButton buttonJogar() {
        jogar = new JButton();
        jogar.setText("JOGO NORMAL");
        jogar.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        jogar.setForeground(Color.YELLOW);
        jogar.setBackground(Color.BLUE);
        add(jogar);
        jogar.addActionListener(this::jogoNormal);
        return jogar;
    }
    private JButton buttonJogarTurbo() {
        jogarTurbo = new JButton();
        jogarTurbo.setText("JOGO TURBO");
        jogarTurbo.setBounds(220, 200, 250, 50);
        jogarTurbo.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        jogarTurbo.setForeground(Color.YELLOW);
        jogarTurbo.setBackground(Color.BLUE);
        add(jogarTurbo);
        jogarTurbo.addActionListener(this::jogoTurbo);
        return jogarTurbo;
    }
    private JButton buttonJogarTurboMaluco() {
        jogarMaluco = new JButton();
        jogarMaluco.setText("JOGO MALUCO");
        jogarMaluco.setBounds(220, 300, 250, 50);
        jogarMaluco.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        jogarMaluco.setForeground(Color.YELLOW);
        jogarMaluco.setBackground(Color.BLUE);
        add(jogarMaluco);
        jogarMaluco.addActionListener(this::jogoMaluco);
        return jogarMaluco;
    }



    //EVENTOS DOS CLICKS DOS BOTOES
    private void jogoNormal(ActionEvent actionEvent) {
        janela.janelaNomeJogador();
        this.dispose();
    }
    private void jogoTurbo(ActionEvent actionEvent) {
        janela.janelaTurbo();
        this.dispose();
    }
    private void jogoMaluco(ActionEvent actionEvent) {
        janela.JanelaTurboMaluco();
        this.dispose();
    }
    private void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
    private void ranking(ActionEvent actionEvent) {
    }
    private void voltar() {
        Menu menu = new Menu();
        menu.telaMenu();

        this.dispose();
    }


    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
