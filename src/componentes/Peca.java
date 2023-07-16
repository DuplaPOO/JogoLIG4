package componentes;

public class Peca {
    private String cor;
    

    Peca(){
        this.cor = null;
    }

    Peca(String cor){
        this.cor = cor;
    }

    String getCor(){
        return this.cor;
    }

    void setCor(String cor){
        this.cor = cor;
    }


}
