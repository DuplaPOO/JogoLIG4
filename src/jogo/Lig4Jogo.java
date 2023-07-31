package jogo;

import java.util.Random;
import java.util.Scanner;

import componentes.Jogador;
import componentes.tabuleiro.Tabuleiro;
import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public class Lig4Jogo extends Lig4 {

    private String cor1;////
    private String cor2;///////

    public Lig4Jogo(){
        super();
        this.tabuleiro = new Tabuleiro();
        this.cor1 = cor1;
        this.cor2 = cor2;
    }

    public boolean vezDoJogador(){
        return vezDoJogador;
    }

    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        while(true){
            try{
                limparTela();
                tabuleiro.imprimirTabuleiroConsole();
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
                //A intenção era lançar o exception numero inteiro aqui, mas o scanner já tem um erro próprio para isso
                coluna--;

                boolean pecaAdicionada = tabuleiro.registrarPecaConsole(coluna, cor);
                
                if(pecaAdicionada){
                    jogadas++;
                    if(tabuleiro.verificarGanhadorConsole()){
                        limparTela();
                        tabuleiro.imprimirTabuleiroConsole();
                        if(vezDoJogador){
                            jogador1.addVitoria();
                            System.out.println("O jogador "+jogador1.getNome() +" venceu");
                        } else {
                            jogador2.addVitoria();
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
                    vezDoJogador = !vezDoJogador;
                }
            } catch(ColunaCheiaException e){
                System.err.println(e.getMessage());
                pausarTela();
                continue;
            } catch(ColunaInvalidaException e){
                System.err.println(e.getMessage());
                pausarTela();
                continue;
            }
        }
    }



    protected void reset(){
        this.tabuleiro= new Tabuleiro();
        vezDoJogador= (new Random()).nextBoolean();
    }
}
