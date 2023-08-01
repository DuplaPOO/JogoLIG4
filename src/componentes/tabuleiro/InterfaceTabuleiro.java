package componentes.tabuleiro;

import java.awt.Graphics;

import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public interface InterfaceTabuleiro {

    //método que poderia lançar exceções se fosse no console
    public boolean registrarPecaConsole(int colunaAdicionar, String cor) throws ColunaCheiaException, ColunaInvalidaException;

    public boolean registrarPeca(int colunaAdicionar, String cor);
    
    public void verificarGanhador(boolean vezDoJogador, Graphics g);

    public boolean verificarGanhadorConsole();

    public void zerarTabuleiro();
    
    public void imprimirPecasTabuleiro(Graphics g);

    public void imprimirTabuleiroConsole();



    //métodos opcionais
    default public void modificarPecasVizinhas(int coluna, String cor){}

    //Turbo maluco:
    default public void calcularIncrementos(int linha, int coluna){}

    default public void atualizarMaluquice() {}

    //coloco para retornar 1.2 só para satisfazer o requisito de ser double, mas o método é definido em tabuleiro Turbo Maluco
    default public double getMaluquice(){return 1.2;}
}
