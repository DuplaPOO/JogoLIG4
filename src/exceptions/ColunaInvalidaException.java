package exceptions;
public class ColunaInvalidaException extends Exception {

    public ColunaInvalidaException(int coluna){
        super("A coluna " + coluna + " eh invalida! Digite um coluna entre 1 e 7");
    }
    
    //Seria um exception utilizado no console
}
