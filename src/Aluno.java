public class Aluno extends Pessoa{

    private String curso;
    private int periodo;
    
    public Aluno(String nome, String telefone, int id, String status, int limiteEmprestimo, String curso, int periodo) {
        super(nome, telefone, id, status, limiteEmprestimo);
        this.curso = curso;
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getPeriodo() {
        return periodo;
    }
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String solicitarEmprestimo(Livro livro, String emprestimo){

        return emprestimo;
    }

}
