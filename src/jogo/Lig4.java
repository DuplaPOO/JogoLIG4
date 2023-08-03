package jogo;

import componentes.Jogador;
import componentes.tabuleiro.InterfaceTabuleiro;

import java.util.Random;
import java.util.Scanner;

public abstract class Lig4 {
    protected InterfaceTabuleiro tabuleiro;
    protected Jogador[] jogadores = null;
    protected boolean vezDoJogador;  // true = vez do jogador 1 // false= vez do jogador2
    protected int jogadas;

    Lig4(){
        this.jogadas = 0;
        vezDoJogador = (new Random()).nextBoolean();
    }

    protected abstract void jogarPartida(Jogador jogador1, Jogador jogador2);

    protected abstract void reset();



    protected void menu(){
        int i =0;
        int j = 1;

        while(true){



            limparTela();
            System.out.println("1 - Partida Normal");
            System.out.println("2 - Lig4 turbo");
            System.out.println("3 - Lig4 turbo maluco");
            System.out.println("4 - Ranking");
            System.out.println("5 - Sair") ;

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    perguntarJogadores();
                    Lig4Jogo lig4Normal = new Lig4Jogo();
                    lig4Normal.jogarPartida(jogadores[i],jogadores[j]);
                    break;
                case 2:
                    perguntarJogadores();
                    Lig4Turbo lig4Turbo = new Lig4Turbo();
                    lig4Turbo.jogarPartida(jogadores[i],jogadores[j]);
                    break;
                case 3:
                    perguntarJogadores();
                    Lig4TurboMaluco turboMaluco = new Lig4TurboMaluco();
                    turboMaluco.jogarPartida(jogadores[i], jogadores[j]);
                    break;

                case 4:
                    rankingJogadores();
                    System.out.println("1 - voltar ao menu");
                    opcao = scanner.nextInt();
                    if(opcao == 1 ){
                        menu();
                    } else {
                        menu();
                    }
                case 5:
                    System.out.println("Jogo encerrado");
                    System.exit(0);
                    break;
            }
            i+=2;
            j+=2;

        }
    }

    public void rankingJogadores() {
        int tamanho = jogadores.length;
        if (tamanho > 10){
            tamanho = 10;
        }
        Jogador[] jogadorRank = new Jogador[tamanho];
        for (int i = 0; i < tamanho; i++) {
            jogadorRank[i] = jogadores[i];
        }
        for (int i = 0; i < tamanho - 1; i++) {
            int maior = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (jogadorRank[j].getVitorias() > jogadorRank[maior].getVitorias()) {
                    maior = j;
                }
            }
            Jogador temp = jogadorRank[i];
            jogadorRank[i] = jogadorRank[maior];
            jogadorRank[maior] = temp;
        }

        for (int i = 0; i < tamanho; i++) {
            jogadores[i] =  jogadorRank[i];
            System.out.println(i+1 + "º LUGAR -"+ jogadores[i].getNome() + " PONTUAÇÃO " + jogadores[i].getVitorias());
        }

    }
    private void addJogador(Jogador jogador) {
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

    public void pausarTela() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Pressione Enter para continuar...");
        scanner3.nextLine();
    }

    public void perguntarJogadores(){
        //Futuramente Apresentar os jogadores que já estão resgistrados e perguntar se quer criar algum novo(ou jogar como um existente)
        Scanner scanner2 = new Scanner(System.in);
        limparTela();
        System.out.print("Jogador 1: ");
        String nome1 = scanner2.nextLine();
        addJogador(new Jogador(nome1, "A"));
        System.out.println("");
        System.out.print("Jogador 2: ");
        String nome2 = scanner2.nextLine();
        addJogador(new Jogador(nome2, "V"));
        //Futuramente colocar a exception "O jogador já existe"
    }


}
