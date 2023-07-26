package exceptions;

public class JogadorJaExisteException extends Exception {

    public JogadorJaExisteException(String nomeJogador){
        super("O jogador " + nomeJogador + " ja existe");
    }
    
}
