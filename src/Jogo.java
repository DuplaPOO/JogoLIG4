public class Jogo {

    Tabuleiro tabuleiro = new Tabuleiro();


    private int jogadas;
    Jogador jogador1= new Jogador("Lucas",1);
    Jogador jogador2= new Jogador("Arthur",-1);


    public Jogo(){
            this.jogadas=1;
            iniciarPartida();
          // while (jogar()); **************
    }



    public void iniciarPartida(){
        while(jogadas<=42){

            jogador1.registrarPeca(tabuleiro);
            if(ganhou()==1){
                System.out.println("Player 1 venceu");
                break;
            }
            jogador2.registrarPeca(tabuleiro);
            if (ganhou()==-1){
                System.out.println("Player 2 Venceu");
                break;
            }
            jogadas+=2;
            }
        tabuleiro.zerarTabuleiro(jogadas);
    }

        public int ganhou(){
            if(tabuleiro.verificarPontoVertical()==true||tabuleiro.verificarPontoHorizontal() == true || tabuleiro.verificarPontoHorizontal() == true || tabuleiro.verificarDiagonal1() == true || tabuleiro.verificarDiagonal2() == true){
                return 1;
            }
            if(tabuleiro.verificarPontoVertical() == true||tabuleiro.verificarPontoHorizontal() == true || tabuleiro.verificarPontoHorizontal() == true || tabuleiro.verificarDiagonal1() == true || tabuleiro.verificarDiagonal2() == true){
                return -1;
            } else  {
                return 0;
            }
        }



}
