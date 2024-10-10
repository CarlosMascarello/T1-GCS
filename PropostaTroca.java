import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Random;

public class PropostaTroca {
    private Jogador jogadorOfertante;
    private Jogador jogadorRequisitado;
    private Item itemOferecido;
    private Item itemDesejado;
    private int id;
    private LocalDateTime data;
    private String status;

    //Construtor
    public PropostaTroca(Jogador jogadorOfertante, Jogador jogadorRequisitado, Item itemOferecido, Item itemDesejado) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.jogadorOfertante = jogadorOfertante;
        this.jogadorRequisitado = jogadorRequisitado;
        this.itemOferecido = itemOferecido;
        this.itemDesejado = itemDesejado;
        this.data = LocalDateTime.now();
        this.status = "Pendente";
    }

    //Getters
    public Jogador getJogadorOfertante() {
        return jogadorOfertante;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Jogador getJogadorRequisitado() {
        return jogadorRequisitado;
    }

    public Item getItemOferecido() {
        return itemOferecido;
    }

    public Item getItemDesejado() {
        return itemDesejado;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return "ID (" + id + ") da prospota feito por " + jogadorOfertante.getNome() + " que oferece " + itemOferecido.getNome() + " por " + itemDesejado.getNome() + " do " + jogadorRequisitado.getNome();
    }

    @Override
    public String toString() {
        return "Proposta de Troca:" +
                "\nJogador Ofertante: " + jogadorOfertante +
                "\nJogador Requisitado: " + jogadorRequisitado +
                "\nItem Oferecido: " + itemOferecido +
                "\nItem Desejado: " + itemDesejado +
                "\nStatus: " + status +
                "\nData: " + data + '\n';
    }

    public void aceitarProposta() {
        Item aux = itemDesejado;
        itemDesejado = itemOferecido;
        itemOferecido = aux;
        status = "Aceito";

    }

    public void recusarProposta() {

        status = "Recusado";
    }
}
