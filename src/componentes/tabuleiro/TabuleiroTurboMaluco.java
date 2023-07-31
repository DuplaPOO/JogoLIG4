package componentes.tabuleiro;

import java.util.Random;

public class TabuleiroTurboMaluco extends TabuleiroTurbo implements InterfaceTabuleiro{
    private double maluquice;
    private int incrementoLinha;
    private int incrementoColuna;
    
    public TabuleiroTurboMaluco(){
        super();
        this.incrementoLinha = 0;
        this.incrementoColuna = 0;
        this.maluquice = 0.2;
    }

    public void calcularIncrementos(int linha, int coluna){

        while(true){
            this.incrementoLinha = new Random().nextInt(3) - 1;
            this.incrementoColuna = new Random().nextInt(3) - 1;

            if(linha+incrementoLinha >=0 && linha+incrementoLinha < tabuleiro.length && coluna+incrementoColuna >=0 && coluna+incrementoColuna < tabuleiro[0].length){
                break;
            }
        }
    }

    public void atualizarMaluquice() {
        maluquice += 0.04;

        if (maluquice > 1) {
            maluquice = 1;
        }
    }

    public void modificarPecasVizinhas(int coluna, String cor){
        int i;
        for (i = 0; i <= 4; i++) {
                    if (tabuleiro[i][coluna] != null) {
                        break;
                    }
                }
        int linha = i;
        double numeroAleatorio = new Random().nextDouble() * 100;

        if(numeroAleatorio <= (maluquice * 100)){
            calcularIncrementos(linha, coluna);
            if(tabuleiro[linha+this.incrementoLinha][coluna+this.incrementoColuna] != null){
                tabuleiro[linha+this.incrementoLinha][coluna+this.incrementoColuna].setCor(cor);
            }
        }

    }

    public double getMaluquice(){
        return this.maluquice;
    }

    public int getIncrementoL(){
        return incrementoLinha;
    }

    public int getIncrementoC(){
        return incrementoColuna;
    }
}
