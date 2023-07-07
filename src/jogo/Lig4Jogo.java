package jogo;

import componentes.Jogador;
import componentes.Peca;
import componentes.Tabuleiro;

import java.util.Random;
import java.util.Scanner;

public class Lig4Jogo {
    protected Tabuleiro tabuleiro;
    protected Jogador[] jogadores = null;
    protected boolean jogador;  // true = vez do jogador 1 // false= vez do jogador2
    protected int jogadas;
    private jogo.Lig4Turbo lig4Turbo;

    Lig4Jogo(){
        this.tabuleiro = new Tabuleiro();
        this.jogadas = 0;
        jogador = (new Random()).nextBoolean();
    }


    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        while (true){
            limparTela();
            tabuleiro.imprimirTabuleiro();
            String cor;
            if(jogador){
                cor = jogador1.getCor();
                System.out.println("Vez de " + jogador1.getNome());
            } else {
                cor = jogador2.getCor();
                System.out.println("Vez de " + jogador2.getNome());
            }

            System.out.println("Digite a coluna");
            System.out.println("Escolha entre 1 a 7");
            Scanner leitura = new Scanner(System.in);
            int coluna = leitura.nextInt();
            coluna--;


            boolean pecaAdicionada = tabuleiro.registrarPeca(coluna, cor);
            if(pecaAdicionada){
                jogadas++;
                if(tabuleiro.verificarGanhador()){
                    limparTela();
                    tabuleiro.imprimirTabuleiro();
                    if(jogador){
                        jogador1.aumentarPontuacao();
                        System.out.println("O jogador "+jogador1.getNome() +" venceu");
                    } else {
                        jogador2.aumentarPontuacao();
                        System.out.println("O jogador "+ jogador2.getNome() + " venceu");
                    }

                    System.out.println("Deseja revanche?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NAO");
                    Scanner leitura2 = new Scanner(System.in);
                    int opcao = leitura2.nextInt();

                    if(opcao == 1){
                        reset();
                    } else if (opcao == 2){
                        reset();
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

    protected void menu(){
        while(true){
            limparTela();
            System.out.println("1 - Partida Normal");
            System.out.println("2 - Lig4 turbo");
            System.out.println("3 - Encerrar jogo");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            if(opcao == 1 || opcao == 2){
                Scanner scanner2 = new Scanner(System.in);
                limparTela();
                System.out.print("Jogador 1: ");
                String nome1 = scanner2.nextLine();
                addJogador(new Jogador(nome1, new Peca("A")));
                System.out.println("");

                System.out.print("Jogador 2: ");
                String nome2 = scanner2.nextLine();
                addJogador(new Jogador(nome2, new Peca("V")));
                Lig4Jogo jogo = new Lig4Jogo();
            }
            switch(opcao){
                case 1:
                    jogarPartida(jogadores[0],jogadores[1]);
                    break;
                case 2:
                    Lig4Turbo lig4Turbo = new Lig4Turbo();
                    lig4Turbo.jogarPartida(jogadores[0],jogadores[1]);
                    break;
                case 3:
                    System.out.println("Jogo encerrado");
                    System.exit(0);
                    break;
            }
        }
    }

    private void reset(){
        this.tabuleiro= new Tabuleiro();
        jogador= (new Random()).nextBoolean();
    }

    protected void addJogador(Jogador jogador) {
        if(jogadores == null){
            jogadores = new Jogador[1];
            jogadores[0] = jogador;
        } else {
            Jogador[] novoArray = new Jogador[jogadores.length + 1];
            for (int i = 0; i < jogadores.length; i++) {
                novoArray[i] = jogadores[i];
            }
            novoArray[jogadores.length] = jogador;
            jogadores = novoArray;
        }
    }

    protected void limparTela(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }


}
