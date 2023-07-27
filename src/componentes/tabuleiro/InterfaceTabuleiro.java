package componentes.tabuleiro;

import java.awt.Graphics;

import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public interface InterfaceTabuleiro {

    boolean registrarPeca(int colunaAdicionar, String cor);
    
    boolean verificarGanhador();
    
    void zerarTabuleiro();
    
    void imprimirPecasTabuleiro(Graphics g);

    void imprimirTabuleiro();

}
