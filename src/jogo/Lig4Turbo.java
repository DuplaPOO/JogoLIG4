package jogo;

import java.util.Scanner;

public class Lig4Turbo extends Lig4Jogo {
    


    public Lig4Turbo(String cor1, String cor2){
        super(cor1, cor2);
    }

    public void jogarPartida(){
        while (true){
            limparTela();
            tabuleiro.imprimirTabuleiro();
            String cor;
            if(jogador){
                cor = cor1;
                System.out.println("Vez da cor " + cor1);
            } else {
                cor = cor2;
                System.out.println("Vez da cor " + cor2);
            }

            System.out.println("Digite a coluna");
            System.out.println("Escolha entre 1 a 7");
            Scanner leitura = new Scanner(System.in);
            int coluna = leitura.nextInt();
            coluna--;


            boolean pecaAdicionada = tabuleiro.registrarPeca(coluna, cor);
            tabuleiro.modificarPecasVizinhas(cor, coluna);
            limparTela();
            tabuleiro.imprimirTabuleiro();

            if(pecaAdicionada){
                jogadas++;
                if(checarVencedor()){
                    tabuleiro.imprimirTabuleiro();
                    if(jogador){
                        System.out.println("componentes.Jogador" +cor1 +"venceu");
                    } else {
                        System.out.println("componentes.Jogador" +cor2 + "venceu");
                    }

                    System.out.println("Quer jogar novamente entre os mesmo jogadores?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - PONTUAÇÃO");
                    System.out.println("3 - MENU");
                    System.out.println("4 - SAIR - 4");
                    Scanner leitura2 = new Scanner(System.in);
                    int opcao = leitura2.nextInt();

                    if(opcao == 1){
                        reset();
                    } if (opcao == 3){
                        menu(cor1,cor2);
                    } if (opcao == 4){
                        break;
                    }
                }
                if(this.jogadas >= 42){
                    break;
                }
                jogador = !jogador;

            }
        }
    }
}
