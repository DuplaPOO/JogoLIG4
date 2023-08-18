package graphics;


import componentes.Jogador;
import componentes.JogadorData;
import jogo.Lig4;
import jogo.Lig4Jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class JanelaNomeJogador extends JPanel{

   Menu menu;
    JTextField jogador1,jogador2;
   Janela janela;
   JPanel jPanel;
   Lig4 lig4;

   String nome1, nome2;
   Jogador Jnome1,Jnome2;
    public JanelaNomeJogador(){
        painelInfos();
    }

    public void painelInfos() {
        //É bom usar o LimiteDeCaracteresException aqui
        jPanel =new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        menu = new Menu();
        JButton voltar = menu.buttonVoltar();
        voltar.setBounds(0, 0, 20, 00);
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton registrar = new JButton("REGISTRAR");
        registrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogador1 = new JTextField("", 15);
        jogador2 = new JTextField("",15);
        jogador1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogador2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogador1.setBackground(Color.YELLOW);
        jogador2.setBackground(Color.blue);
        jogador1.setPreferredSize(new Dimension(200, 30));
        jogador2.setPreferredSize(new Dimension(200, 30));
        jogador1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        jogador2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        jogador1.setForeground(Color.red);
        jogador2.setForeground(Color.red);
        jPanel.add(jogador1);
        jPanel.add(jogador2);
        jPanel.add(registrar);
        registrar.addActionListener(actionEvent -> {
            try {
                registrarNormal(actionEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        jPanel.add(voltar);
        add(jPanel);
    }

    private void registrarNormal(ActionEvent actionEvent) throws IOException {
        lig4 = new Lig4() {
            @Override
            protected void jogarPartida(Jogador jogador1, Jogador jogador2) {

            }

            @Override
            protected void reset() {

            }
        };




        janela = new Janela();
        nome1 = jogador1.getText();
        nome2 = jogador2.getText();
        Jnome1 = new Jogador(nome1, "A");
        Jnome2 = new Jogador(nome2, "V");
        janela.janelaNormal();
        System.out.println(nome1);
        System.out.println(nome2);


        lig4.addJogador(Jnome1);

        lig4.addJogador(Jnome2);

    }








}
