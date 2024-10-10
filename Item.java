import java.util.Random;

public class Item {
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private double preco;
    private Raridade raridade;

    //Contrutor
    public Item(String nome, String descricao, String tipo, double preco, Raridade raridade) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.raridade = raridade;
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

    public Raridade getRaridade() {
        return raridade;
    }

    //toString
    public String toString() {
        return "Item:" +
                "Id: " + id +
                "Nome: " + nome + '\n' +
                "Descricao: " + descricao + '\n' +
                "Tipo: " + tipo + '\n' +
                "Preco: " + preco + '\n' +
                "Raridade: " + raridade + '\n';
    }

    /** Cadastro de Itens */
    /** Exclusão de Itens */
}