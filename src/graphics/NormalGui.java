package graphics;

import jogo.Lig4Jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class NormalGui extends JFrame {
    private  String imgBrancaNome = "images/branco.png";
    private  String imgVemelhaNome = "images/vermelho.png";
    private  String imgAmarelaNome = "images/amarelo.png";
    private ImageIcon iconBranco = null;
    private ImageIcon iconVermelho = null;
    private ImageIcon iconAmarelo = null;
    private Container cp;
    int linhas = 6;
    int colunas = 7;
    private Lig4Jogo lig4Jogo;

    public NormalGui(){
        lig4Jogo = new Lig4Jogo();
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


                button.setName(Integer.toString(linha*10 + coluna));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        atualizarPeca(button);
                    }
                });

                cp.add(button);
            }
        }
    }

    private void atualizarPeca(JButton button) {

    }
}
