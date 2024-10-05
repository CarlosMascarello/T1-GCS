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
            if (jogador.getPin().equals(novoJogador.getPin())) {
                return false;
            }

        }
        jogadores.add(novoJogador);
        return true;
    }

    /**
     * Entra no sistema usando como parametro o email e pin.
     *
     * @param email Confere se existe algum jogador com este email.
     * @param pin   Confere se existe um jogador com este pin.
     * @return true se o email e pin forem iguais, false se o pin ou o email estiverem errados.
     */
    public boolean entrarSistema(String email, String pin) {
        for (Jogador jogador : jogadores) {
            if (jogador.getEmail().equals(email) && jogador.getPin().equals(pin)) {
                return true;
            }
        }
        return false;
    }
}



