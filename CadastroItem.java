public class CadastroItem {
    private CadastroJogador cadastro; // Referência ao CadastroJogador

    // Construtor que recebe uma instância de CadastroJogador
    public CadastroItem(CadastroJogador cadastro) {
        this.cadastro = cadastro;
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
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    public Item buscarItemPorid(int id) {
        for (Jogador j : cadastro.getJogadores()) {
            for (Item item : j.getItens()) {
                if (item.getId() == id) {
                    return item;
                }
            }
        }
        return null;
    }

    public void listarItems(int pin) {
        Jogador jogador = cadastro.buscarJogadorPorPin(pin);

        if (jogador != null) {
            if (jogador.getItens().isEmpty()) {
                System.out.println("Nenhum item encontrado para este jogador.");
            } else {
                for (Item item : jogador.getItens()) {
                    System.out.println(item);
                }
            }
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }
}

