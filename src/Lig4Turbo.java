import java.util.Scanner;

public class Lig4Turbo extends Lig4Jogo {
    


    public Lig4Turbo(String cor1, String cor2){
        super(cor1, cor2);
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
            tabuleiro.modificarPecasVizinhas(cor, coluna);
            limparTela();
            tabuleiro.imprimirTabuleiro();

            if(pecaAdicionada){
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
                jogador =! jogador;
            }
        }
    }
}
