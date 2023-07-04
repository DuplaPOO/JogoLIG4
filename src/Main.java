import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //limpar tela
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1 - Partida Normal");
            System.out.println("2 - Lig4 turbo");
            System.out.println("3 - Encerrar jogo");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    Lig4Jogo jogo = new Lig4Jogo("V", "A");
                    jogo.pausarTela(2);
                    break;
                case 2:
                    Lig4Turbo lig4Turbo = new Lig4Turbo("V", "A");
                    lig4Turbo.pausarTela(2);
                    break;
                case 3:
                    System.out.println("Jogo encerrado");
                    System.exit(0);
                    break;
            }

        }
        
    }

}

/*NO MEU VER:
    -CRIAR UM METODO PARA PERGUNTAR SE QUER JOGAR NOVAMENTE, "REVANCHE SLA"
    -
    -CRIAR UM METODO QUE VÁ SOMANDO AS QUANTIDADES DE PARTIDAS, E NELE UM ARRAY COM 2 LUGARES, E VAI ADICIONANDO 1 PARA CADA VITORIA, FICARIA O RANKING

     */