import java.util.Scanner;

public class Main {

    private static final int CADASTRAR = 1;
    private static final int FAZER_EMPRESTIMO = 2;
    private static final int FINALIZAR_EMPRESTIMO = 3;
    private static final int PAGAR_MULTA = 4;
    private static final int GERAR_RELATORIO = 5;
    private static final int SAIR = 0;

    public static void main(String[] args) {

        int opcao;
        Acervo acervo = new Acervo();
        acervo.adicionarLivro(new Livro("Diário de um banana 1", "Robert Einstein", 2012));
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(acervo);
        do {

            exibirOpcoes();
            opcao = getOpcao(scanner, 5);
            executar(scanner, biblioteca, opcao);

        } while (opcao != 0);

    }

    private static void exibirOpcoes(){
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Fazer empréstimo");
        System.out.println("3 - Finalizar empréstimo");
        System.out.println("4 - Pagar multa(s)");
        System.out.println("5 - Gerar relatório");
        System.out.println("0 - Finalizar programa");
    }

    private static int getOpcao(Scanner scanner, int max){
        while (true){
            System.out.print("Escolha um opcao: ");
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                if (opcao >= 0 && opcao <= max)
                    return opcao;
            }
            scanner.next();
            System.out.println("Opção inválida.");
        }
    }

    private static void executar(Scanner scanner, Biblioteca biblioteca, int opcao){

        switch (opcao){

            case CADASTRAR:
                cadastrar(scanner, biblioteca);
                break;
            case SAIR:
                System.out.println("Finalizando programa...");
                break;
            default:
                System.out.println("Entrada inválida");

        }

    }

    private static void cadastrar(Scanner scanner, Biblioteca biblioteca){

        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Professor");
        System.out.println("3 - Cadastrar Funcionário");
        System.out.println("0 - Voltar");
        int opcao = getOpcao(scanner, 3);

        switch (opcao){
            case 1:
                cadastrarAluno(scanner, biblioteca);
                break;
            case 2:
                cadastrarProfessor(scanner, biblioteca);
                break;
            case 3:
                cadastrarFuncionario(scanner, biblioteca);
                break;
            case 0:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Entrada inválida.");
        }


    }

    private static void cadastrarAluno(Scanner scanner, Biblioteca biblioteca){

        System.out.print("Digite o nome: ");
        String nome = scanner.next();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.next();

        System.out.print("Digite o curso: ");
        String curso = scanner.next();

        System.out.print("Digite o período: ");
        int periodo = scanner.nextInt();

        Aluno aluno = new Aluno(nome, telefone, curso, periodo);
        biblioteca.cadastrarAluno(aluno);

    }

    private static void cadastrarProfessor(Scanner scanner, Biblioteca biblioteca){

        System.out.println("Digite o nome: ");
        String nome = scanner.next();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.next();

        System.out.print("Digite a disciplina: ");
        String disciplina = scanner.next();

        Professor profesor = new Professor(nome, disciplina, disciplina);
        biblioteca.cadastrarProfessor(profesor);
    }

    private static void cadastrarFuncionario(Scanner scanner, Biblioteca biblioteca){
        System.out.println("Cadastrando Funcionário...");
    }

}
