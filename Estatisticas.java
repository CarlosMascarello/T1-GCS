public class Estatisticas {
    private CadastroJogador cadastroJogador;
    private CadastroItem cadastroItem;
    private PropostaTroca propostaTroca;

    public Estatisticas(CadastroJogador cadastroJogador, CadastroItem cadastroItem, PropostaTroca propostaTroca) {
        this.cadastroJogador = cadastroJogador;
        this.cadastroItem = cadastroItem;
        this.propostaTroca = propostaTroca;
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

    public int contarPropostasAceitasERecusadas() {
        int contador = 0;
        if (propostaTroca != null) {
            for (PropostaTroca proposta : propostaTroca.getPropostas()) {
                if (proposta.getStatus().equals("Recusado") || proposta.getStatus().equals("Aceito")) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void mostrarEstatisticasGerais() {
        System.out.println("Estatísticas Gerais:");
        System.out.println("Total de Jogadores: " + totalJogadores());
        System.out.println("Total de Itens: " + totalItens());
        System.out.println("Valor Total dos Itens: " + precoTotal());
        int propostasAceitasERecusadas = contarPropostasAceitasERecusadas();
        System.out.println("Quantidade de propostas aceitas/recusadas: " + propostasAceitasERecusadas);

        int propostasPendentes = propostaTroca.getPropostas().size() - propostasAceitasERecusadas;
        System.out.println("Quantidade de propostas pendentes: " + propostasPendentes);
    }
}

