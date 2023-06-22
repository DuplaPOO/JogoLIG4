public class Tabuleiro {

    private int[][] tabuleiro = {{0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
    };
    private int[] colunas;
    private int[] fileiras;
    private int zerar;

    private int pontuacao;


    public Tabuleiro(){
        imprimirTabuleiro();
    }

    public void zerarTabuleiro(int zerar){
        if (zerar == 1){
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j <tabuleiro[i].length ; j++) {
                    tabuleiro[i][j] = 0;
                }
            }
        } else {
            System.out.println("Obrigado por jogar");
        }
        
    }
    public void imprimirTabuleiro(){
        LimparTela();
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    public boolean tabuleiroCompleto(){
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j <tabuleiro[i].length ; j++) {
                if(tabuleiro[i][j] == 0){
                    return false;
                } else {

                }
            }
        }
        return true;
    }

    //VER SE JÁ TEM UMA PEÇA NA POSIÇÃO(PEÇA EM CIMA DE PEÇA)
    public int checarLinhas(int x) {
        int[][] A = this.tabuleiro;
        int linha;
        for (linha = 0; linha < 6; linha++) {
            int i1 = A[linha][x];
            if (i1 == 1 || i1 == -1) {
                break;
            }
            if(A[0][x] == 1 || A[0][x] == -1 ){
                System.out.println("coluna cheia, digite outra coluna");
                return 0;
            }
        }
        return --linha;
    }

    public boolean verificarPontoHorizontal() {
        int[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                int peca1 = A[linha][coluna];
                int peca2 = A[linha][coluna + 1];
                int peca3 = A[linha][coluna + 2];
                int peca4 = A[linha][coluna + 3];
                if(peca1 != 0 && peca1 == peca2 && peca2 == peca3 && peca3 == peca4){
                    this.pontuacao++;
                }
            }
        }
        if(this.pontuacao == 1){
            return true;
        } else {
            return false;
        }
    }
    public boolean verificarPontoVertical() {
        int[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                int peca1 = A[linha][coluna];
                int peca2 = A[linha + 1][coluna];
                int peca3 = A[linha + 2][coluna];
                int peca4 = A[linha + 3][coluna];
                if(peca1 != 0 && peca1 == peca2 && peca2 == peca3 && peca3 == peca4){
                    this.pontuacao++;
                }
            }
        }
        if(this.pontuacao == 1){
            return true;
        } else{
            return false;
        }
    }
    public boolean verificarDiagonal1(){
        int[][] A = this.tabuleiro;

        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                int peca1 = A[linha][coluna];
                int peca2 = A[linha + 1][coluna + 1];
                int peca3 = A[linha + 2][coluna + 2];
                int peca4 = A[linha + 3][coluna + 3];
                if(peca1 != 0 && peca1 == peca2 && peca2 == peca3 && peca3 == peca4){
                    this.pontuacao++;
                }
            }
        }
        if(this.pontuacao == 1){
            return true;
        } else{
            return false;
        }
    }
    public boolean verificarDiagonal2(){
        int[][] A = this.tabuleiro;

        for (int linha = A.length - 1; linha >= 3; linha--) {
            for (int coluna = 0; coluna < A[linha].length - 3; coluna++) {
                int peca1 = A[linha][coluna];
                int peca2 = A[linha - 1][coluna + 1];
                int peca3 = A[linha - 2][coluna + 2];
                int peca4 = A[linha - 3][coluna + 3];
                if(peca1 != 0 && peca1 == peca2 && peca2 == peca3 && peca3 == peca4){
                    this.pontuacao++;
                }
            }
        }
        if(this.pontuacao == 1){
            return true;
        } else{
            return false;
        }
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public int[][] getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(int fileira, int coluna, int valor){
            tabuleiro[fileira][coluna] = valor;
    }

    public int getZerar() {
        return zerar;
    }
    public void setZerar(int zerar) {
        this.zerar = zerar;
    }

    public void LimparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
