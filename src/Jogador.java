import java.util.Scanner;


public class Jogador {

    private String nome;
    private int pontuacao;
    private int peca;
    private Posicao posicao;



    public Jogador(String nome, int peca){
        this.nome = nome;
        this.posicao = posicao;
        this.peca = peca;
        this.pontuacao = 0;
    }



    public void registrarPeca(Tabuleiro tabuleiro){
        System.out.println("Player: " +this.nome+ " | Pontuacao: " +this.pontuacao);
        System.out.print("Digite a coluna: ");
        Scanner scanner = new Scanner(System.in);
        int coluna = scanner.nextInt();
        int checado = checarLinhas(tabuleiro, coluna-1);
        tabuleiro.setTabuleiro(checado, coluna-1, this.peca);
        tabuleiro.ImprimirTabuleiro();

    }


    /* TALVEZ A CHECAGEM DE LINHAS DEVA FICAR NA CLASSE TABULEIRO */
    public int checarLinhas(Tabuleiro tabuleiro, int x) {
        int[][] A = tabuleiro.getTabuleiro();

        int linha;
        for (linha = 0; linha < 6; linha++) {
            int i1 = A[linha][x];
            if (i1 == 1 || i1 == -1) {
                break;
            }
        }
        return --linha;

    }

    public boolean VerificarPontoHorizontal(Tabuleiro tabuleiro) {
        int[][] A = tabuleiro.getTabuleiro();

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
        } else{
            return false;
        }
    }

    // POR ALGUM MOTIVO, ESSA É A UNICA QUE NÃO FUNCIONA
    public boolean verificarPontoVertical(Tabuleiro tabuleiro) {
        int[][] A = tabuleiro.getTabuleiro();

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


    // "\"
    public boolean VerificarDiagonal1(Tabuleiro tabuleiro){
        int[][] A = tabuleiro.getTabuleiro();

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



    // "/"
    public boolean VerificarDiagonal2(Tabuleiro tabuleiro){
        int[][] A = tabuleiro.getTabuleiro();

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


}

