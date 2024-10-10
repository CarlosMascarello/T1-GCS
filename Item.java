import java.util.Random;

public class Item {
    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private double preco;

    //Contrutor
    public Item(int id, String nome, String descricao, String tipo, double preco) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    Item i1 = new Item(id,"Katana", "Katana do Leonardo - Tartarugas Ninjas (Item de evento). Voltado a confrontos de curtas distâncias, a Katana tem uma vantagem por ser leve, podendo proporcionar ataques rápidos", "Arma Branca", 250.00);
    Item i2 = new Item(id,"Foice", "Arma branca que consegue dar ataques de curtas a médias distâncias, porém seu ataque será lento", "Arma Branca", 225.50);
    Item i3 = new Item(id,"Arco de longa distância", "Arco feita para confronto de longas distâncias. Contém alto dano, porém demora para recarregar", "Arma a Distância", 100.00);
    Item i4 = new Item(id,"Arco padrão", "Arco padrão", "Arma de Longa Distância", 150.00);
    Item i5 = new Item(id,"Arco de disparo rápido", "Arco feito para confrontos de médias distâncias. Contém alto poder de disparo, porém não tem tanto alcance", "Arma a Distância", 200.00);
    Item i6 = new Item(id,"Armadura", "Feita de couro, por mais leve que seja, ela não suporta tanto ataques", "Proteção", 125.00);
    Item i7 = new Item(id,"Armadura", "Feita com ferro, suporta ataques pesados, porém o jogador perde velocidade", "Proteção", 200.00);
    Item i8 = new Item(id,"Escudo", "Feito com madeira e ferro, ele consegue resistir ataques de curta e longas distâncias", "Proteção", 75.50);
    Item i9 = new Item(id,"Flecha", "Item disparado pelo arco", "Ferramenta", 50.00);


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