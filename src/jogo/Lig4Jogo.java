package jogo;

import java.util.*;

import componentes.Jogador;
import componentes.tabuleiro.Tabuleiro;
import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public class Lig4Jogo extends Lig4 {
    private static final String JSON_FILE_PATH = "dados.json";
    public Lig4Jogo(){
        super();
        this.tabuleiro = new Tabuleiro();
    }
    protected void jogarPartida(Jogador jogador1, Jogador jogador2){
        jogadorList = new ArrayList<Jogador>();
        jogadorList = carregarJogadoresDoJSON();

        for (Jogador jogadorData : jogadorList) {
            if (jogadorData.getNome().equals(jogador1.getNome())) {
                jogadorData1 = jogadorData;
                break;
            }
        }
        for (Jogador jogadorData : jogadorList) {
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
                coluna--;

                boolean pecaAdicionada = tabuleiro.registrarPecaConsole(coluna, cor);
                
                if(pecaAdicionada){
                    jogadas++;
                    if(tabuleiro.verificarGanhador()){
                        limparTela();
                        tabuleiro.imprimirTabuleiroConsole();
                        if(vezDoJogador){
                            jogador1.addVitoria();
                            if (jogadorData1 != null) {
                                jogadorData1.addVitoria();
                            } else {
                                jogadorData1= new Jogador(jogador1.getNome(), jogador1.getVitorias());
                                jogadorList.add(jogadorData1);
                            }
                            System.out.println("O jogador "+jogador1.getNome() +" venceu");
                        } else {
                            jogador2.addVitoria();
                            if (jogadorData2 != null) {
                                jogadorData2.addVitoria();
                            } else {
                                jogadorData2= new Jogador(jogador2.getNome(), jogador2.getVitorias());
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
            } catch (InputMismatchException e){
                System.err.println("Você não digitou um número :( ");
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
