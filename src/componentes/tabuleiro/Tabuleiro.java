package componentes.tabuleiro;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import componentes.Peca;
import exceptions.ColunaCheiaException;
import exceptions.ColunaInvalidaException;

public class Tabuleiro implements InterfaceTabuleiro{

    public static final int linhas = 6;
    public static final int colunas = 7;
    protected Peca[][] tabuleiro = new Peca[linhas][colunas];
    private Image imgCirculoBranco;
    private Image imgCirculoAzul;
    private Image imgCirculoAmarelo;
    
    public Tabuleiro(){
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                tabuleiro[i][j] = null;
            }
        }
        carregarImagens();
    }

    private void carregarImagens() {
    try {
        imgCirculoBranco = ImageIO.read(getClass().getResource("/images/Circulo_branco.png"));
        imgCirculoAzul = ImageIO.read(getClass().getResource("/images/Circulo_azul.png"));
        imgCirculoAmarelo = ImageIO.read(getClass().getResource("/images/Circulo_amarelo.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public Image getCirculoAzul(){
        return imgCirculoAzul;
    }

    public Image getCirculoAmarelo(){
        return imgCirculoAmarelo;
    }


    public void imprimirTabuleiroConsole(){
        for (int i = 0; i < linhas ; i++) {
            System.out.print("|");
            for (int j = 0; j < colunas; j++) {
                if(tabuleiro[i][j] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(tabuleiro[i][j].getCor());
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void imprimirPecasTabuleiro(Graphics g){

        for(int lin = 0; lin < 6; lin++) {
            for(int col = 0; col < 7; col++){
                int x = 127 + col * 100;
                int y = 125 + lin * 100;
                if(tabuleiro[lin][col] != null){
                    if(tabuleiro[lin][col].getCor().equals("Azul")){
                        g.drawImage(imgCirculoAzul, x, y, 50, 50, null);
                    } else if(tabuleiro[lin][col].getCor().equals("Amarelo")){
                        g.drawImage(imgCirculoAmarelo, x, y, 50, 50, null);
                    }
                    
                } else{
                    //espaço vazio
                    g.drawImage(imgCirculoBranco, x, y, 50, 50, null);
                }
                
            }
        }

    }

    public int pegarLinha(int colunaAdicionar){
        int linha=-1;
        for (int i = linhas - 1; i >= 0; i--) {
            if (tabuleiro[i][colunaAdicionar] == null) {
                linha = i;
                break;
            }
        }
        return linha;
    }
    //TROUXE O REGISTRAR PEÇA DO JOGADOR PARA O TABULEIRO, O JOGADOR APENAS REALIZA A JOGADA, MAS O TABULEIRO QUE REGISTRA
    public boolean registrarPeca(int colunaAdicionar, String cor) throws ColunaCheiaException{

        if (colunaAdicionar >= 0 && colunaAdicionar < colunas) {
            if (tabuleiro[0][colunaAdicionar] == null) {
                boolean pecaAdicionar = false;
                for (int i = linhas - 1; i >= 0; i--) {
                    if (tabuleiro[i][colunaAdicionar] == null) {
                        tabuleiro[i][colunaAdicionar] = new Peca(cor);
                        pecaAdicionar = true;
                        break;
                    }
                }
                return pecaAdicionar;
            } else {
                    ColunaCheiaException err = new ColunaCheiaException(colunaAdicionar+1);
                    throw err;
            }
        } else {
            return false;
        }
    }

    public boolean registrarPecaConsole(int colunaAdicionar, String cor) throws ColunaCheiaException, ColunaInvalidaException{

        if (colunaAdicionar >= 0 && colunaAdicionar < colunas) {
            if (tabuleiro[0][colunaAdicionar] == null) {
                boolean pecaAdicionar = false;
                for (int i = linhas - 1; i >= 0; i--) {
                    if (tabuleiro[i][colunaAdicionar] == null) {
                        tabuleiro[i][colunaAdicionar] = new Peca(cor);
                        pecaAdicionar = true;
                        break;
                    }
                }
                return pecaAdicionar;
            } else {
                ColunaCheiaException e = new ColunaCheiaException(colunaAdicionar+1);
                throw e;
            }
        } else {
            ColunaInvalidaException e = new ColunaInvalidaException(colunaAdicionar+1);
            throw e;
        }
    }
    private boolean verificarHorizontal() {
        Peca[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha][coluna + 1];
                Peca peca3 = A[linha][coluna + 2];
                Peca peca4 = A[linha][coluna + 3];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null && peca1.getCor().equals(peca2.getCor()) && peca2.getCor().equals(peca3.getCor()) && peca3.getCor().equals(peca4.getCor())) {
                    return true;

                }

            }
        }
        return false;
    }
    private boolean verificarVertical() {
        Peca[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha + 1][coluna];
                Peca peca3 = A[linha + 2][coluna];
                Peca peca4 = A[linha + 3][coluna];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null && peca1.getCor().equals(peca2.getCor()) && peca2.getCor().equals(peca3.getCor()) && peca3.getCor().equals(peca4.getCor())) {
                    return true;
                }

            }
        }
        return false;
    }
    private boolean verificarDiagonalD(){
        Peca[][] A = this.tabuleiro;

        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha + 1][coluna + 1];
                Peca peca3 = A[linha + 2][coluna + 2];
                Peca peca4 = A[linha + 3][coluna + 3];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null && peca1.getCor().equals(peca2.getCor()) && peca2.getCor().equals(peca3.getCor()) && peca3.getCor().equals(peca4.getCor())) {
                    return true;
                }

            }
        }
        return false;
    }
    private boolean verificarDiagonalA(){
        Peca[][] A = this.tabuleiro;

        for (int linha = A.length - 1; linha >= 3; linha--) {
            for (int coluna = 0; coluna < A[linha].length - 3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha - 1][coluna + 1];
                Peca peca3 = A[linha - 2][coluna + 2];
                Peca peca4 = A[linha - 3][coluna + 3];
                if (peca1 != null && peca2 != null && peca3 != null && peca4 != null && peca1.getCor().equals(peca2.getCor()) && peca2.getCor().equals(peca3.getCor()) && peca3.getCor().equals(peca4.getCor())) {
                    return true;
                }

            }
        }
        return false;
    }
    
    public boolean verificarGanhador(){
        if(verificarVertical()==true|| verificarHorizontal() == true || verificarDiagonalD() == true || verificarDiagonalA() == true){
            return true;
        } else {
            return false;
        }
    }
    public void zerarTabuleiro(){
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Peca();
            }
        }

    }



}
