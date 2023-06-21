public class Tabuleiro {

    int[][] tabuleiro = {{0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
    };
    private int[] colunas;
    private int[] fileiras;
    private int zerar;


    public Tabuleiro(){
        criarTabuleiro();
    }

    public void zerarTabuleiro(int zerar){
        if (zerar == 1){
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j <tabuleiro[i].length ; j++) {
                    tabuleiro[i][j] = 0;
                }
            }
        } else {
            System.out.println("Obrigado por jogar");
        }
        
    }

    public void criarTabuleiro(){
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public boolean tabuleiroCompleto(){
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j <tabuleiro[i].length ; j++) {
                if(tabuleiro[i][j] == 0){
                    return false;
                } else {

                }
            }
        }
        return true;
    }


    //AQUI SÃO OS METODOS PARA CHECAR AS SEQUENCIAS *****

    /*public int checaLinhas(){

    }
    public int checaColunas(){

    }

    public int checaDiagonias(){

    }
*/
    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int fileira, int coluna, int valor){
        tabuleiro[fileira][coluna] = valor;
    }

    public int getZerar() {
        return zerar;
    }
    public void setZerar(int zerar) {
        this.zerar = zerar;
    }

}
