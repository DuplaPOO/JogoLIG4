/*
import java.util.Scanner;


public class Jogador {

    private String nome;
    private Peca peca;
    private int vitorias;
    private int coluna;

    public Jogador(String nome, Peca peca){
        this.nome = nome;
        this.peca = peca;
    }
    public void registrarPeca(Tabuleiro tabuleiro){
        while(true){
            tabuleiro.imprimirTabuleiro();
            System.out.println("Player: " +this.nome+ " | Historico de vitórias: " + this.vitorias );
            System.out.print("Digite a coluna: ");
            Scanner scanner = new Scanner(System.in);
            this.coluna = scanner.nextInt();
            Peca CopiaDoTabuleiro[][] = tabuleiro.getTabuleiro();
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

            int checador = tabuleiro.colisaoDePecas(coluna-1);

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
                tabuleiro.imprimirTabuleiro();
                break;
            }
        }
    }

    public void modificarPecasVizinhas(Tabuleiro tabuleiro){
        Peca[][] tab = tabuleiro.getTabuleiro();
        int linha = tabuleiro.colisaoDePecas(coluna-1);
        if(linha != 5){
            linha += 1;
        }
        Peca posicao = tab[linha][coluna-1];
        if(coluna !=1){
            Peca posicaoEsquerda = tab[linha][coluna-2];
            if(posicao.getPeca() != posicaoEsquerda.getPeca() && posicaoEsquerda.getPeca() != 0){
                tabuleiro.setTabuleiro(linha, coluna-2, this.peca);
            }
        }

        if(coluna!= tab[0].length){
            Peca posicaoDireita = tab[linha][coluna];
            if(posicao.getPeca() != posicaoDireita.getPeca() && posicaoDireita.getPeca() != 0){
                tabuleiro.setTabuleiro(linha, coluna, this.peca);
            }
        }
        tabuleiro.imprimirTabuleiro();
    }



}
*/