import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private Acervo acervo;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Funcionario> funcionarios;
    private List<Multa> multas;

    public Biblioteca(Acervo acervo){
        this.acervo = acervo;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.multas = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            System.out.println("Aluno já cadastrado.");
        } else {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso.");
        }
    }

    public void cadastrarProfessor(Professor professor) {
        if (professores.contains(professor)) {
            System.out.println("Professor já cadastrado.");
        } else {
            professores.add(professor);
            System.out.println("Professor " + professor.getNome() + " cadastrado com sucesso.");
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionarios.contains(funcionario)) {
            System.out.println("Funcionário já cadastrado.");
        } else {
            funcionarios.add(funcionario);
            System.out.println("Funcionário " + funcionario.getNome() + " cadastrado com sucesso.");
        }
    }

    public void fazerEmprestimo(Pessoa usuario, Livro livro){

        if (!livro.isDisponivel()){
            System.out.println("Livro " + livro.getTitulo() + " indisponível até " + livro.getDataDevolucao());
            return;
        }

        if (usuario.getStatus().equals(Pessoa.PENDENTE)){
            System.out.println("Empreśtimo negado: " + usuario.getNome() + " possui devolução de livro(s) pendente(s).");
            return;
        }

        LocalDate hoje = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo(livro, usuario, hoje, hoje.plusDays(14));
        livro.emprestar(emprestimo);
        usuario.emprestar(emprestimo);
        System.out.println("Livro '" + livro.getTitulo() + "' emprestado para " + usuario.getNome() + " com sucesso.");

    }

    public void devolverLivro(Pessoa usuario, Livro livro){

        if (!usuario.getLivrosEmprestados().contains(livro)){
            System.out.println(
                    "Erro: " + usuario.getNome() + " não possui o livro " +
                    livro.getTitulo() + " emprestado"
            );
            return;
        }

        double valorMulta = livro.calcularMulta();
        if (valorMulta > 0) {
            Multa multa = new Multa(valorMulta, livro.getEmprestimo());
            multas.add(multa);
            usuario.adicionarMulta(multa);
            System.out.println("Devolução atrasada. Multa: R$" + valorMulta);
        }

        usuario.devolver(livro);

        System.out.println("Livro " + livro.getTitulo() + " devolvido com sucesso.");

    }

    public String gerarRelatorioEmprestimos() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Empréstimos:\n");
        for (Livro livro : acervo.getLivros()) {
            if (!livro.isDisponivel()) {
                relatorio.append("Livro: ").append(livro.getTitulo()).append(", Data de Devolução: ")
                        .append(livro.getDataDevolucao()).append("\n");
            }
        }
        return relatorio.toString();
    }

    StringBuilder relatorio = new StringBuilder();
    public String gerarRelatorioMultas() {
        relatorio.append("Relatório de Multas:\n");
        for (Multa multa : multas) {
            relatorio.append("Usuário: ").append(multa.getEmprestimo().getUsuario().getNome()).append(", Valor: R$")
                    .append(multa.getValor()).append(", Status: ").append(multa.getStatus()).append("\n");
        }
        return relatorio.toString();
    }

    public String gerarRelatorioUsuarios() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Usuários:\n");
        for (Aluno aluno : alunos) {
            relatorio.append("Aluno: ").append(aluno.getNome()).append("\n");
        }
        for (Professor professor : professores) {
            relatorio.append("Professor: ").append(professor.getNome()).append("\n");
        }
        for (Funcionario funcionario : funcionarios) {
            relatorio.append("Funcionário: ").append(funcionario.getNome()).append("\n");
        }
        return relatorio.toString();
    }
}
