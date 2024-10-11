import java.util.ArrayList;
import java.util.List;

public class Estatisticas {
    private CadastroJogador cadastroJogador;
    private CadastroItem cadastroItem;
    private PropostaTroca propostaTroca;
    private List<PropostaTroca> listaProposta;

    public Estatisticas(CadastroJogador cadastroJogador, CadastroItem cadastroItem, PropostaTroca propostaTroca) {
        this.cadastroJogador = cadastroJogador;
        this.cadastroItem = cadastroItem;
        this.propostaTroca = propostaTroca;
       // this.listaProposta =
    }

    public int totalJogadores() {
        return cadastroJogador.getJogadores().size();
    }

    public int totalItens() {
        int total = 0;
        for (Jogador jogador : cadastroJogador.getJogadores()) {
            total += jogador.getItens().size();
        }
        return total;
    }

    public double precoTotal() {
        double precoTotal = 0;
        for (Jogador jogador : cadastroJogador.getJogadores()) {
            for (Item item : jogador.getItens()) {
                precoTotal += item.getPreco();
            }
        }
        return precoTotal;
    }

 /*   public int contarPrpostasAceitasERecusadas() {
        int contador = 0;
        for (PropostaTroca proposta :) {

        }
        return contador;
    }*/

    public void mostrarEstatisticasGerais() {
        System.out.println("Estatísticas Gerais:");
        System.out.println("Total de Jogadores: " + totalJogadores());
        System.out.println("Total de Itens: " + totalItens());
        System.out.println("Valor Total dos Itens: " + precoTotal());
        System.out.println("Quantidade de propostas aceitas/recusadas:" + "");
        System.out.println("Quantidade de propostas pendentes: " + "");
    }
}
