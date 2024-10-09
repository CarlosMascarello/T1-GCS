public class PropostaTroca {
    private Jogador jogadorOfertante;
    private Item itemOferecido;
    private Item itemDesejado;

    public PropostaTroca(Jogador jogadorOfertante, Item itemOferecido, Item itemDesejado) {
        this.jogadorOfertante = jogadorOfertante;
        this.itemOferecido = itemOferecido;
        this.itemDesejado = itemDesejado;
    }

    public String getDescricao() {
        return jogadorOfertante.getNome() + " oferece " + itemOferecido.getNome() + " por " + itemDesejado.getNome();
    }

    public String toString() {
        return "Proposta de troca: \n" +
                "Jogador Ofertante: " + jogadorOfertante.getNome() + "\n" +
                "Item Oferecido: " + itemOferecido.getNome() + "\n" +
                "Item Desejado: " + itemDesejado.getNome();
    }
}
