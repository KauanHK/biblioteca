import java.util.Scanner;

public class Main {

    private static final int CADASTRAR = 1;
    private static final int FAZER_EMPRESTIMO = 2;
    private static final int FINALIZAR_EMPRESTIMO = 3;
    private static final int PAGAR_MULTA = 4;
    private static final int GERAR_RELATORIO = 5;
    private static final int SAIR = 6;
    private static final int ADICIONAR_DADOS = 7;

    private static boolean dadosAdicionados = false;

    public static void main(String[] args) {

        int opcao;
        Scanner scanner = new Scanner(System.in);

        Acervo acervo = new Acervo();
        acervo.adicionarLivro(new Livro("Diário de um banana 1", "Robert Einstein", 2012));
        Biblioteca biblioteca = new Biblioteca(acervo);

        do {
            exibirOpcoes();
            opcao = getOpcao(scanner, 7);
            executar(scanner, biblioteca, opcao);
        } while (opcao != SAIR);

    }

    private static void exibirOpcoes(){
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

    private static int getOpcao(Scanner scanner, int numOpcoes){

        while (true){
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                if (opcao >= 0 && opcao <= numOpcoes) {
                    return opcao;
                }
            }
            System.out.println("Opção inválida.");
        }

    }

    private static void executar(Scanner scanner, Biblioteca biblioteca, int opcao){

        System.out.println();
        switch (opcao){

            case ADICIONAR_DADOS:
                dadosAdicionados = true;
                adicionarDadosFicticios(biblioteca);
                break;

            case CADASTRAR:
                cadastrar(scanner, biblioteca);
                break;

            case GERAR_RELATORIO:
                gerarRelatorio(scanner, biblioteca);
                break;

            case SAIR:
                System.out.println("Finalizando programa...");
                break;

            default:
                System.out.println("Entrada inválida");

        }
        System.out.println();

    }

    private static void cadastrar(Scanner scanner, Biblioteca biblioteca){

        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Professor");
        System.out.println("3 - Cadastrar Funcionário");
        System.out.println("4 - Voltar");
        int opcao = getOpcao(scanner, 4);

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

            case 4:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Entrada inválida.");

        }

    }

    private static String inputNome(Scanner scanner){
        System.out.print("Digite o nome: ");
        return scanner.nextLine();
    }

    private static String inputTelefone(Scanner scanner){
        System.out.print("Digite o telefone: ");
        return scanner.nextLine();
    }

    private static void cadastrarAluno(Scanner scanner, Biblioteca biblioteca){

        String nome = inputNome(scanner);
        String telefone = inputTelefone(scanner);

        System.out.print("Digite o curso: ");
        String curso = scanner.next();

        System.out.print("Digite o período: ");
        int periodo = scanner.nextInt();
        System.out.println();

        Aluno aluno = new Aluno(nome, telefone, curso, periodo);
        biblioteca.cadastrarUsuario(aluno);

    }

    private static void cadastrarProfessor(Scanner scanner, Biblioteca biblioteca){

        String nome = inputNome(scanner);
        String telefone = inputTelefone(scanner);

        System.out.print("Digite a disciplina: ");
        String disciplina = scanner.next();
        System.out.println();

        Professor profesor = new Professor(nome, telefone, disciplina);
        biblioteca.cadastrarUsuario(profesor);
    }

    private static void cadastrarFuncionario(Scanner scanner, Biblioteca biblioteca){

        String nome = inputNome(scanner);
        String telefone = inputTelefone(scanner);

        System.out.print("Digite a departamento: ");
        String departamento = scanner.nextLine();

        System.out.print("Digite a cargo: ");
        String cargo = scanner.nextLine();
        System.out.println();

        Funcionario funcionario = new Funcionario(nome, telefone, departamento, cargo);
        biblioteca.cadastrarUsuario(funcionario);

    }

    private static void gerarRelatorio(Scanner scanner, Biblioteca biblioteca){

        System.out.println("1 - Relatório de Empréstimos");
        System.out.println("2 - Relatório de Multas");
        System.out.println("3 - Relatório de Usuários");
        System.out.println("4 - Voltar");

        int opcao = getOpcao(scanner, 4);
        System.out.println();

        switch (opcao){
            case 1:
                biblioteca.gerarRelatorioEmprestimos();
                break;
            case 2:
                biblioteca.gerarRelatorioMultas();
                break;
            case 3:
                biblioteca.gerarRelatorioUsuarios();
                break;
            case 4:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Erro.");
        }
        System.out.println();

    }

    private static void adicionarDadosFicticios(Biblioteca biblioteca){

        biblioteca.cadastrarUsuario(
                new Aluno("Antonio", "111111111", "Engenharia de Software", 1)
        );
        biblioteca.cadastrarUsuario(
                new Aluno("Bruna", "222222222", "Engenharia Mecânica", 2)
        );

        biblioteca.cadastrarUsuario(
                new Professor("Carlos", "333333333", "Medicina")
        );
        biblioteca.cadastrarUsuario(
                new Professor("Daniela", "444444444", "Biomedicina")
        );

        biblioteca.cadastrarUsuario(
                new Funcionario("Eric", "555555555", "Recursos Humanos", "Analista de Pessoal")
        );
        biblioteca.cadastrarUsuario(
                new Funcionario("Ana", "777777777", "Financeiro", "Contador")
        );


    }

}
