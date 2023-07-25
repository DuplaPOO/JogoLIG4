package componentes;

public class Peca {
    private String cor;
    
//Tudo public para os arquivos do subpacote tabuleiro conseguirem acessar os métodos

    public Peca(){
        this.cor = null;
    }

    public Peca(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }


}
