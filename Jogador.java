public class Jogador {
    private String nome;
    private String email;
    private int pin;

    //Contrutor
    public Jogador(String nome, String email, int pin) {
        this.nome = nome;
        this.email = email;
        this.pin = pin;
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

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
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
