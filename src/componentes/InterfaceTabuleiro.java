package componentes;

import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public interface InterfaceTabuleiro {

    boolean registrarPeca(int colunaAdicionar, String cor) throws ColunaInvalidaException, ColunaCheiaException;
    
    boolean verificarGanhador();
    
    void zerarTabuleiro();
    
    void imprimirTabuleiro();

}
