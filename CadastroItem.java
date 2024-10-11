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
                System.out.println("Itens do jogador "+nome + ":\n");
                for (Item item : j.getItens()) {
                    System.out.println(item.toString());
                }
                return;
            }
        }
        System.out.println("Jogador não encontrado.");
    }

    public String verificaValor(int id) {

        String valor = "";

        for (Jogador j : cadastro.getJogadores()) {
            for (Item item : j.getItens()) {
                if (item.getPreco() < 100.0) {
                    valor = "valor barato";
                } else if (item.getPreco() >= 100.0 && item.getPreco() < 200.0) {
                    valor = "valor aceitável";
                } else if (item.getPreco() >= 200.0) {
                    valor = "valor caro";
                } else {
                    valor = "Valor invalido";
                }
            }
        }
        System.out.println("Este item possui um " + valor);
        return valor;
    }
}
