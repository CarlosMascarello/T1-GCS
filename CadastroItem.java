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

    public void addItemJogador(Item item, String email) {
        Jogador jogador = cadastro.buscarJogadorPorEmail(email);

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

    public void listarItensOutroJogador(String nome) {
        for (Jogador j : cadastro.getJogadores()) {
            if (j.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Itens do jogador " + nome + ":\n");
                for (Item item : j.getItens()) {
                    System.out.println(item.toString());
                }
                return;
            }
        }
        System.out.println("Jogador não encontrado.");
    }

    public void verificarValor(int id) {
        for (Jogador j : cadastro.getJogadores()) {
            for (Item item : j.getItens()) {
                if (item.getId() == id) {
                    if (item.getPreco() >= 200.00) {
                        System.out.println("Item caro.");
                    } else if (item.getPreco() >= 100.00) {
                        System.out.println("Item de valor médio.");
                    } else {
                        System.out.println("Item barato.");
                    }
                    System.out.println("Valor do item: " + item.getPreco());
                }
            }
        }
    }

    public String verificaItens(int id) {
        for (Jogador j1 : cadastro.getJogadores()) {
            for (Item item : j1.getItens()) {
                if (item.getId() == id) {
                    return "\nNome: " + item.getNome() +
                            "\nRaridade: " + item.getRaridade();
                }
            }
        }
        return "ID incorreto! Não foi possível localizar o item";
    }
}

