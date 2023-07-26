package exceptions;

public class ColunaCheiaException extends Exception {

    public ColunaCheiaException(int coluna){
        super("Coluna " + coluna+1 + " cheia");
    }
    
}
