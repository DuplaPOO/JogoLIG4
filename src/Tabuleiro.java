public class Tabuleiro {

    private Peca[][] tabuleiro = new Peca[6][7];

    public Tabuleiro(){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Peca();
            }
        }
        imprimirTabuleiro();
    }
    


    public void zerarTabuleiro(){
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j].zerarPeca();
            }
        }
        
    }
    public void imprimirTabuleiro(){
        limparTela();
        for (int i = 0; i < tabuleiro.length ; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    /*
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
    } */



    //VER SE JÁ TEM UMA PEÇA NA POSIÇÃO(PEÇA EM CIMA DE PEÇA)
    public int colisaoDePecas(int coluna) {
        Peca[][] A = this.tabuleiro;
        int linha;
        for (linha = 0; linha < 6; linha++) {
            Peca i1 = A[linha][coluna];
            if (i1.getPeca() == 1 || i1.getPeca() == -1) {
                break;
            }
            if(A[0][coluna].getPeca() == 1 || A[0][coluna].getPeca() == -1 ){
                System.out.println("coluna cheia, digite outra coluna");
                return 0;
            }
        }
        return --linha;
    }

    public boolean verificarHorizontal() {
        Peca[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha][coluna + 1];
                Peca peca3 = A[linha][coluna + 2];
                Peca peca4 = A[linha][coluna + 3];
                if(peca1.getPeca() != 0 && peca1.getPeca() == peca2.getPeca() && peca2.getPeca() == peca3.getPeca() && peca3.getPeca() == peca4.getPeca()){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean verificarVertical() {
        Peca[][] A = this.tabuleiro;
        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha + 1][coluna];
                Peca peca3 = A[linha + 2][coluna];
                Peca peca4 = A[linha + 3][coluna];
                if(peca1.getPeca() != 0 && peca1.getPeca() == peca2.getPeca() && peca2.getPeca() == peca3.getPeca() && peca3.getPeca() == peca4.getPeca()){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean verificarDiagonal1(){
        Peca[][] A = this.tabuleiro;

        for (int linha = 0; linha < A.length - 3; linha++) {
            for (int coluna = 0; coluna < A[linha].length-3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha + 1][coluna + 1];
                Peca peca3 = A[linha + 2][coluna + 2];
                Peca peca4 = A[linha + 3][coluna + 3];
                if(peca1.getPeca() != 0 && peca1.getPeca() == peca2.getPeca() && peca2.getPeca() == peca3.getPeca() && peca3.getPeca() == peca4.getPeca()){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean verificarDiagonal2(){
        Peca[][] A = this.tabuleiro;

        for (int linha = A.length - 1; linha >= 3; linha--) {
            for (int coluna = 0; coluna < A[linha].length - 3; coluna++) {
                Peca peca1 = A[linha][coluna];
                Peca peca2 = A[linha - 1][coluna + 1];
                Peca peca3 = A[linha - 2][coluna + 2];
                Peca peca4 = A[linha - 3][coluna + 3];
                if(peca1.getPeca() != 0 && peca1.getPeca() == peca2.getPeca() && peca2.getPeca() == peca3.getPeca() && peca3.getPeca() == peca4.getPeca()){
                    return true;
                }
            }
        }
        return false;
    }

    public Peca[][] getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(int fileira, int coluna, Peca valor){
            tabuleiro[fileira][coluna]=valor;
    }

    public void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    

}
