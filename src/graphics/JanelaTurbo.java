package graphics;

import componentes.tabuleiro.TabuleiroTurbo;

import java.awt.event.MouseEvent;


public class JanelaTurbo extends JanelaNormal{


    public JanelaTurbo(){
        super();
        this.tabuleiro = new TabuleiroTurbo();
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(!partidaFinalizada){
            boolean jogadaFeita = false;
            if(e.getX()>=100 && e.getX() <=800 && e.getY()>=100 && e.getY() <=700){
                int coluna = (e.getX())/100;
                if(vezDoJogador){
                    jogadaFeita = tabuleiro.registrarPeca(coluna-1, "Amarelo");
                    tabuleiro.modificarPecasVizinhas(coluna-1, "Amarelo");
                } else{
                    jogadaFeita = tabuleiro.registrarPeca(coluna-1, "Azul");
                    tabuleiro.modificarPecasVizinhas(coluna-1, "Azul");
                }
                
                if(jogadaFeita){
                    vezDoJogador = !vezDoJogador;
                }

                repaint();
        
            }
        } else{
            fecharEAbrirMenu();
        }
        
        
    }
  
}
