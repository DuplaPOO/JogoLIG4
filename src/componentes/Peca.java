package componentes;

public class Peca {
    private String cor;
    

    Peca(){
        this.cor = null;
    }

    
    public Peca(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

    void setCor(String cor){
        this.cor = cor;
    }


}
