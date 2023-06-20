public class JOGO {
    public static void main(String[] args) throws Exception {
        TABULEIRO tabuleiro = new TABULEIRO();
        JOGADOR jogador = new JOGADOR("Player");

        jogador.RegistrarPeca(tabuleiro);
    }
}
