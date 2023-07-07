package jogo;

import componentes.Jogador;
import componentes.Tabuleiro;

import java.util.Random;
import java.util.Scanner;

public class Lig4Jogo {
    protected Tabuleiro tabuleiro;
    protected final String cor1;
    protected final String cor2;
    protected Jogador[] jogadores = null;
    protected boolean jogador;  // true = vez do jogador 1 // false= vez do jogador2
    protected int jogadas;
    //private jogo.Lig4Turbo lig4Turbo;

    public Lig4Jogo(String cor1, String cor2){
        this.tabuleiro = new Tabuleiro();
        this.cor1 = cor1;
        this.cor2 = cor2;
        this.jogadas = 0;
        jogador = (new Random()).nextBoolean();
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
            if(pecaAdicionada){
                jogadas++;
                if(checarVencedor()){
                    tabuleiro.imprimirTabuleiro();
                    if(jogador){
                        System.out.println("componentes.Jogador " +cor1 +" venceu");
                    } else {
                        System.out.println("componentes.Jogador " +cor2 + " venceu");
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

    public void menu(String cor1, String cor2){
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1 - Partida Normal");
            System.out.println("2 - Lig4 turbo");
            System.out.println("3 - Encerrar jogo");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    Lig4Jogo jogo = new Lig4Jogo(cor1, cor2);
                    jogo.jogarPartida();
                    jogo.pausarTela(2);
                    break;
                case 2:
                    Lig4Turbo lig4Turbo = new Lig4Turbo(cor1, cor2);
                    lig4Turbo.jogarPartida();
                    lig4Turbo.pausarTela(2);
                    break;
                case 3:
                    System.out.println("Jogo encerrado");
                    System.exit(0);
                    break;
            }
        }
    }
    public void reset(){
        this.tabuleiro= new Tabuleiro();
        jogador= (new Random()).nextBoolean();
    }

    public boolean checarVencedor(){
        String corVencedora;
        if(jogador){
            corVencedora = cor1;
        } else {
            corVencedora = cor2;
        }
        return tabuleiro.verificarGanhandor(corVencedora);

    }


/* 
    public int menu(){
        tabuleiro.limparTela();
        System.out.println("1 - Partida Normal");
        System.out.println("2 - Lig4 turbo");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine();

        tabuleiro.limparTela();
        System.out.print("componentes.Jogador 1: ");
        String nome1 = scanner.nextLine();
        addJogador(new componentes.Jogador(nome1));
        System.out.println("");
        System.out.print("componentes.Jogador 2: ");
        String nome2 = scanner.nextLine();
        addJogador(new componentes.Jogador(nome2));
        return opcao;
    }

*/



    public void addJogador(Jogador jogador) {
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
    public void limparTela(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    public void pausarTela(int segundos) {
            try {
                Thread.sleep(segundos * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
