public class Tabuleiro {

    public static final int linhas = 6;
    public static final int colunas = 7;
    private Peca[][] tabuleiro = new Peca[linhas][colunas];
    public Tabuleiro(){
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                tabuleiro[i][j] = null;
            }
        }
    }
    public void imprimirTabuleiro(){

        System.out.println();

        for (int i = 0; i < linhas ; i++) {
            System.out.print("|");
            for (int j = 0; j < colunas; j++) {
                if(tabuleiro[i][j] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(tabuleiro[i][j].getCor());
                }
                System.out.print("|");
            }
            System.out.println();
        }

        System.out.println();

    }
    //TROUXE O REGISTRAR PEÇA DO JOGADOR PARA O TABULEIRO, O JOGADOR APENAS REALIZA A JOGADA, MAS O TABULEIRO QUE REGISTRA
    public boolean registrarPeca(int colunaAdicionar, String cor) {

        if (colunaAdicionar >= 0 && colunaAdicionar < colunas) {
            if (tabuleiro[0][colunaAdicionar] == null) {
                boolean pecaAdicionar = false;
                for (int i = linhas - 1; i >= 0; i--) {
                    if (tabuleiro[i][colunaAdicionar] == null) {
                        tabuleiro[i][colunaAdicionar] = new Peca();
                        tabuleiro[i][colunaAdicionar].setCor(cor);
                        pecaAdicionar = true;
                        break;
                    }
                }
                return pecaAdicionar;
            } else {
                //linha cheia
                System.out.println("++++++++++++++++++");
                System.out.println("COLUNA ESTÁ CHEIA");
                System.out.println("++++++++++++++++++");
                return false;
            }
        } else {
            System.out.println("++++++++++++++++++++++");
            System.out.println("DIGITE UM NUMERO DE 1 A 7");
            System.out.println("++++++++++++++++++++++");
            return false;
        }
    }
    public boolean verificarHorizontal( String corVencendo) {
        Peca[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha][coluna + 1];
                Peca peca3 = A[linha][coluna + 2];
                Peca peca4 = A[linha][coluna + 3];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null &&
                        peca1.getCor().equals(corVencendo) && peca2.getCor().equals(corVencendo) && peca3.getCor().equals(corVencendo)) {
                    return true;
                }

            }
        }
        return false;
    }
    public boolean verificarVertical(String corVencendo) {
        Peca[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha + 1][coluna];
                Peca peca3 = A[linha + 2][coluna];
                Peca peca4 = A[linha + 3][coluna];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null &&
                        peca1.getCor().equals(corVencendo) && peca2.getCor().equals(corVencendo) && peca3.getCor().equals(corVencendo)) {
                    return true;
                }

            }
        }
        return false;
    }
    public boolean verificarDiagonal1(String corVencendo){
        Peca[][] A = this.tabuleiro;

        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha + 1][coluna + 1];
                Peca peca3 = A[linha + 2][coluna + 2];
                Peca peca4 = A[linha + 3][coluna + 3];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null &&
                        peca1.getCor().equals(corVencendo) && peca2.getCor().equals(corVencendo) && peca3.getCor().equals(corVencendo)) {
                    return true;
                }

            }
        }
        return false;
    }
    public boolean verificarDiagonal2(String corVencendo){
        Peca[][] A = this.tabuleiro;

        for (int linha = A.length - 1; linha >= 3; linha--) {
            for (int coluna = 0; coluna < A[linha].length - 3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha - 1][coluna + 1];
                Peca peca3 = A[linha - 2][coluna + 2];
                Peca peca4 = A[linha - 3][coluna + 3];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null &&
                        peca1.getCor().equals(corVencendo) && peca2.getCor().equals(corVencendo) && peca3.getCor().equals(corVencendo)) {
                    return true;
                }

            }
        }
        return false;
    }
    public boolean verificarGanhandor(String corVencendo){
        if(verificarVertical(corVencendo)==true|| verificarHorizontal(corVencendo) == true || verificarDiagonal1(corVencendo) == true || verificarDiagonal2(corVencendo) == true){
            return true;
        }
        else  {
            return false;
        }
    }
    public void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void zerarTabuleiro(){
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Peca();
            }
        }

    }


    


}
