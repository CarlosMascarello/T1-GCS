import java.util.ArrayList;

/**
 * Classe CadastroJogador representa o cadastro de um novo jogador e
 * para entrar no sistema.
 */

public class CadastroJogador {
    private ArrayList<Jogador> jogadores;

    /**
     * Construtor da classe CadastroJogador.
     */

    public CadastroJogador() {
        this.jogadores = new ArrayList<>();
    }

    /**
     * Cadastro um novo jogador no sistema, se ainda não existir um jogador com o mesmo pin.
     *
     * @param novoJogador Jogador a ser cadastrado.
     * @return true se o jogador for cadastrado, false se já existir um jogador com esse pin.
     */
    public boolean cadastroJogador(Jogador novoJogador) {
        for (Jogador jogador : jogadores) {
            if (jogador.getEmail().equals(novoJogador.getEmail())) {
                return false;
            }
        }
        jogadores.add(novoJogador);
        return true;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     * Entra no sistema usando como parametro o email e pin.
     *
     * @param email Confere se existe algum jogador com este email.
     * @param pin   Confere se existe um j**ogador com este pin.
     * @return true se o email e pin forem iguais, false se o pin ou o email estiverem errados.
     */
    public boolean entrarSistema(String email, int pin) {
        for (Jogador jogador : jogadores) {
            if (jogador.getEmail().equals(email) && jogador.getPin() == pin) {
                return true;
            }
        }
        return false;
    }

    public Jogador buscarJogadorPorPin(int pin) {
        for (Jogador jogador : jogadores) {
            if (jogador.getPin() == (pin)) {
                return jogador;
            }
        }
        return null;
    }

    public Jogador buscarJogadorPorEmail(String email) {
        for (Jogador jogador : jogadores) {
            if (jogador.getEmail().equals(email)) {
                return jogador;
            }
        }
        return null;
    }

    public Jogador buscarJogadorPorNome(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(nome)) {
                return jogador;
            }
        }
        return null;
    }

    public void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            for (Jogador jogador : jogadores) {
                System.out.println(jogador.toString());
            }
        }
    }
}