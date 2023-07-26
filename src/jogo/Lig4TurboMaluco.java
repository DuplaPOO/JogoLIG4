package jogo;


import java.util.Random;
import java.util.Scanner;

import componentes.Jogador;
import componentes.TabuleiroTurboMaluco;
import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public class Lig4TurboMaluco extends Lig4{

    private TabuleiroTurboMaluco tabuleiroTurboMaluco;

    Lig4TurboMaluco(){
        super();
        this.tabuleiroTurboMaluco = new TabuleiroTurboMaluco();
    }

    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        try{
            while (true){
                limparTela();
                tabuleiroTurboMaluco.imprimirTabuleiro();
                String cor;
                if(vezDoJogador){
                    cor = jogador1.getCor();
                    System.out.println("Vez de " + jogador1.getNome() + "\t\tMaluquice: " + String.format("%.1f", tabuleiroTurboMaluco.getMaluquice()*100) + "%");
                } else {
                    cor = jogador2.getCor();
                    System.out.println("Vez de " + jogador2.getNome() + "\t\tMaluquice: " + String.format("%.1f", tabuleiroTurboMaluco.getMaluquice()*100) + "%");
                }

                System.out.println("Digite a coluna");
                System.out.println("Escolha entre 1 a 7");
                Scanner leitura = new Scanner(System.in);
                int coluna = leitura.nextInt();
                coluna--;


                boolean pecaAdicionada = tabuleiroTurboMaluco.registrarPeca(coluna, cor);
                tabuleiroTurboMaluco.modificarPecasVizinhas(cor, coluna);
                tabuleiroTurboMaluco.atualizarMaluquice();

                if(pecaAdicionada){
                    jogadas++;
                    if(tabuleiroTurboMaluco.verificarGanhador()){
                        limparTela();
                        tabuleiroTurboMaluco.imprimirTabuleiro();
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
        } catch(ColunaCheiaException e){
            System.out.println(e.getMessage());
        } catch(ColunaInvalidaException e){
            System.out.println(e.getMessage());
        }
    }

    protected void reset(){
        this.tabuleiroTurboMaluco = new TabuleiroTurboMaluco();
        vezDoJogador= (new Random()).nextBoolean();
    }
    
}
