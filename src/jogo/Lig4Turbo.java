package jogo;

import java.util.Random;
import java.util.Scanner;

import componentes.Jogador;
import componentes.Tabuleiro;
import componentes.TabuleiroTurbo;

public class Lig4Turbo extends Lig4Jogo {

    private TabuleiroTurbo tabuleiroTurbo;


    Lig4Turbo(){
        super();
        this.tabuleiroTurbo = new TabuleiroTurbo();
    }

    
    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        while (true){
            limparTela();
            tabuleiroTurbo.imprimirTabuleiro();
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


            boolean pecaAdicionada = tabuleiroTurbo.registrarPeca(coluna, cor);
            tabuleiroTurbo.modificarPecasVizinhas(cor, coluna);

            if(pecaAdicionada){
                jogadas++;
                if(tabuleiroTurbo.verificarGanhador()){
                    limparTela();
                    tabuleiroTurbo.imprimirTabuleiro();
                    if(jogador){
                        jogador1.aumentarPontuacao();
                        System.out.println(jogador1.getNome() +" venceu");
                    } else {
                        jogador2.aumentarPontuacao();
                        System.out.println(jogador1.getNome() + " venceu");
                    }

                    System.out.println("Deseja revanche?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NAO");
                    Scanner leitura2 = new Scanner(System.in);
                    int opcao = leitura2.nextInt();

                    if(opcao == 1){
                        resetTurbo();
                    } else if (opcao == 2){
                        resetTurbo();
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

    private void resetTurbo(){
        this.tabuleiroTurbo= new TabuleiroTurbo();
        jogador= (new Random()).nextBoolean();
    }






}
