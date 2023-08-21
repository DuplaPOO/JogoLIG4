package graphics;

import componentes.Jogador;
import componentes.tabuleiro.TabuleiroTurboMaluco;
import jogo.Lig4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class JanelaTurboMaluco extends JanelaTurbo{

    public JanelaTurboMaluco(Jogador jogador1, Jogador jogador2){
        super(jogador1, jogador2);
        this.tabuleiro = new TabuleiroTurboMaluco();
    }

    @Override
    public void paintComponent(Graphics g){
        lig4=new Lig4() {
            @Override
            protected void jogarPartida(Jogador jogador1, Jogador jogador2) {

            }

            @Override
            protected void reset() {

            }
        };

        
        jogadorList = new ArrayList<Jogador>();
        jogadorList = lig4.carregarJogadoresDoJSON();



        designTabuleiro(g);
        g.setColor(Color.red);
        g.drawString("Maluquice: " + String.format("%.1f", tabuleiro.getMaluquice()*100) + "%", 50, 750);
        partidaFinalizada = tabuleiro.verificarGanhador();
        if(partidaFinalizada){
            Color azulClaro = new Color(135, 185, 205);
            g.setColor(azulClaro);
            g.fillRect(0, 0, 900, 900);
            g.setColor(Color.red);
            g.fillRect(100, 100, 700, 250);
            g.drawImage(imgTrofeu, 100, 100, 250, 250, null);


            if(!vezDoJogador){
                g.setColor(Color.blue);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
                g.drawString(jogador1.getNome() + " venceu!", 360, 250);
                g.setColor(Color.white);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                g.drawString("Pressione Enter para voltar...", 300, 650);

                for (Jogador jogadorData : jogadorList) {
                    if (jogadorData.getNome().equals(jogador1.getNome())) {
                        jogadorData1 = jogadorData;
                        break;
                    }
                }



                jogador1.addVitoria();
                if (jogadorData1 != null) {
                    jogadorData1.addVitoria();
                } else {
                    jogadorData1= new Jogador(jogador1.getNome(), jogador1.getVitorias());
                    jogadorList.add(jogadorData1);
                }

                System.out.println("O jogador "+jogador1.getNome() +" venceu");



            } else{
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
                g.drawString(jogador2.getNome() + "venceu!", 340, 250);
                g.setColor(Color.white);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                g.drawString("Pressione Enter para voltar...", 300, 650);


                for (Jogador jogadorData : jogadorList) {
                    if (jogadorData.getNome().equals(jogador2.getNome())) {
                        jogadorData2 = jogadorData;
                        break;
                    }
                }


                jogador2.addVitoria();
                if (jogadorData2 != null) {
                    jogadorData2.addVitoria();
                } else {
                    jogadorData2= new Jogador(jogador2.getNome(), jogador2.getVitorias());
                    jogadorList.add(jogadorData2);
                }
                System.out.println("O jogador "+ jogador2.getNome() + " venceu");


            }

            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ENTER) {
                        fecharEAbrirMenu();
                    }
                    return false;
                }
            });

            lig4.salvarJogadoresNoJSON(jogadorList);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(!jogadaFeita){
            if(!partidaFinalizada){
                if(e.getX()>=100 && e.getX() <=800 && e.getY()>=100 && e.getY() <=700){
                    this.coluna = (e.getX())/100;
                    this.linha = tabuleiro.pegarLinha(coluna-1);
                    if(this.linha!=-1){
                        this.jogadaFeita = true;
                    }
                    
                    if(this.jogadaFeita){
                        this.yAtual = this.yInicial;
                        Timer timer = new Timer(10,this);
                        timer.start();
                        if(this.yAtual== 125 + linha * 100){
                            timer.stop();
                            this.jogadaFeita = false;
                            
                        }
                        tabuleiro.atualizarMaluquice();
                        vezDoJogador = !vezDoJogador;
                    }

                    repaint();
                }
            } 
        }
        
    }

}
