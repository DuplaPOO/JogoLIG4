package exceptions;

public class JogadorJaExisteException extends Exception {

    //será lançado quando o addjogador tentar adicionar um jogador que já existe
    //ainda implementando isso para registrar os jogadores e utilizar no ranking

    public JogadorJaExisteException(String nomeJogador){
        super("O jogador " + nomeJogador + " ja existe");
    }
    
}
