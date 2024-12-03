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
            System.out.println("Livro não disponível para empréstimo");
        }
        
        if (getLimiteEmprestimo() <= 0) {
            System.out.println("Limite de empréstimos excedido");
        }
        
        livro.setDisponivel(false);
        emprestaLivro(livro);
        
        setLimiteEmprestimo(getLimiteEmprestimo() - 1);
        
        System.out.println("Empréstimo realizado para o aluno " + getNome() +
                     " - Curso: " + getCurso() + 
                     " - Período: " + getPeriodo() + 
                     " - Livro: " + livro.getTitulo());

    }

}
