public class Professor extends Funcionario{

    private String disciplina;
    
    public Professor(String nome, String telefone, int id, String status, int limiteEmprestimo, String departamento,
            String cargo, String disciplina) {
        super(nome, telefone, id, status, limiteEmprestimo, departamento, cargo);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String solicitarEmprestimo(Livro livro, String emprestimo){

            if (!livro.isDisponivel()) {
                return "Livro não disponível para empréstimo";
            }
            
            if (getLimiteEmprestimo() <= 0) {
                return "Limite de empréstimos excedido";
            }

            setLimiteEmprestimo(getLimiteEmprestimo() - 1);
            
            emprestimo = "Empréstimo realizado para o professor " + getNome() + 
                         " - Disciplina: " + getDisciplina() + 
                         " - Livro: " + livro.getTitulo();
            
            return emprestimo;
        }
}
