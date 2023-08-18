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
    JTextField entradaJogador1,entradaJogador2;
   Janela janela;
   JFrame frame;
   JPanel jPanel;
   Lig4 lig4;
   String nome1, nome2;
   Jogador jogador1,jogador2;
    public JanelaNomeJogador(){
        painelInfos();
    }

    public void painelInfos() {
        //É bom usar o LimiteDeCaracteresException aqui
        frame = new JFrame();


        jPanel =new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        menu = new Menu();
        JButton voltar = menu.buttonVoltar();
        voltar.setBounds(0, 0, 20, 00);
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton registrar = new JButton("REGISTRAR");
        registrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        entradaJogador1 = new JTextField("", 15);
        entradaJogador2 = new JTextField("",15);
        entradaJogador1.setAlignmentX(Component.CENTER_ALIGNMENT);
        entradaJogador2.setAlignmentX(Component.CENTER_ALIGNMENT);
        entradaJogador1.setBackground(Color.blue);
        entradaJogador2.setBackground(Color.yellow);
        entradaJogador1.setPreferredSize(new Dimension(200, 30));
        entradaJogador2.setPreferredSize(new Dimension(200, 30));
        entradaJogador1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        entradaJogador2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        entradaJogador1.setForeground(Color.red);
        entradaJogador2.setForeground(Color.red);
        jPanel.add(entradaJogador1);
        jPanel.add(entradaJogador2);
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

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
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
        nome1 = entradaJogador1.getText();
        nome2 = entradaJogador2.getText();
        this.jogador1 = new Jogador(nome1, "A");
        this.jogador2 = new Jogador(nome2, "V");
        System.out.println(nome1);
        System.out.println(nome2);
        lig4.addJogador(this.jogador1);
        lig4.addJogador(this.jogador2);
    }

}
