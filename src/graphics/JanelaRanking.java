package graphics;
import componentes.Jogador;
import componentes.JogadorData;
import jogo.Lig4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;




public class JanelaRanking {

    private ArrayList<JogadorData> jogadorList;
    public Lig4 lig4 = new Lig4() {
        @Override
        protected void jogarPartida(Jogador jogador1, Jogador jogador2) {

        }

        @Override
        protected void reset() {

        }
    };

    public Menu menu;

    public JanelaRanking() {
        janelaRanking();
    }

    public ArrayList<JogadorData> rankingJogadores() {
        ArrayList<JogadorData> jogadoresList = lig4.carregarJogadoresDoJSON();
        jogadoresList.sort(Comparator.comparingInt(JogadorData::getVitorias).reversed());
        return jogadoresList;
    }
    private void janelaRanking() {
        menu = new Menu();

        jogadorList = rankingJogadores();

        JFrame frame = new JFrame();
        frame.setTitle("RANKING JOGADORES");
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        StringBuilder rankingText = new StringBuilder();
        int posicao = 1;
        for (JogadorData jogador : jogadorList) {
            rankingText.append(posicao).append("º Lugar - ").append(jogador.getNome()).append(" - Vitórias: ").append(jogador.getVitorias()).append("\n");
            posicao++;
        }
        textArea.setText(rankingText.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.NORTH);


        JButton voltarButton = menu.buttonVoltar();
        voltarButton.setPreferredSize(new Dimension(150, 30));
        voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(voltarButton);
        buttonPanel.add(Box.createHorizontalGlue());

        panel.add(buttonPanel);

        frame.add(panel);
        frame.setVisible(true);
    }
}


