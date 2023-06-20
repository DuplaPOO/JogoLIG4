import java.util.Scanner;


public class JOGADOR {
    private String nome;
    private int pontuacão;
    private boolean vez;
    // private Peca Peca;

    public JOGADOR(String Nome){
        this.nome = Nome;
    }

    public void RegistrarPeca(TABULEIRO tabuleiro){
        System.out.print("Digite a coluna: ");
        Scanner scanner = new Scanner(System.in);

        int coluna = scanner.nextInt();

        tabuleiro.setTabuleiro(6, coluna, 1);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        tabuleiro.ImprimirTabuleiro();

        scanner.close();



    }
}
