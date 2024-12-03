public class Aluno extends Pessoa{

    private String curso;
    private int periodo;
    
    public Aluno(String nome, String telefone, int limiteEmprestimo, String curso, int periodo) {
        super(nome, telefone, limiteEmprestimo);
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

    public void solicitarEmprestimo(Livro livro) {

        if (!livro.isDisponivel()) {
            System.out.println("Livro " + livro.getTitulo() + " estará disponível apenas a partir do dia " + livro.getDataDevolucao());
            return;
        }
        
        if (livrosEmprestados.size() >=  limiteEmprestimo) {
            System.out.println("Empréstimo não permitido:");
            System.out.println("O aluno " + nome + " já possui " + livrosEmprestados.size() + " livros emprestados (limite: " + limiteEmprestimo + ")");
            return;
        }
        
        livro.emprestar();
        emprestaLivro(livro);
        
        setLimiteEmprestimo(getLimiteEmprestimo() - 1);

        System.out.println("================================================");
        System.out.println("Empréstimo realizado para o aluno " + getNome());
        System.out.println(" - Curso: " + getCurso()) ;
        System.out.println(" - Período: " + getPeriodo());
        System.out.println(" - Livro: " + livro.getTitulo());
        System.out.println("================================================");

    }

}
