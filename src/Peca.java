public class Peca {
    private int valor;

    public Peca(int valor){
        this.valor = valor;
    }

    public Peca(){
        this.valor = 0;
    }

    public String toString(){
        return String.valueOf(this.valor);
    }

    public void zerarPeca(){
        this.valor = 0;
    }

    public int getPeca(){
        return this.valor;
    }

    public void setPeca(int valor){
        this.valor = valor;
    }

    //A ideia é o tabuleiro deixar de ser uma matriz int, para ser uma matriz Peça

}
