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
        while(true){
            tabuleiro.imprimirTabuleiro();
            System.out.println("Player: " +this.nome+ " | Pontuacao: " + tabuleiro.getPontuacao() );
            System.out.print("Digite a coluna: ");
            Scanner scanner = new Scanner(System.in);
            int coluna = scanner.nextInt();
            int CopiaDoTabuleiro[][] = tabuleiro.getTabuleiro();
            //ISSO PODERIA SER UM MÉTODO DE VERIFICAÇÃO:
            if(coluna > CopiaDoTabuleiro[0].length){
                try {
                    System.out.println( "Coluna invalida, digite de novo(1 a 7)");
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            int checador = tabuleiro.checarLinhas(coluna-1);

            //ISSO PODERIA SER UM MÉTODO DE VERIFICAÇÃO:
            if(checador == -1){
                try {
                    System.out.println( "A Coluna ja está cheia, digite outro numero");
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            } else {
                tabuleiro.setTabuleiro(checador, coluna-1, this.peca);
                break;
            }
        }
        }







    }


