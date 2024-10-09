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

    public Aplicacao(){
        cadastroJogador = new CadastroJogador();
        cadastroItem = new CadastroItem();
    }

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

        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        sc.next();

        System.out.println("Digite seu email: ");
        email = sc.nextLine();
        sc.next();

        boolean pinValido = false;
        while (!pinValido) {
            System.out.println("Digite seu pin (deve conter exatamente 6 números): ");
            pin = sc.nextInt();


            if (String.valueOf(pin).length() == 6) {
                pinValido = true;

            } else {
                System.out.println("Pin inválido! O pin deve conter exatamente 6 números.");
            }
        }

        Jogador jogador = new Jogador(nome, email, pin );
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
            System.out.println("Digite a descrição do item: ");
            descricao = sc.nextLine();
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

    public void buscaItensNome(){
        String nomeItem;
        System.out.println("Digite o nome do item a ser procurado. ");
        nomeItem = sc.nextLine();
        cadastroItem.buscarItemPorNome(nomeItem);
    }

}
