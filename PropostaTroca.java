import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

public class PropostaTroca {
    private Jogador jogadorOfertante;
    private Jogador jogadorRequisitado;
    private Item itemOferecido;
    private Item itemDesejado;
    private CadastroItem cadastroItem;
    private int id;
    private LocalDateTime data;
    private String status;
    private ArrayList<PropostaTroca> propostas = new ArrayList<>();
    private int contatorTrocasEfetuadas = 0;
    private int contatorRequisitadosEfetuadas = 0;

    //Construtor
    public PropostaTroca(Jogador jogadorOfertante, Jogador jogadorRequisitado, Item itemOferecido, Item itemDesejado, CadastroItem cadastroItem) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.jogadorOfertante = jogadorOfertante;
        this.jogadorRequisitado = jogadorRequisitado;
        this.itemOferecido = itemOferecido;
        this.itemDesejado = itemDesejado;
        this.data = LocalDateTime.now();
        this.status = "Pendente";
        this.cadastroItem = cadastroItem;
       // this.propostas = new ArrayList<>();
    }

    public PropostaTroca() {
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

    public List<PropostaTroca> getPropostas() {
        return propostas;
    }

    public int getContatorTrocasEfetuadas() {
        return contatorTrocasEfetuadas;
    }

    public int getContatorRequisitadosEfetuadas() {
        return contatorRequisitadosEfetuadas;
    }

    public void setContatorTrocasEfetuadas(int contatorTrocasEfetuadas) {
        this.contatorTrocasEfetuadas = contatorTrocasEfetuadas;
    }

    public void setContatorRequisitadosEfetuadas(int contatorRequisitadosEfetuadas) {
        this.contatorRequisitadosEfetuadas = contatorRequisitadosEfetuadas;
    }

    public String getDescricao() {
        return "ID (" + id + ") da prospota feita por " + jogadorOfertante.getNome() + " que oferece " + itemOferecido.getNome() + " por " + itemDesejado.getNome() + " pertencente à " + jogadorRequisitado.getNome();
    }

    @Override
    public String toString() {
        return "Proposta de Troca:" + "\nJogador Ofertante: " + jogadorOfertante.detalharJogador() + "\nJogador Requisitado: " + jogadorRequisitado.detalharJogador() + "\nItem Oferecido: " + itemOferecido.detalharItem() + "\nItem Desejado: " + itemDesejado.detalharItem() + "\nStatus: " + status + "\nData: " + data + '\n';
    }

    public void aceitarProposta() {
        cadastroItem.addItemJogador(itemDesejado, jogadorOfertante.getEmail());
        cadastroItem.removeItem(itemDesejado, jogadorRequisitado.getPin());
        cadastroItem.addItemJogador(itemOferecido, jogadorRequisitado.getEmail());
        cadastroItem.removeItem(itemOferecido, jogadorOfertante.getPin());
        status = "Aceito";
    }

    public void recusarProposta() {
        status = "Recusado";
    }
}

