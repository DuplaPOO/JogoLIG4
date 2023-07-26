package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Gui extends JFrame implements ActionListener {

    private Container cp;

    int linhas = 6;
    int colunas = 7;

    JPanel panel;
    JButton sair;
    JButton jogar;
    JLabel jLabel;
    private  String imgBrancaNome = "images/branco.png";
    private  String imgVemelhaNome = "images/vermelho.png";
    private  String imgAmarelaNome = "images/amarelo.png";
    private ImageIcon iconBranco = null;
    private ImageIcon iconVermelho = null;
    private ImageIcon iconAmarelo = null;

    public Gui(){
        setVisible(true);
        setSize(750,650);
        setTitle("LIG 4 -- ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        jLabel = new JLabel("menu");
        jLabel.setBounds(300,0,180,50);
        jLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(jLabel);

        menu();

    }

    public void menu(){

        jogar = new JButton();
        jogar.setText("JOGAR PARTIDA");
        jogar.setBounds(0,400,250,50);
        jogar.setFont(new Font("Arial", Font.BOLD, 15));
        jogar.setForeground(new Color(255, 255, 255));
        jogar.setBackground(new Color(0, 0, 0));
        add(jogar);
        jogar.addActionListener(this::imprimirTabuleiro);

        sair = new JButton();
        sair.setText("SAIR");
        sair.setBounds(450,400,250,50);
        sair.setFont(new Font("Arial", Font.BOLD, 15));
        sair.setForeground(new Color(255, 255, 255));
        sair.setBackground(new Color(0, 0, 0));
        add(sair);

        panel = new JPanel();
        //panel.add(jogar);

    }

    private void imprimirTabuleiro(ActionEvent actionEvent) {
       // remove(sair);
        //remove(jogar);

        setVisible(true);
        setSize(750,650);
        setTitle("LIG 4 -- ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        URL imgURL = getClass().getClassLoader().getResource(imgBrancaNome);
        if(imgURL !=null ){
            iconBranco = new ImageIcon(imgURL);
        } else {
            System.err.println("Arquivo não encontrado " + imgBrancaNome);
        }
        imgURL = getClass().getClassLoader().getResource(imgVemelhaNome);
        if(imgURL !=null ){
            iconVermelho = new ImageIcon(imgURL);
        } else {
            System.err.println("Arquivo não encontrado " + imgVemelhaNome);
        }

        imgURL = getClass().getClassLoader().getResource(imgAmarelaNome);
        if(imgURL !=null ){
            iconAmarelo = new ImageIcon(imgURL);
        } else {
            System.err.println("Arquivo não encontrado " + imgAmarelaNome);
        }

        cp = getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        for (int linha = 0; linha < linhas ; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                JButton button = new JButton();
                button.setIcon(iconBranco);
                button.setPreferredSize(new Dimension(100,100));
                cp.add(button);
            }

        }
    }





    @Override
    public void actionPerformed(ActionEvent e) {


    }







    public static void main(String[] args) {

        Gui gui = new Gui();

    }



}
