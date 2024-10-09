
import java.util.ArrayList;

/**
 * Classe CadastroItem representa o cadastro de um novo item ao jogador
 */
public class CadastroItem {
    private CadastroJogador cadastro;

    public CadastroItem() {
        this.cadastro = new CadastroJogador();
    }


    public void addItemJogador(Item item, int pin) {
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);

        if (jogador != null) {
            jogador.adicionarItem(item);
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    public void removeItem(Item item, int pin) {
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);

        if (jogador != null) {
            jogador.removerItem(item);
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }


    public Item buscarItemPorNome(String nomeItem) {
        for (Jogador j : cadastro.getJogadores()) {
            for (Item item : j.getItens()) {
                if (item.getNome().equals(nomeItem)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void listarItems(int pin) {
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);

        if (jogador != null) {
            for (Item item : jogador.getItens()) {
                System.out.println(item);
            }
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }
}

