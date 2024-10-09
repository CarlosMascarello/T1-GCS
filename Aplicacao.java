import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private static List<PropostaTroca> propostas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private CadastroJogador cadastroJogador;
    private CadastroItem cadastroItem;
    private Jogador jogador;

    public Aplicacao() {
        cadastroJogador = new CadastroJogador();
        cadastroItem = new CadastroItem();
    }

    /** Menu */
    /** Jogadores */
    /**
     * nome, email, pin
     */
    Jogador j1 = new Jogador("Ricardo Carvalho", "rcarvalho@gmail.com", 212121);
    Jogador j2 = new Jogador("Gustavo Silva", "gsilva@gmail.com", 191919);
    Jogador j3 = new Jogador("Roberto Cobre", "robertinhoC@gmail.com", 696969);
    Jogador j4 = new Jogador("Júlia Pinheiro", "julipinheiro@gmail.com", 252525);
    Jogador j5 = new Jogador("Gabriel Ribeiro", "gabrielr@gmail.com", 272727);

    /** Itens */
    /**
     * nome, descricao, tipo, preco
     */
    Item i1 = new Item("Katana", "Katana do Leonardo - Tartarugas Ninjas (Item de evento). Voltado a confrontos de curtas distâncias, a Katana tem uma vantagem por ser leve, podendo proporcionar ataques rápidos", "Arma Branca", 250.00);
    Item i2 = new Item("Foice", "Arma branca que consegue dar ataques de curtas a médias distâncias, porém seu ataque será lento", "Arma Branca", 225.50);
    Item i3 = new Item("Arco de longa distância", "Arco feita para confronto de longas distâncias. Contém alto dano, porém demora para recarregar", "Arma a Distância", 100.00);
    Item i4 = new Item("Arco padrão", "Arco padrão", "Arma de Longa Distância", 150.00);
    Item i5 = new Item("Arco de disparo rápido", "Arco feito para confrontos de médias distâncias. Contém alto poder de disparo, porém não tem tanto alcance", "Arma a Distância", 200.00);
    Item i6 = new Item("Armadura", "Feita de couro, por mais leve que seja, ela não suporta tanto ataques", "Proteção", 125.00);
    Item i7 = new Item("Armadura", "Feita com ferro, suporta ataques pesados, porém o jogador perde velocidade", "Proteção", 200.00);
    Item i8 = new Item("Escudo", "Feito com madeira e ferro, ele consegue resistir ataques de curta e longas distâncias", "Proteção", 75.50);
    Item i9 = new Item("Flecha", "Item disparado pelo arco", "Ferramenta", 50.00);

    public void executar() {

        int opcao;

        do {
            System.out.println(VERDE + "### Sistema de Trocas ###" + RESET);
            System.out.println(VERDE + "DIGITE A OPÇÃO DESEJADA" + RESET);
            System.out.println(VERDE + "[1] Cadastrar novo jogador" + RESET);
            System.out.println(VERDE + "[2] Ver seus itens" + RESET);
            System.out.println(VERDE + "[3] Ver itens dos jogadores" + RESET);
            System.out.println(VERDE + "[4] Buscar itens" + RESET);
            System.out.println(VERDE + "[5] Troca de itens com outro jogador" + RESET);
            System.out.println(VERDE + "[6] Ver propostas de troca" + RESET);
            System.out.println(VERDE + "[7] Verificar propostas recebidas" + RESET);
            System.out.println(VERDE + "[8] Exibir estatísticas gerais" + RESET);
            System.out.println(VERDE + "[9] Verificar valor de item (barato/médio/caro)" + RESET);
            System.out.println(VERDE + "[10] Verificar raridade de item (comum/raro/épico)" + RESET);
            System.out.println(VERDE + "[11] Cadastrar item" + RESET);
            System.out.println(VERDE + "[12] Selecionar e aceitar proposta de troca" + RESET);
            System.out.println(VERDE + "[0] Sair" + RESET);

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    registrarJogador();
                    break;
                case 2:
                    // Implementar visualização dos itens do jogador
                    break;
                case 3:
                    // Implementar visualização dos itens de outros jogadores
                    break;
                case 4:
                    buscaItensNome();
                    break;
                case 5:
                    // Implementar troca de itens
                    break;
                case 6:
                    // Implementar visualização de propostas de troca
                    break;
                case 7:
                    selecionarPropostaTroca();
                    break;
                case 8:
                    // Implementar exibição de estatísticas gerais
                    break;
                case 9:
                    // Implementar verificação do valor de um item
                    break;
                case 10:
                    // Implementar verificação da raridade de um item
                    break;
                case 11:
                    adicionarItem();
                    break;
                case 12:
                    selecionarPropostaTroca();
                    break;
                case 13:
                    cadastroJogador.listarJogadores();
                    break;
                case 14:
                    listarItems();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void registrarJogador() {
        String nome;
        String email;
        int pin = 0;

        sc.nextLine();

        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();


        System.out.println("Digite seu email: ");
        email = sc.nextLine();


        boolean pinValido = false;
        while (!pinValido) {
            System.out.println("Digite seu pin (deve conter exatamente 6 números): ");
            pin = sc.nextInt();
            sc.nextLine();

            if (String.valueOf(pin).length() == 6) {
                pinValido = true;

            } else {
                System.out.println("Pin inválido! O pin deve conter exatamente 6 números.");
            }
        }

        Jogador jogador = new Jogador(nome, email, pin);
        if (cadastroJogador.cadastroJogador(jogador)) {
            System.out.println("Jogador Cadastrado com sucesso!");
        }
    }

    public void adicionarItem() {
        String nomeItem;
        String descricao;
        String tipo;
        double preco;
        int pin;

        System.out.println("Digite o seu pin: ");
        pin = sc.nextInt();

        Jogador jogador = cadastroJogador.buscarJogadorPorPin(pin);

        if (jogador != null) {
            System.out.println("Digite o nome do item: ");
            nomeItem = sc.nextLine();
            sc.next();
            System.out.println("Digite a descrição do item: ");
            descricao = sc.nextLine();
            sc.nextLine();
            System.out.println("Digite a tipo do item: ");
            tipo = sc.nextLine();
            System.out.println("Digite o preço do item: ");
            preco = sc.nextDouble();
            sc.nextLine();

            Item item = new Item(nomeItem, descricao, tipo, preco);
            cadastroItem.addItemJogador(item, pin);
            System.out.println("Item adicionado com sucesso!");
        } else {
            System.out.println("Jogador não encontrado. Faça o login primeiro!");
        }
    }

    public void removerItem() {
        String nomeItem;
        int pin;

        System.out.println("Digite o seu pin para remover o item: ");
        pin = sc.nextInt();


        Jogador jogador = cadastroJogador.buscarJogadorPorPin(pin);
        if (jogador != null) {
            System.out.println("Digite o nome do item a ser removido: ");
            nomeItem = sc.nextLine();

            Item item = cadastroItem.buscarItemPorNome(nomeItem);

            if (item != null) {
                cadastroItem.removeItem(item, pin);
                System.out.println("Item removido com sucesso!");
            } else {
                System.out.println("Item não encontrado no cadastro.");
            }
        } else {
            System.out.println("Jogador não encontrado. Faça o login primeiro!");
        }
    }

    public void selecionarPropostaTroca() {

        if (propostas.isEmpty()) {
            System.out.println("Nenhuma proposta de troca disponível.");
            return;
        }

        System.out.println("Selecione uma proposta para visualizar detalhes:");
        for (int i = 0; i < propostas.size(); i++) {
            System.out.println("[" + i + "] " + propostas.get(i).getDescricao());
        }

        int escolha = sc.nextInt();
        if (escolha >= 0 && escolha < propostas.size()) {
            PropostaTroca proposta = propostas.get(escolha);
            System.out.println("Detalhes da proposta: ");
            System.out.println(proposta);

            System.out.println("Deseja aceitar esta proposta? (1 - Sim / 2 - Não)");
            int resposta = sc.nextInt();

            if (resposta == 1) {
                System.out.println("Proposta aceita.");
                propostas.remove(proposta);
            } else {
                System.out.println("Proposta rejeitada.");
            }
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public void buscaItensNome() {
        String nomeItem;
        System.out.println("Digite o nome do item a ser procurado. ");
        nomeItem = sc.nextLine();
        cadastroItem.buscarItemPorNome(nomeItem);
    }

    public void listarItems() {
        int pin;

        System.out.println("Digite seu pin: ");
        pin = sc.nextInt();

        cadastroItem.listarItems(pin);
    }
}
