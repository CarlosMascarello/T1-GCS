import java.util.*;

public class Aplicacao {

    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private static List<PropostaTroca> propostas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private CadastroJogador cadastroJogador;
    private CadastroItem cadastroItem;
    private PropostaTroca propostaTroca;
    private Estatisticas estatisticas;

    public Aplicacao() {
        cadastroJogador = new CadastroJogador();
        cadastroItem = new CadastroItem(cadastroJogador);
        propostaTroca = new PropostaTroca();
        estatisticas = new Estatisticas(cadastroJogador, cadastroItem, propostaTroca);
    }

    /**
     * Inicio do HUD da Aplicação
     */
    public void executar() {
        easterEgg();
        int opcao;

        while (true) {
            System.out.println(VERDE + "### Bem Vindo ###" + RESET);
            System.out.println(VERDE + "DIGITE A OPÇÃO DESEJADA" + RESET);
            System.out.println(VERDE + "[1] Login" + RESET);
            System.out.println(VERDE + "[2] Criar conta" + RESET);
            System.out.println(VERDE + "[0] Sair" + RESET);

            opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                switch (opcao) {
                    case 1:
                        entrarSistema();
                        hudMenu();
                        break;
                    case 2:
                        registrarJogador();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    public void hudMenu() {
        while (true) {
            System.out.println(VERDE + "[1] Itens" + RESET);
            System.out.println(VERDE + "[2] Efetuar trocas" + RESET);
            System.out.println(VERDE + "[3] Estatíticas Gerais" + RESET);
            System.out.println(VERDE + "[0] Sair" + RESET);
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }
            switch (opcao) {
                case 1:
                    mostrarHUDItens();
                    break;
                case 2:
                    mostrarHUDTrocas();
                    break;
                case 3:
                    mostrarEstatisticasGerais();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void mostrarHUDItens() {
        while (true) {
            System.out.println(VERDE + "[1] Ver seus itens" + RESET);
            System.out.println(VERDE + "[2] Ver itens dos jogadores" + RESET);
            System.out.println(VERDE + "[3] Buscar itens pelo id" + RESET);
            System.out.println(VERDE + "[4] Verificar valor de item (barato/médio/caro)" + RESET);
            System.out.println(VERDE + "[5] Verificar raridade de item (comum/raro/épico/lendário)" + RESET);
            System.out.println(VERDE + "[6] Cadastrar item" + RESET);
            System.out.println(VERDE + "[7] Excluir Itens" + RESET);
            System.out.println(VERDE + "[0] Sair" + RESET);
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 0) {
                System.out.println("Volta ao sistema...");
                break;
            }
            switch (opcao) {
                case 1:
                    listarItems();
                    break;
                case 2:
                    mostrarItensOutroJogador();
                    break;
                case 3:
                    buscaItensId();
                    break;
                case 4:
                    verificaValor();
                    break;
                case 5:
                    mostrarRaridade();
                    break;
                case 6:
                    adicionarItem();
                    break;
                case 7:
                    removerItem();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void mostrarHUDTrocas() {
        while (true) {
            System.out.println(VERDE + "[1] Troca de itens com outro jogador" + RESET);
            System.out.println(VERDE + "[2] Ver propostas de troca" + RESET);
            System.out.println(VERDE + "[3] Verificar propostas recebidas" + RESET);
            System.out.println(VERDE + "[4] Selecionar e aceitar proposta de troca" + RESET);
            System.out.println(VERDE + "[0] Sair" + RESET);
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }

            switch (opcao) {
                case 1:
                    criarPropostaTroca();
                    break;
                case 2:
                    mostrarDetalhesTroca();
                    break;
                case 3:
                    mostrarTrocasOcorridas();
                    break;
                case 4:
                    selecionarPropostaTroca();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void mostrarEstatisticasGerais() {
        estatisticas.mostrarEstatisticasGerais();
    }

    /**
     * Codigos referentes aos itens
     */

    public void adicionarItem() {
        String nomeItem;
        String descricao;
        String tipo;
        Raridade raridade;
        double preco;
        int pin;

        System.out.println("Digite o seu pin: ");
        pin = sc.nextInt();
        sc.nextLine();

        Jogador jogador = cadastroJogador.buscarJogadorPorPin(pin);

        if (jogador != null) {
            System.out.println("Digite o nome do item: ");
            nomeItem = sc.nextLine();

            System.out.println("Digite a descrição do item: ");
            descricao = sc.nextLine();

            System.out.println("Digite o tipo do item: ");
            tipo = sc.nextLine();

            System.out.println("Digite o preço do item: ");
            preco = sc.nextDouble();
            sc.nextLine();

            System.out.println("Escolha a raridade do item: ");
            System.out.println("1- Comum");
            System.out.println("2- Raro");
            System.out.println("3- Épico");
            System.out.println("4- Lendário - (Eventos)");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    raridade = Raridade.COMUM;
                    break;
                case 2:
                    raridade = Raridade.RARO;
                    break;
                case 3:
                    raridade = Raridade.EPICO;
                    break;
                case 4:
                    raridade = Raridade.LENDARIO;
                    break;
                default:
                    raridade = Raridade.COMUM;
                    break;
            }


            Item item = new Item(nomeItem, descricao, tipo, preco, raridade);

            jogador.adicionarItem(item);

            System.out.println("Item adicionado com sucesso ao jogador " + jogador.getNome() + "!");
        } else {
            System.out.println("Jogador não encontrado. Faça o login primeiro!");
        }
    }

    public void removerItem() {
        int id;
        int pin;

        System.out.println("Digite o seu pin para remover o item: ");
        pin = sc.nextInt();

        Jogador jogador = cadastroJogador.buscarJogadorPorPin(pin);
        if (jogador != null) {
            System.out.println("Digite o id do item a ser removido: ");
            id = sc.nextInt();
            sc.nextLine();

            Item item = cadastroItem.buscarItemPorid(id);

            if (item != null) {
                cadastroItem.removeItem(item, pin);
                System.out.println("Item " + item.getNome() + " removido com sucesso!");
            } else {
                System.out.println("Item não encontrado no cadastro.");
            }
        } else {
            System.out.println("Jogador não encontrado. Faça o login primeiro!");
        }
    }

    public void mostrarItensOutroJogador() {
        String nome;

        System.out.println("Digite o nome do outro jogador: ");
        nome = sc.nextLine();

        cadastroItem.listarItensOutroJogador(nome);
    }

    public void buscaItensId() {
        int id;
        System.out.println("Digite o nome do item a ser procurado. ");
        id = sc.nextInt();
        System.out.println(cadastroItem.buscarItemPorid(id));
    }

    public void listarItems() {
        int pin;

        System.out.println("Digite seu pin: ");
        pin = sc.nextInt();

        Jogador jogador = cadastroJogador.buscarJogadorPorPin(pin);
        ArrayList<Item> itens = jogador.getItens();

        Collections.sort(itens, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                return i1.getNome().compareTo(i2.getNome());
            }
        });

        cadastroItem.listarItems(pin);
    }

    public void verificaValor(){
        int pin;
        int id;

        System.out.println("Digite o seu pin: ");
        pin = sc.nextInt();

        if (cadastroJogador.buscarJogadorPorPin(pin) != null) {
            System.out.println("Digite o id do item: ");
            id = sc.nextInt();
            Item item = cadastroItem.buscarItemPorid(id);
            if (item != null) {
                cadastroItem.verificarValor(id);
            } else {
                System.out.println("Item não encontrado");
            }
        } else {
            System.out.println("Jogador não encontrado");
        }
    }

    public void mostrarRaridade() {
        System.out.println("Digite o id do item que deseja ver a raridade");
        int id = sc.nextInt();
        System.out.println(cadastroItem.verificaItens(id));
    }

    /**
     * Codigos referentes as trocas
     */

    public void criarPropostaTroca() {
        System.out.println("Digite o seu nome");
        String nomeProp = sc.nextLine();

        System.out.println("Digite o ID do item que deseja enviar");
        int idProp = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o nome do usuário que tem o item que desejas");
        String nomeRequi = sc.nextLine();

        System.out.println("Digite o ID do item que deseja receber");
        int idRequi = sc.nextInt();
        sc.nextLine();


        Jogador j1 = cadastroJogador.buscarJogadorPorNome(nomeProp);
        Jogador j2 = cadastroJogador.buscarJogadorPorNome(nomeRequi);
        Item i1 = cadastroItem.buscarItemPorid(idProp);
        Item i2 = cadastroItem.buscarItemPorid(idRequi);

        if (j1 != null && j2 != null && i1 != null && i2 != null) {
            propostaTroca = new PropostaTroca(j1, j2, i1, i2,  cadastroItem);
            propostas.add(propostaTroca);
            System.out.println("O id da proposta é " + propostaTroca.getId());
        } else
            System.out.println("Erro de digitação encontrado! Tente novamnete");
    }

    public void selecionarPropostaTroca() {

        if (propostas.isEmpty()) {
            System.out.println("Nenhuma proposta de troca disponível.");
            return;
        }

        System.out.println("Selecione uma proposta para visualizar as opções:");
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
                proposta.aceitarProposta();
                propostas.remove(proposta);
            } else if (resposta == 2) {
                System.out.println("Proposta rejeitada.");
                proposta.recusarProposta();
                propostas.remove(proposta);
            }
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public void mostrarDetalhesTroca() {
        boolean existeProposta = false;
        System.out.println("Qual o id da proposta?");
        int aux = sc.nextInt();
        for (PropostaTroca proposta : propostas) {
            if (proposta.getId() == aux) {
                System.out.println(proposta.getDescricao());
                existeProposta = true;
            }
        }
        if (!existeProposta) {
            System.out.println("ID não localizado!");
        }
    }

    public void mostrarTrocasOcorridas() {
        if (propostas.isEmpty())
            System.out.println("Trocas não localizadas");
        else {
            for (PropostaTroca proposta : propostas) {
                System.out.println(proposta.toString());
            }
        }
    }

    /**
     * Codigo referente ao login
     */

    public void entrarSistema() {
        int pin;
        String email;

        System.out.println("Digite seu e-mail: ");
        email = sc.nextLine();

        System.out.println("Digite seu pín: ");
        pin = sc.nextInt();
        sc.nextLine();

        if (cadastroJogador.entrarSistema(email, pin)) {
            System.out.println("Login feito com sucesso!");
        } else {
            System.out.println("Dados incorretos ou faça o cadastro primeiro!");
        }
    }

    public void registrarJogador() {
        String nome;
        String email;
        int pin = 0;

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

    /** Menu */
    /** Jogadores */
    /**
     * nome, email, pin
     */
    public void easterEgg() {
        Jogador j1 = new Jogador("Ricardo", "rcarvalho@gmail.com", 212121);
        Jogador j2 = new Jogador("Gustavo", "gsilva@gmail.com", 191919);
        Jogador j3 = new Jogador("Roberto", "robertinhoC@gmail.com", 696969);
        Jogador j4 = new Jogador("Júlia", "julipinheiro@gmail.com", 252525);
        Jogador j5 = new Jogador("Gabriel", "gabrielr@gmail.com", 272727);

        cadastroJogador.cadastroJogador(j1);
        cadastroJogador.cadastroJogador(j2);
        cadastroJogador.cadastroJogador(j3);
        cadastroJogador.cadastroJogador(j4);
        cadastroJogador.cadastroJogador(j5);
        /** Itens */
        /**
         * nome, descricao, tipo, preco
         */
        Item i1 = new Item("Katana", "Katana do Leonardo - Tartarugas Ninjas (Item de evento). Voltado a confrontos de curtas distâncias, a Katana tem uma vantagem por ser leve, podendo proporcionar ataques rápidos", "Arma Branca", 250.00, Raridade.LENDARIO);
        Item i2 = new Item("Foice", "Arma branca que consegue dar ataques de curtas a médias distâncias, porém seu ataque será lento", "Arma Branca", 225.50, Raridade.RARO);
        Item i3 = new Item("Arco de longa distância", "Arco feito para confronto de longas distâncias. Contém alto dano, porém demora para recarregar", "Arma a Distância", 100.00, Raridade.RARO);
        Item i4 = new Item("Arco padrão", "Arco padrão", "Arma de Longa Distância", 150.00, Raridade.COMUM);
        Item i5 = new Item("Arco de disparo rápido", "Arco feito para confrontos de médias distâncias. Contém alto poder de disparo, porém não tem tanto alcance", "Arma a Distância", 200.00, Raridade.RARO);
        Item i6 = new Item("Armadura", "Feita de couro, por mais leve que seja, ela não suporta tanto ataques", "Proteção", 125.00, Raridade.RARO);
        Item i7 = new Item("Armadura", "Feita com ferro, suporta ataques pesados, porém o jogador perde velocidade", "Proteção", 200.00, Raridade.EPICO);
        Item i8 = new Item("Escudo", "Feito com madeira e ferro, ele consegue resistir ataques de curta e longas distâncias", "Proteção", 75.50, Raridade.COMUM);
        Item i9 = new Item("Flecha", "Item disparado pelo arco", "Ferramenta", 50.00, Raridade.COMUM);

        cadastroItem.addItemJogador(i1, "rcarvalho@gmail.com");
        cadastroItem.addItemJogador(i2, "gsilva@gmail.com");
        cadastroItem.addItemJogador(i3, "julipinheiro@gmail.com");
        cadastroItem.addItemJogador(i4, "robertinhoC@gmail.com");
        cadastroItem.addItemJogador(i5, "rcarvalho@gmail.com");
        cadastroItem.addItemJogador(i6, "gabrielr@gmail.com");
        cadastroItem.addItemJogador(i7, "julipinheiro@gmail.com");
        cadastroItem.addItemJogador(i8, "gabrielr@gmail.com");
        cadastroItem.addItemJogador(i9, "gsilva@gmail.com");

        System.out.println("Easter Egg adicionado");
    }
}