import java.util.List;

public class Biblioteca {

    private Acervo acervo;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Funcionario> funcionarios;

    public Acervo getAcervo() {
        return acervo;
    }

    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String gerarRelatorioEmprestimos(String relatorio, boolean status) {

        return relatorio;
    }

    public String gerarRelatorioMultas(String relatorio, float multa) {

        return relatorio;
    }

    public String gerarRelatorioUsuarios(String relatorio, String usuarios) {

        return relatorio;

    }

    public void cadastrarAluno(Aluno aluno) {

    }

    public void cadastrarProfessor(Professor professor) {

    }

    public void cadastrarFuncionario(Funcionario funcionario) {

    }

}
