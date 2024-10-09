import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private static List<PropostaTroca> propostas = new ArrayList<>();

    private static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(VERDE + "### Sistema de Trocas ###" + RESET);
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

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Implementar cadastro de jogador
                    break;
                case 2:
                    // Implementar visualização dos itens do jogador
                    break;
                case 3:
                    // Implementar visualização dos itens de outros jogadores
                    break;
                case 4:
                    // Implementar busca de itens
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
                    // Implementar cadastro de item
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

    private static void selecionarPropostaTroca() {
        Scanner scanner = new Scanner(System.in);
        if (propostas.isEmpty()) {
            System.out.println("Nenhuma proposta de troca disponível.");
            return;
        }

        System.out.println("Selecione uma proposta para visualizar detalhes:");
        for (int i = 0; i < propostas.size(); i++) {
            System.out.println("[" + i + "] " + propostas.get(i).getDescricao());
        }

        int escolha = scanner.nextInt();
        if (escolha >= 0 && escolha < propostas.size()) {
            PropostaTroca proposta = propostas.get(escolha);
            System.out.println("Detalhes da proposta: ");
            System.out.println(proposta);

            System.out.println("Deseja aceitar esta proposta? (1 - Sim / 2 - Não)");
            int resposta = scanner.nextInt();

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

    public static void main(String[] args) {
        exibirMenu();
    }
}
