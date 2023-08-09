package jogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import componentes.Jogador;
import componentes.JogadorData;
import componentes.tabuleiro.TabuleiroTurbo;
import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public class Lig4Turbo extends Lig4 {


    Lig4Turbo(){
        super();
        this.tabuleiro = new TabuleiroTurbo();
    }

    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        jogadorList = new ArrayList<JogadorData>();
        jogadorList = carregarJogadoresDoJSON();

        for (JogadorData jogadorData : jogadorList) {
            if (jogadorData.getNome().equals(jogador1.getNome())) {
                jogadorData1 = jogadorData;
                break;
            }
        }
        for (JogadorData jogadorData : jogadorList) {
            if (jogadorData.getNome().equals(jogador2.getNome())) {
                jogadorData2 = jogadorData;
                break;
            }
        }

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
                tabuleiro.modificarPecasVizinhas(coluna, cor);
                
                if(pecaAdicionada){
                    jogadas++;
                    if(tabuleiro.verificarGanhador()){
                        limparTela();
                        tabuleiro.imprimirTabuleiroConsole();
                        if(vezDoJogador){
                            jogador1.addVitoria();
                            if (jogadorData1 != null) {
                                jogadorData1.incrementVitorias();
                            } else {
                                jogadorData1= new JogadorData(jogador1.getNome(), jogador1.getVitorias());
                                jogadorList.add(jogadorData1);
                            }
                            System.out.println("O jogador "+jogador1.getNome() +" venceu");
                        } else {
                            jogador2.addVitoria();
                            if (jogadorData2 != null) {
                                jogadorData2.incrementVitorias();
                            } else {
                                jogadorData2= new JogadorData(jogador2.getNome(), jogador2.getVitorias());
                                jogadorList.add(jogadorData2);
                            }
                            System.out.println("O jogador "+ jogador2.getNome() + " venceu");
                        }

                        salvarJogadoresNoJSON(jogadorList);



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
        this.tabuleiro= new TabuleiroTurbo();
        vezDoJogador= (new Random()).nextBoolean();
    }






}
