import java.util.*;

public class OrdenaOrdemAlfabetica {
    public static void main(String[] args) {

        //Chamar o array do inventario do usuário
        ArrayList<String> Lista = new ArrayList<>();

        //Genéricos para itens do usuário
        //Evite usar acentuação na fase inicial do projeto
        Lista.add("Talisma do Vladimir Polamski");
        Lista.add("Cetro Dom Pedro II");
        Lista.add("Calice do Chico Buarque");

        //Ordena de A até Z
        Collections.sort(Lista);

        //Printa
        System.out.println(Lista);

    }
}