package graphics;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaNomeJogador extends JPanel{

   Menu menu;
    JTextField jogador1,jogador2;
   Janela janela;
   JPanel jPanel;

   String nome1, nome2;
    public JanelaNomeJogador(){
        painelInfos();
    }

    public void painelInfos() {
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
        registrar.addActionListener(this::registrarNormal);
        jPanel.add(voltar);
        add(jPanel);
    }

    private void registrarNormal(ActionEvent actionEvent) {
        janela = new Janela();
        nome1 = jogador1.getText();
        nome2 = jogador2.getText();
        janela.janelaNormal();
        System.out.println(nome1);
        System.out.println(nome2);
    }






}
