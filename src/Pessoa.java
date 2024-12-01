import java.util.List;

public class Pessoa {

    private String nome;
    private String telefone;
    private int id;
    private String status;
    private int limiteEmprestimo;
    private List<Emprestimo> historicoEmprestimo;

    public Pessoa(String nome, String telefone, int id, String status, int limiteEmprestimo) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
        this.status = status;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public List<Emprestimo> getHistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    public void setHistoricoEmprestimo(List<Emprestimo> historicoEmprestimo) {
        this.historicoEmprestimo = historicoEmprestimo;
    }

    public void devolverLivro(Livro livro) {

    }

}
