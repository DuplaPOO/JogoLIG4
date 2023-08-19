package graphics;

import componentes.JogadorData;
import jogo.Lig4;
import jogo.Lig4Jogo;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;




public class JanelaRanking extends JPanel{
    private ArrayList<JogadorData> jogadorList;
    public Lig4 lig4 = new Lig4Jogo();
    JLabel jLabel;

    public Menu menu;

    public JanelaRanking() {
        menu = new Menu();
    }

    protected void fecharEAbrirMenu() {
        menu.telaMenu();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    public ArrayList<JogadorData> rankingJogadores() {
        ArrayList<JogadorData> jogadoresList = lig4.carregarJogadoresDoJSON();
        jogadoresList.sort(Comparator.comparingInt(JogadorData::getVitorias).reversed());
        return jogadoresList;
    }

    @Override
    public void paintComponent(Graphics g){
        //Fundo da janela
        g.setColor(Color.RED);
        g.fillRect(0, 0, 900, 900);

        //Fundo da janela
        g.setColor(Color.BLUE);
        g.fillRect(100, 50, 700, 700);

        g.setColor(Color.yellow);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.drawString("RANKING", 355, 85);

        jogadorList = rankingJogadores();

        int indice = 0;
        for (JogadorData jogador : jogadorList) {
            g.setColor(Color.yellow);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            g.drawString((indice+1)+"º Lugar - "+jogador.getNome()+" - Vitórias: "+ jogador.getVitorias(), 150, 130 + indice*65);
            if(indice>=9){
                break;
            }
            indice++;
        }

        g.setColor(Color.WHITE);
        g.drawString("Pressione Enter para voltar...", 300, 780);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    fecharEAbrirMenu();
                }
                return false;
            }
        });
        

    }

    
}


