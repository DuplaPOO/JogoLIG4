import java.util.Scanner;


public class Jogador {

    private String nome;
    private int pontuacão;
    private boolean vez;
    private Posicao posicao;



    public Jogador(String nome){
        this.nome = nome;
        this.posicao = posicao;
    }



    public void registrarPeca(Tabuleiro tabuleiro){
        System.out.print("Digite a coluna: ");
        Scanner scanner = new Scanner(System.in);
        int coluna = scanner.nextInt();
        int checado = checarLinhas(tabuleiro, coluna);
        tabuleiro.setTabuleiro(checado, coluna, 1);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        tabuleiro.criarTabuleiro();
        scanner.close();
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


}
