package componentes.tabuleiro;

import componentes.Peca;

public class TabuleiroTurbo extends Tabuleiro{
    
    public TabuleiroTurbo(){
        super();
    }

    public void modificarPecasVizinhas(int coluna, String cor){
        int i;
        for (i = 0; i <= 4; i++) {
                    if (tabuleiro[i][coluna] != null) {
                        break;
                    }
                }
        int linha = i;
        if(coluna !=0){
            Peca posicaoEsquerda = tabuleiro[linha][coluna-1];
            if(posicaoEsquerda != null){
                posicaoEsquerda.setCor(cor);
            }
        }

        if(coluna != tabuleiro[0].length-1){
            Peca posicaoDireita = tabuleiro[linha][coluna+1];
            if(posicaoDireita != null){
                posicaoDireita.setCor(cor);
            }
        }
    }

}
