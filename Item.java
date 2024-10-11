import java.util.Random;

public class Item {
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private double preco;
    private Raridade raridade;
    private String valor;

    //Construtor
    public Item(String nome, String descricao, String tipo, double preco, String valor, Raridade raridade) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.valor = valor;
        this.raridade = raridade;
    }

    public String verificaValor() {

        if(this.valor.equals("") && this.preco < 100) {
            valor = "Valor barato";
        }else if(this.valor.equals("") && this.preco >= 100 && this.preco < 200) {
            valor = "Valor aceitável";
        }else if(this.valor.equals("") && this.preco >= 200) {
            valor = "Valor caro";
        }else{
            valor = "Valor invalido";
        }
        return valor;
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

    public String getValor() {
        return valor;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    //toString
    public String toString() {
        return "Item:" +
                "\nId: " + id +
                "\nNome: " + nome +
                "\nDescricao: " + descricao +
                "\nTipo: " + tipo +
                "\nPreco: " + preco +
                "\nValor: " + valor +
                "\nRaridade: " + raridade + '\n';
    }

    /** Cadastro de Itens */
    /** Exclusão de Itens */
}