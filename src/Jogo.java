public class Jogo {
        Tabuleiro tabuleiro = new Tabuleiro();
        private int vez = 1;
        Jogador jogador1= new Jogador("Player 1");
        Jogador jogador2= new Jogador("Player 2");


        public Jogo(){
            jogador1.registrarPeca(tabuleiro);

          // while (jogar()); **************
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
