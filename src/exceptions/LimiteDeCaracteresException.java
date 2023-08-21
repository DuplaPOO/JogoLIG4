package exceptions;

public class LimiteDeCaracteresException extends Exception{
    
    public LimiteDeCaracteresException(){
        super("Limite de caracteres excedido! (máximo de 20 caracteres)");
    }
    
}
