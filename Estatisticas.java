public class Estatisticas {
    private CadastroJogador cadastroJogador;
    private CadastroItem cadastroItem;

    public Estatisticas(CadastroJogador cadastroJogador, CadastroItem cadastroItem) {
        this.cadastroJogador = cadastroJogador;
        this.cadastroItem = cadastroItem;
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

    public void mostrarEstatisticasGerais() {
        System.out.println("Estatísticas Gerais:");
        System.out.println("Total de Jogadores: " + totalJogadores());
        System.out.println("Total de Itens: " + totalItens());

    }
}
