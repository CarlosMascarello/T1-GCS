import java.util.Random;

public class Item {
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private double preco;

    //Contrutor
    public Item(String nome, String descricao, String tipo, double preco) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    //toString
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                '}';
    }

    /** Cadastro de Itens */
    /** Exclusão de Itens */
}