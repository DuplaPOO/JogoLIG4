import java.util.Scanner;

public class Jogo {

    protected Tabuleiro tabuleiro;
    protected int jogadas;
    protected Jogador[] jogadores;
    private Lig4Turbo lig4Turbo;
    


    public Jogo(){
        tabuleiro = new Tabuleiro();
        this.jogadas=1;
        menu();
    }

    public static void main(String[] args) {
        new Jogo();
    }



    public void menu(){
        tabuleiro.limparTela();
        System.out.println("1 - Partida Normal");
        System.out.println("2 - Lig4 turbo");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine();

        tabuleiro.limparTela();
        System.out.print("Jogador 1: ");
        String nome1 = scanner.nextLine();
        addJogador(new Jogador(nome1, new Peca(1)));
        System.out.println("");
        System.out.print("Jogador 2: ");
        String nome2 = scanner.nextLine();
        addJogador(new Jogador(nome2, new Peca(-1)));

        switch(opcao){
            case 1:
                jogarPartida();
                break;
            case 2 :
                jogarLig4Turbo();
                break;
        }
        scanner.close();
    }



    public void jogarPartida(){
        while(jogadas<=42){
            jogadores[0].registrarPeca(tabuleiro);
            if(ganhou()==true){
                System.out.println("Player 1 venceu");
                break;
            }
            jogadores[1].registrarPeca(tabuleiro);
            if (ganhou()==true){
                System.out.println("Player 2 Venceu");
                break;
            }
            jogadas+=2;
            }
        jogadas = 1;
        tabuleiro.zerarTabuleiro();
    }

    public boolean ganhou(){
        if(tabuleiro.verificarVertical()==true||tabuleiro.verificarHorizontal() == true || tabuleiro.verificarHorizontal() == true || tabuleiro.verificarDiagonal1() == true || tabuleiro.verificarDiagonal2() == true){
            return true;
        }
         else  {
            return false;
        }
    }

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



}
