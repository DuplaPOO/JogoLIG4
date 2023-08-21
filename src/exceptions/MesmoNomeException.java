package exceptions;

public class MesmoNomeException extends Exception{
    
    public MesmoNomeException(){
        super("Nomes de jogadores iguais, modifique-os!");
    }
}
