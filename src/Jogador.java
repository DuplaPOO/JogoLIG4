import java.util.Scanner;


public class Jogador {

    private String nome;
    private int peca;
    private Posicao posicao;

    public Jogador(String nome, int peca){
        this.nome = nome;
        this.posicao = posicao;
        this.peca = peca;
    }
    public void registrarPeca(Tabuleiro tabuleiro){

        System.out.println("Player: " +this.nome+ " | Pontuacao: " + tabuleiro.getPontuacao() );
        System.out.print("Digite a coluna: ");
        Scanner scanner = new Scanner(System.in);
        int coluna = scanner.nextInt();
        int checador= tabuleiro.checarLinhas(tabuleiro, coluna-1);
            if(checador ==0){
                System.out.println( "A Coluna ja está cheia, digite outro numero");
            } else {
                tabuleiro.setTabuleiro(checador, coluna-1, this.peca);
                tabuleiro.imprimirTabuleiro();
            }
        }







    }


