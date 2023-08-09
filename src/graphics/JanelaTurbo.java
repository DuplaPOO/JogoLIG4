package graphics;

import componentes.tabuleiro.TabuleiroTurbo;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaTurbo extends JanelaNormal{


    public JanelaTurbo(){
        super();
        this.tabuleiro = new TabuleiroTurbo();
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
        yAtual+=5;

        if (yAtual >= 125 + linha * 100) {
            yAtual = 125 + linha * 100; 
            ((Timer)e.getSource()).stop(); 
            jogadaFeita = false; 
            if(vezDoJogador){
                        tabuleiro.registrarPeca(coluna-1, "Amarelo");
                        tabuleiro.modificarPecasVizinhas(coluna-1, "Amarelo");
                        } else{
                            tabuleiro.registrarPeca(coluna-1, "Azul");
                            tabuleiro.modificarPecasVizinhas(coluna-1, "Azul");
                        }
            repaint(); 
        }
        
	}
  
}
