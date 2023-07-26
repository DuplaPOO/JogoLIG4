package componentes.tabuleiro;

import java.util.Random;

public class TabuleiroTurboMaluco extends TabuleiroTurbo{
    private double maluquice;
    private int incrementoLinha;
    private int incrementoColuna;
    
    public TabuleiroTurboMaluco(){
        super();
        this.incrementoLinha = 0;
        this.incrementoColuna = 0;
        this.maluquice = 0.1;
    }

    public void calcularIncrementos(int linha, int coluna){

        while(true){
            this.incrementoLinha = new Random().nextInt(3) - 1;
            this.incrementoColuna = new Random().nextInt(3) - 1;

            if(linha+incrementoLinha >=0 && linha+incrementoLinha < tabuleiro.length && coluna+incrementoColuna >=0 && coluna+incrementoColuna < tabuleiro[linha].length){
                break;
            }
        }
    }

    public void atualizarMaluquice() {
        maluquice += 0.02;

        if (maluquice > 1) {
            maluquice = 1;
        }
    }

    public void modificarPecasVizinhas(String cor, int coluna){
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
            if(tabuleiro[linha+incrementoColuna][coluna+incrementoColuna] != null){
                tabuleiro[linha+incrementoColuna][coluna+incrementoColuna].setCor(cor);
            }
        }

    }

    public double getMaluquice(){
        return this.maluquice;
    }
}
