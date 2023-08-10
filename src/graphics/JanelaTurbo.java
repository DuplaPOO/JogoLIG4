package graphics;

import componentes.tabuleiro.TabuleiroTurbo;
import exceptions.ColunaCheiaException;

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
                        try{
                            tabuleiro.registrarPeca(coluna-1, "Amarelo");
                            tabuleiro.modificarPecasVizinhas(coluna-1, "Amarelo");
                        } catch(ColunaCheiaException err){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println(err.getMessage());
                        }
                } else{
                    try{
                        tabuleiro.registrarPeca(coluna-1, "Azul");
                        tabuleiro.modificarPecasVizinhas(coluna-1, "Azul");
                        } catch(ColunaCheiaException err){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println(err.getMessage());
                        }
                }
            repaint(); 
        }
        
	}
  
}
