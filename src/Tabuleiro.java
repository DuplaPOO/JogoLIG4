import javax.swing.*;

public class TABULEIRO {

    int[][] tabuleiro = {{0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    private int[] colunas;
    private int[] fileiras;

    public TABULEIRO(){
        ImprimirTabuleiro();
    }

    public void ImprimirTabuleiro(){
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.println("");

        }
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int fileira, int coluna, int valor){
        tabuleiro[fileira][coluna] = valor;
    }
}
