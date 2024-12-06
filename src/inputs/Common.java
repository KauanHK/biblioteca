package inputs;

import biblioteca.Biblioteca;

import java.util.Scanner;

public class Common {

    private static final int CADASTRAR = 1;
    private static final int FAZER_EMPRESTIMO = 2;
    private static final int FINALIZAR_EMPRESTIMO = 3;
    private static final int PAGAR_MULTA = 4;
    private static final int GERAR_RELATORIO = 5;
    private static final int SAIR = 6;
    private static final int ADICIONAR_DADOS = 7;

    private static boolean dadosAdicionados = false;

    public static int getSair(){
        return SAIR;
    }

    public static int getOpcao(Scanner scanner, int numOpcoes){

        while (true){
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                if (opcao >= 0 && opcao <= numOpcoes) {
                    scanner.nextLine();
                    return opcao;
                }
            }
            scanner.next();
            System.out.println("Opção inválida.");
        }

    }

    public static void exibirOpcoes(){
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Fazer empréstimo");
        System.out.println("3 - Finalizar empréstimo");
        System.out.println("4 - Pagar multa(s)");
        System.out.println("5 - Gerar relatório");
        System.out.println("6 - Finalizar programa");
        if (!dadosAdicionados){
            System.out.println("7 - Adicionar dados fictícios");
        }
    }

    public static void executar(Scanner scanner, Biblioteca biblioteca, int opcao){

        System.out.println();
        switch (opcao){

            case ADICIONAR_DADOS:
                dadosAdicionados = true;
                DadosFicticios.adicionar(biblioteca);
                break;

            case CADASTRAR:
                Cadastro.cadastrar(scanner, biblioteca);
                break;

            case FAZER_EMPRESTIMO:
                Emprestimo.fazerEmprestimo(scanner, biblioteca);
                break;

            case GERAR_RELATORIO:
                Relatorio.gerar(scanner, biblioteca);
                break;

            case SAIR:
                System.out.println("Finalizando programa...");
                break;

            default:
                System.out.println("Entrada inválida");

        }
        System.out.println();

    }

}
