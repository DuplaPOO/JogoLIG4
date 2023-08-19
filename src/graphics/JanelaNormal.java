package graphics;


import componentes.Jogador;
import componentes.JogadorData;
import componentes.tabuleiro.InterfaceTabuleiro;
import componentes.tabuleiro.Tabuleiro;
import exceptions.ColunaCheiaException;
import jogo.Lig4;
import jogo.Lig4Jogo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;


public class JanelaNormal extends JPanel implements MouseListener, MouseMotionListener, ActionListener{
    protected InterfaceTabuleiro tabuleiro;
    protected boolean vezDoJogador;
    protected boolean partidaFinalizada;
    Font minhaFont = new Font("Arial", Font.BOLD , 30 );
    protected Image imgTrofeu;
    protected int yInicial;
    protected int yAtual;
    protected int linha;
    protected boolean jogadaFeita;

    protected int coluna;
    Menu menu;
    ArrayList<JogadorData> jogadorList;
    protected JogadorData jogadorData1,jogadorData2;
    protected Jogador jogador1,jogador2;
    
    Lig4Jogo lig4Jogo = new Lig4Jogo();
    Lig4 lig4;
    public JanelaNormal(Jogador jogador1, Jogador jogador2){
        
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        addMouseMotionListener(this);
        addMouseListener(this);
        this.tabuleiro = new Tabuleiro();
        this.vezDoJogador = true;
        this.yInicial = 40;
        this.jogadaFeita = false;
        this.linha = -1;
        this.coluna = -1;
        menu = new Menu();
        try{
            imgTrofeu = ImageIO.read(getClass().getResource("/images/imgTrofeu.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    protected void fecharEAbrirMenu() {
        menu.telaMenu();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
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

        
        jogadorList = new ArrayList<JogadorData>();
        jogadorList = lig4.carregarJogadoresDoJSON();



        designTabuleiro(g);
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

                for (JogadorData jogadorData : jogadorList) {
                    if (jogadorData.getNome().equals(jogador1.getNome())) {
                        jogadorData1 = jogadorData;
                        break;
                    }
                }



                jogador1.addVitoria();
                if (jogadorData1 != null) {
                    jogadorData1.incrementVitorias();
                } else {
                    jogadorData1= new JogadorData(jogador1.getNome(), jogador1.getVitorias());
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


                for (JogadorData jogadorData : jogadorList) {
                    if (jogadorData.getNome().equals(jogador2.getNome())) {
                        jogadorData2 = jogadorData;
                        break;
                    }
                }


                jogador2.addVitoria();
                if (jogadorData2 != null) {
                    jogadorData2.incrementVitorias();
                } else {
                    jogadorData2= new JogadorData(jogador2.getNome(), jogador2.getVitorias());
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



    public void designTabuleiro(Graphics g){
        g.setFont(minhaFont);

        Color vinho = new Color(128, 0, 0);
        Color azulClaro = new Color(135, 185, 205);

        //Fundo da janela
        g.setColor(azulClaro);
        g.fillRect(0, 0, 900, 900);
        
        //Fundo do tabuleiro
        g.setColor(Color.red);
        g.fillRect(100, 100, 700, 600);

        //coluna que o mouse passa por cima
        if(coluna >=1 & coluna<=7){
            g.setColor(vinho);
            g.fillRect(coluna*100, 100, 100, 600);
            if(!jogadaFeita){
                if(tabuleiro.pegarLinha(coluna-1)!=-1){
                    if(vezDoJogador){
                        g.drawImage(tabuleiro.getCirculoAzul(), 127 + (coluna-1) * 100, 40, 50, 50, null);
                    } else{
                        g.drawImage(tabuleiro.getCirculoAmarelo(), 127 + (coluna-1) * 100, 40, 50, 50, null);
                    }
                }

            }
        }
        
        tabuleiro.imprimirPecasTabuleiro(g);

        if(this.jogadaFeita){
            if(vezDoJogador){
                g.drawImage(tabuleiro.getCirculoAmarelo(), 127 + (coluna-1) * 100, yAtual, 50, 50, null);
            } else{
                g.drawImage(tabuleiro.getCirculoAzul(), 127 + (coluna-1) * 100, yAtual, 50, 50, null);
            }
        }
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
        yAtual+=10;

        if (yAtual >= 125 + linha * 100) {
            yAtual = 125 + linha * 100; 
            ((Timer)e.getSource()).stop(); 
            jogadaFeita = false; 
            if(vezDoJogador){
                try{
                    tabuleiro.registrarPeca(coluna-1, "Amarelo");
                } catch(ColunaCheiaException err){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(err.getMessage());
                }
            } else{
                try{
                tabuleiro.registrarPeca(coluna-1, "Azul");
                } catch(ColunaCheiaException err){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(err.getMessage());
                }
            }
            repaint(); 
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
                        
                        this.yAtual = this.yInicial;
                        Timer timer = new Timer(10,this);
                        timer.start();
                            
                        vezDoJogador = !vezDoJogador;
                        

                    repaint();
                }
            }
        }
        
        
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    public void mouseMoved(MouseEvent e) {
        
        if(!partidaFinalizada){
            if(!this.jogadaFeita){
                this.coluna = -1;
                if(e.getPoint().getX()>=100 && e.getPoint().getX() <=800 && e.getPoint().getY()>=100 && e.getPoint().getY() <=700){
                    this.coluna=(int)e.getPoint().getX()/100;
                }
                repaint();
            }
        }
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    
    
}
