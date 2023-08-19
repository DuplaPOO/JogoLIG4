package jogo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import componentes.Jogador;
import componentes.JogadorData;
import componentes.tabuleiro.InterfaceTabuleiro;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public abstract class Lig4 {
    protected InterfaceTabuleiro tabuleiro;
    protected Jogador[] jogadores = null;
    protected boolean vezDoJogador;  // true = vez do jogador 1 // false= vez do jogador2
    protected int jogadas;
    protected  List<JogadorData> jogadorList;
    protected JogadorData jogadorData1, jogadorData2;

    public Lig4(){
        this.jogadas = 0;
        vezDoJogador = (new Random()).nextBoolean();
    }

    protected abstract void jogarPartida(Jogador jogador1, Jogador jogador2);

    protected abstract void reset();
    protected void menu() throws IOException {
        int i =0;
        int j = 1;

        while(true){

            limparTela();
            System.out.println("1 - Partida Normal");
            System.out.println("2 - Lig4 turbo");
            System.out.println("3 - Lig4 turbo maluco");
            System.out.println("4 - Ranking");
            System.out.println("5 - Sair") ;

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    perguntarJogadores();
                    Lig4Jogo lig4Normal = new Lig4Jogo();
                    lig4Normal.jogarPartida(jogadores[i],jogadores[j]);
                    break;
                case 2:
                    perguntarJogadores();
                    Lig4Turbo lig4Turbo = new Lig4Turbo();
                    lig4Turbo.jogarPartida(jogadores[i],jogadores[j]);
                    break;
                case 3:
                    perguntarJogadores();
                    Lig4TurboMaluco turboMaluco = new Lig4TurboMaluco();
                    turboMaluco.jogarPartida(jogadores[i], jogadores[j]);
                    break;
                case 4:
                    rankingJogadores();
                    System.out.println("1 - voltar ao menu");
                    opcao = scanner.nextInt();
                    if(opcao == 1 ){
                        menu();
                    } else {
                        menu();
                    }
                case 5:
                    System.out.println("Jogo encerrado");
                    System.exit(0);
                    break;
            }
            i+=2;
            j+=2;

        }
    }
    public void salvarJogadoresNoJSON(List<JogadorData> jogadoresList) {
        try (FileWriter fileWriter = new FileWriter("dados.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jogadoresList, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rankingJogadores() {
        jogadorList = carregarJogadoresDoJSON();
        jogadorList.sort(Comparator.comparingInt(JogadorData::getVitorias).reversed());
        int posicao = 1;
        for (JogadorData jogador : jogadorList) {
            System.out.println(posicao + "º Lugar - " + jogador.getNome() + " - Vitórias: " + jogador.getVitorias());
            posicao++;
        }
    }
    public ArrayList<JogadorData> carregarJogadoresDoJSON() {
        ArrayList<JogadorData> jogadoresList = new ArrayList<>();
        try (FileReader fileReader = new FileReader("dados.json")) {
            Type jogadorListType = new TypeToken<ArrayList<JogadorData>>(){}.getType();
            Gson gson = new Gson();
            jogadoresList = gson.fromJson(fileReader, jogadorListType);
        } catch (IOException e) {
        }
        return jogadoresList;
    }
    public void addJogador(Jogador jogador) throws IOException {
        jogadorList = new ArrayList<JogadorData>();
        if(jogadores == null){
            jogadores = new Jogador[1];
            jogadores[0] = jogador;
        } else {
            Jogador[] novoArray = new Jogador[jogadores.length + 1];
            for (int i = 0; i < jogadores.length; i++) {
                novoArray[i] = jogadores[i];

            }
            novoArray[jogadores.length] = jogador;
            jogadores = novoArray;
        }
    }
    protected void limparTela(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
    }
    public void pausarTela() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Pressione Enter para continuar...");
        scanner3.nextLine();
    }
    public void perguntarJogadores() throws IOException {
    
        Scanner scanner2 = new Scanner(System.in);
        limparTela();
        System.out.print("Jogador 1: ");
        String nome1 = scanner2.nextLine();
        addJogador(new Jogador(nome1, "A"));
        System.out.println("");
        System.out.print("Jogador 2: ");
        String nome2 = scanner2.nextLine();
        addJogador(new Jogador(nome2, "V"));
        
    }






}
