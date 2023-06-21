public class Jogo {
    Tabuleiro tabuleiro = new Tabuleiro();
    private int jogadas;
    Jogador jogador1= new Jogador("Lucas",1);
    Jogador jogador2= new Jogador("Arthur",-1);


    public Jogo(){
            this.jogadas=1;
            IniciarPartida();

          // while (jogar()); **************
    }


    public void IniciarPartida(){
        while(jogadas<=42){
            jogador1.registrarPeca(tabuleiro);
            if(jogador1.VerificarPontoHorizontal(tabuleiro) == true || jogador1.VerificarPontoHorizontal(tabuleiro) == true || jogador1.VerificarDiagonal1(tabuleiro) == true || jogador1.VerificarDiagonal2(tabuleiro) == true){
                System.out.println("Player 1 venceu");
                break;
            }
            jogador2.registrarPeca(tabuleiro);
            if(jogador2.VerificarPontoHorizontal(tabuleiro) == true || jogador2.VerificarPontoHorizontal(tabuleiro) == true || jogador2.VerificarDiagonal1(tabuleiro) == true || jogador2.VerificarDiagonal2(tabuleiro) == true){
                System.out.println("Player 2 venceu");
                break;
            }
            jogadas+=2;
            }
        tabuleiro.zerarTabuleiro(jogadas);
    }


    /* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        public boolean jogar(){
            if(ganhou()==0 ) {
                if(vez ==1 ){
                    jogador1.registrarPeca(tabuleiro);
                } else{
                    jogador2.registrarPeca(tabuleiro);
                }

                if(tabuleiro.tabuleiroCompleto()){
                    System.out.println("Tabuleiro completo");
                    return false;
                }
                vez++;
                return true;

            } else {
                if(ganhou() == 1 ){
                    System.out.println("Player 1 ganhou");
                } else {
                    System.out.println("Player 2 ganhou");
                }
            }


        }

     -----------------------------------------------------------------------------------------------*/

        /*    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        public int ganhou(){
            if(tabuleiro.checaLinhas() == 1){
                return 1;
            }
            if(tabuleiro.checaColunas() == 1){
                return 1;
            }
            if(tabuleiro.checaDiagonias()==1){
                return 1;
            }
            if(tabuleiro.checaLinhas() == -1){
                return -1;
            }
            if(tabuleiro.checaColunas() == -1){
                return -1;
            }
            if(tabuleiro.checaDiagonias()== -1){
                return -1;
            } else  {
                return 0;
            }
        }
--------------------------------------------------------------------------------------------*/


}
