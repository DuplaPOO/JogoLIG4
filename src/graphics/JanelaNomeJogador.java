package graphics;


import componentes.Jogador;
import jogo.Lig4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class JanelaNomeJogador extends JPanel{
    Menu menu;
    JTextField entradaJogador1,entradaJogador2;
   Janela janela;
   JFrame frame;
   JPanel jPanel;
   Lig4 lig4;
   String nome1, nome2;
   Jogador jogador1,jogador2;
   String modo;
    public JanelaNomeJogador(String modo){
        this.modo = modo;
    }

    public void painelInfos() {
        frame = new JFrame();

        frame.setTitle("REGISTRAR JOGADORES");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);


        jPanel =new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        menu = new Menu();
        JButton voltar = menu.buttonVoltar();
        voltar.setBounds(0, 0, 20, 00);
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton registrar = new JButton("CONFIRMAR");
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

        frame.add(jPanel);
        frame.setVisible(true);
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
        this.nome1 = entradaJogador1.getText();
        this.nome2 = entradaJogador2.getText();
        
        this.jogador1 = new Jogador(this.nome1, "A");
        this.jogador2 = new Jogador(this.nome2, "V");
        System.out.println(jogador1.getNome());
        System.out.println(jogador2.getNome());
        lig4.addJogador(this.jogador1);
        lig4.addJogador(this.jogador2);
        frame.dispose();
            
        janela = new Janela();
        if(modo.equals("NORMAL")){
            janela.janelaNormal(this.jogador1,this.jogador2);
        } else if(modo.equals("TURBO")){
            janela.janelaTurbo(this.jogador1,this.jogador2);
        } else if(modo.equals("TURBO_MALUCO")){
            janela.janelaTurboMaluco(this.jogador1,this.jogador2);
        }
        
    }

}
