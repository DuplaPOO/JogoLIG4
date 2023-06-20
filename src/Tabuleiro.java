import javax.swing.*;

public class Tabuleiro {

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

    public Tabuleiro(){
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.println("");

        }

    }
}
