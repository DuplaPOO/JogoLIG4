package componentes.tabuleiro;

import java.awt.Graphics;

import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public interface InterfaceTabuleiro {

    //método que poderia lançar exceções se fosse no console
    public boolean registrarPeca(int colunaAdicionar, String cor);
    
    public void verificarGanhador(boolean vezDoJogador, Graphics g);

    public void zerarTabuleiro();
    
    public void imprimirPecasTabuleiro(Graphics g);

    public void imprimirTabuleiro();


}
