import java.util.Random;
import java.util.Scanner;

public class Lig4Jogo {
    protected Tabuleiro tabuleiro;
    protected final String cor1;
    protected final String cor2;
    protected Jogador[] jogadores = null;
    protected boolean jogador;  // true = vez do jogador 1 // false= vez do jogador2
    protected int jogadas;
    //private Lig4Turbo lig4Turbo;

    public Lig4Jogo(String cor1, String cor2){
        this.tabuleiro = new Tabuleiro();
        this.cor1 = cor1;
        this.cor2 = cor2;
        this.jogadas = 0;
        jogador = (new Random()).nextBoolean();
        jogarPartida();
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
            limparTela();
            tabuleiro.imprimirTabuleiro();

            if(pecaAdicionada){
                jogadas++;
                
                if(checarVencedor()){
                    if(jogador){
                        System.out.println("Jogador da cor 1 venceu");
                        break;
                    } else {
                        System.out.println("Jogador da cor 2 venceu");
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
        System.out.print("Jogador 1: ");
        String nome1 = scanner.nextLine();
        addJogador(new Jogador(nome1));
        System.out.println("");
        System.out.print("Jogador 2: ");
        String nome2 = scanner.nextLine();
        addJogador(new Jogador(nome2));
        



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
/*
    public void jogarLig4Turbo(){
        while(jogadas<=42){
            jogadores[0].registrarPeca(tabuleiro);
            jogadores[0].modificarPecasVizinhas(tabuleiro);
            if(ganhou()==true){
                System.out.println("Player 1 venceu");
                break;
            }
            jogadores[1].registrarPeca(tabuleiro);
            jogadores[1].modificarPecasVizinhas(tabuleiro);
            if (ganhou()==true){
                System.out.println("Player 2 Venceu");
                break;
            }
            jogadas+=2;
            }
        jogadas = 1;
        tabuleiro.zerarTabuleiro();
    }

*/

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
