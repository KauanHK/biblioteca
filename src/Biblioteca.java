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
        this.alunos = new ArrayList<Aluno>();
        this.professores = new ArrayList<Professor>();
        this.funcionarios = new ArrayList<Funcionario>();
        this.multas = new ArrayList<Multa>();
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
