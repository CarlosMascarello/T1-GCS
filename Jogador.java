import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String email;

    private int pin;
    private ArrayList<Item> itens;
    private Item item;

    public Item getItem() {
        return item;
    }


    //Contrutor
    public Jogador(String nome, String email, String pin) {
        this.nome = nome;
        this.email = email;
        this.pin = pin;
        this.itens = new ArrayList<>();
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    //toString
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", pin=" + pin +
                '}';
    }


    /** Criar usuário */
}
