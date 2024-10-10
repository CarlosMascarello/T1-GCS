
import java.util.ArrayList;

/**
 * Classe CadastroItem representa o cadastro de um novo item ao jogador
 */
public class CadastroItem {
    private CadastroJogador cadastroJogador;


    public CadastroItem() {
        this.cadastroJogador = new CadastroJogador();

    }


    public CadastroJogador getCadastroJogador() {
        return cadastroJogador;
    }


    public void addItemJogador(Item item, int pin) {
        boolean jogadorExiste = false;
        for (Jogador j : cadastroJogador.getJogadores()) {
            if (j.getPin() == pin) {
                jogadorExiste = true;
                if (cadastroJogador.getJogadores() != null) {
                    cadastroJogador.getJogador().adicionarItem(item);
                } else {
                    System.out.println("Jogador não encontrado.");
                }
            }
        }
    }

    public void removeItemJogador(Item item, int pin) {
        boolean jogadorExiste = false;
        for (Jogador j : cadastroJogador.getJogadores()) {
            if (j.getPin() == pin) {
                jogadorExiste = true;
                if (cadastroJogador.getJogadores() != null) {
                    cadastroJogador.getJogador().removerItem(item);
                } else {
                    System.out.println("Jogador não encontrado.");
                }
            }
        }
    }


    public Item buscarItemPorNome(String nomeItem) {
        for (Jogador j : cadastroJogador.getJogadores()) {
            for (Item item : j.getItens()) {
                if (item.getNome().equals(nomeItem)) {
                    return item;
                }
            }
        }
        return null;
    }

    public Item listarItensJogador(int pin) {
        for (Jogador j : cadastroJogador.getJogadores()) {
            if (j.getPin() == pin) {
                for (Item item : j.getItens()) {
                    return j.getItem();
                }
            } else {
                System.out.println("Jogador não encontrado.");
            }


        }
        return null;
    }
}

