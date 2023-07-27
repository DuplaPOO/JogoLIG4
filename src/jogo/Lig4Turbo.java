package jogo;

import java.util.Random;
import java.util.Scanner;

import componentes.Jogador;
import componentes.tabuleiro.TabuleiroTurbo;
import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public class Lig4Turbo extends Lig4 {

    private TabuleiroTurbo tabuleiroTurbo;


    Lig4Turbo(){
        super();
        this.tabuleiroTurbo = new TabuleiroTurbo();
    }

    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        while(true){
            
                limparTela();
                tabuleiroTurbo.imprimirTabuleiro();
                String cor;
                if(vezDoJogador){
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
                        if(vezDoJogador){
                            jogador1.addVitoria();
                            System.out.println(jogador1.getNome() +" venceu");
                        } else {
                            jogador2.addVitoria();
                            System.out.println(jogador1.getNome() + " venceu");
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
                    vezDoJogador = !vezDoJogador;
                    
                }
            
            
        }
    }

    protected void reset(){
        this.tabuleiroTurbo= new TabuleiroTurbo();
        vezDoJogador= (new Random()).nextBoolean();
    }






}
