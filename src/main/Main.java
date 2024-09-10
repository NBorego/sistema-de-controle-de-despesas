package src.main;

import src.controller.DespesaController;
import src.controller.TipoDespesaController;
import src.controller.UsuarioController;
import src.model.Despesa;
import src.model.TipoDespesa;
import src.model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Classe principal para executar o sistema de controle de despesas.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DespesaController despesaController = new DespesaController();
    private static final TipoDespesaController tipoDespesaController = new TipoDespesaController();
    private static final UsuarioController usuarioController = new UsuarioController();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Menu Principal:");
            System.out.println("1. Entrar Despesa");
            System.out.println("2. Anotar Pagamento");
            System.out.println("3. Listar Despesas em Aberto no Período");
            System.out.println("4. Listar Despesas Pagas no Período");
            System.out.println("5. Gerenciar Tipos de Despesa");
            System.out.println("6. Gerenciar Usuários");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    entrarDespesa();
                    break;
                case 2:
                    anotarPagamento();
                    break;
                case 3:
                    listarDespesas("aberto");
                    break;
                case 4:
                    listarDespesas("pago");
                    break;
                case 5:
                    gerenciarTiposDespesa();
                    break;
                case 6:
                    gerenciarUsuarios();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void entrarDespesa() {
        System.out.println("Digite a descrição da despesa:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor da despesa:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Digite a data de vencimento (YYYY-MM-DD):");
        LocalDate dataVencimento = LocalDate.parse(scanner.nextLine());
        System.out.println("Digite o tipo de despesa:");
        String tipoNome = scanner.nextLine();
        TipoDespesa tipoDespesa = new TipoDespesa(tipoNome);

        Despesa despesa = new Despesa(descricao, valor, dataVencimento, tipoDespesa);
        despesaController.adicionarDespesa(despesa);
        System.out.println("Despesa adicionada com sucesso.");
    }

    private static void anotarPagamento() {
        System.out.println("Digite a descrição da despesa para anotar pagamento:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor do pagamento:");
        double valorPagamento = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Digite a data do pagamento (YYYY-MM-DD):");
        LocalDate dataPagamento = LocalDate.parse(scanner.nextLine());

        despesaController.anotarPagamento(descricao, valorPagamento, dataPagamento);
    }

    private static void listarDespesas(String status) {
        System.out.println("Digite a data de início (YYYY-MM-DD):");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());
        System.out.println("Digite a data de fim (YYYY-MM-DD):");
        LocalDate fim = LocalDate.parse(scanner.nextLine());

        despesaController.listarDespesas(status, inicio, fim);
    }

    private static void gerenciarTiposDespesa() {
        System.out.println("1. Adicionar Tipo de Despesa");
        System.out.println("2. Listar Tipos de Despesa");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Digite o nome do tipo de despesa:");
                String nomeTipo = scanner.nextLine();
                TipoDespesa tipoDespesa = new TipoDespesa(nomeTipo);
                tipoDespesaController.adicionarTipoDespesa(tipoDespesa);
                System.out.println("Tipo de despesa adicionado com sucesso.");
                break;
            case 2:
                tipoDespesaController.listarTiposDespesa();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void gerenciarUsuarios() {
        System.out.println("1. Adicionar Usuário");
        System.out.println("2. Listar Usuários");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Digite o login do usuário:");
                String login = scanner.nextLine();
                System.out.println("Digite a senha do usuário:");
                String senha = scanner.nextLine();
                Usuario usuario = new Usuario(login, senha);
                usuarioController.adicionarUsuario(usuario);
                System.out.println("Usuário adicionado com sucesso.");
                break;
            case 2:
                usuarioController.listarUsuarios();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
