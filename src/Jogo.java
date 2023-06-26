public class Jogo {

    Tabuleiro tabuleiro = new Tabuleiro();


    private int jogadas;
    Jogador jogador1= new Jogador("Lucas",new Peca(1));
    Jogador jogador2= new Jogador("Arthur",new Peca(-1));


    public Jogo(){
            this.jogadas=1;
            JogarPartida();
          // while (jogar()); **************
    }

    public static void main(String[] args) {
        new Jogo();
    }



    public void JogarPartida(){
        while(jogadas<=42){

            jogador1.registrarPeca(tabuleiro);
            if(Ganhou()==1){
                System.out.println("Player 1 venceu");
                break;
            }
            jogador2.registrarPeca(tabuleiro);
            if (Ganhou()==-1){
                System.out.println("Player 2 Venceu");
                break;
            }
            jogadas+=2;
            }
            jogadas = 1;
        tabuleiro.zerarTabuleiro();
    }

        public int Ganhou(){
            if(tabuleiro.VerificarVertical()==true||tabuleiro.VerificarHorizontal() == true || tabuleiro.VerificarHorizontal() == true || tabuleiro.VerificarDiagonal1() == true || tabuleiro.VerificarDiagonal2() == true){
                return 1;
            }
            if(tabuleiro.VerificarVertical() == true||tabuleiro.VerificarHorizontal() == true || tabuleiro.VerificarHorizontal() == true || tabuleiro.VerificarDiagonal1() == true || tabuleiro.VerificarDiagonal2() == true){
                return -1;
            } else  {
                return 0;
            }
        }



}
