
import java.util.ArrayList;

/**
 * Classe CadastroItem representa o cadastro de um novo item ao jogador
 */
public class CadastroItem {
    private ArrayList<Item> itens;
    private CadastroJogador cadastro;
    private ArrayList<Jogador> jogadores;

    public CadastroItem() {
        this.itens = new ArrayList<>();
        this.cadastro = new CadastroJogador();
    }


    public void addItemJogador(Item item, int pin) {
        for (Jogador j : jogadores) {
            if (j.getPin() == pin) {
                j.adicionarItem(item);
                this.itens.add(item);
                return;
            }
        }
    }

    public void removeItem(Item item, int pin) {
        for (Jogador j : jogadores) {
            if (j.getPin() == pin) {
                j.removerItem(item);
                this.itens.remove(item);
                return;
            }
        }
    }

    public Item buscarItemPorNome(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equals(nomeItem)) {
                return item;
            }
        }
        return null;
    }
}
