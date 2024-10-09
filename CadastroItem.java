
import java.util.ArrayList;

/**
 * Classe CadastroItem representa o cadastro de um novo item ao jogador
 */
public class CadastroItem {
    private CadastroJogador cadastro;
    private Jogador jogador;

    public CadastroItem() {
        this.cadastro = new CadastroJogador();
        this.jogador = jogador;
    }


    public void addItemJogador(Item item, int pin) {
        for (Jogador j : cadastro.getJogadores()) {
            if (j.getPin() == pin) {
                j.adicionarItem(item);
                jogador.getItens().add(item);
                return;
            }
        }
    }

    public void removeItem(Item item, int pin) {
        for (Jogador j : cadastro.getJogadores()) {
            if (j.getPin() == pin) {
                j.removerItem(item);
               jogador.getItens().remove(item);
                return;
            }
        }
    }

    public Item buscarItemPorNome(String nomeItem) {
        for (Item item : jogador.getItens()) {
            if (item.getNome().equals(nomeItem)) {
                return item;
            }
        }
        return null;
    }
}
