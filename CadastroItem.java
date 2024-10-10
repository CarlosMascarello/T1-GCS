public class CadastroItem {
    private CadastroJogador cadastro; // Referência ao CadastroJogador

    // Construtor que recebe uma instância de CadastroJogador
    public CadastroItem(CadastroJogador cadastro) {
        this.cadastro = cadastro; // Usa a instância existente de CadastroJogador
    }

    public void addItemJogador(Item item, int pin) {
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);

        if (jogador != null) {
            jogador.adicionarItem(item);
            System.out.println("Item adicionado ao jogador.");
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    public void removeItem(Item item, int pin) {
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);

        if (jogador != null) {
            jogador.removerItem(item);
            System.out.println("Item removido do jogador.");
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
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);  // Busca o jogador pelo pin

        if (jogador != null) {
            if (jogador.getItens().isEmpty()) {  // Verifica se o jogador tem itens
                System.out.println("Nenhum item encontrado para este jogador.");
            } else {
                for (Item item : jogador.getItens()) {
                    System.out.println(item);  // Exibe cada item
                }
            }
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }
}