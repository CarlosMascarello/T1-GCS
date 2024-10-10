import java.util.ArrayList;
import java.util.List;

 public class metodoRaridade {
    private String nome;
    private final Raridade  raridade;

    public metodoRaridade(String nome, Raridade raridade) {
        this.nome = nome;
        this.raridade = raridade;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    @Override
    public String toString() {
        return nome + " (" + raridade + ")";
    }
}