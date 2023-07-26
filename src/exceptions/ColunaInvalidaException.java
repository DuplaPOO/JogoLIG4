package exceptions;
public class ColunaInvalidaException extends Exception {

    public ColunaInvalidaException(int coluna){
        super("A coluna " + coluna+1 + " eh invalida! Digite uma coluna entre 1 e 7");
    }
    
}
