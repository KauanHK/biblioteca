import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Pessoa usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String status;
    
    public Emprestimo(Livro livro, Pessoa usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao, String status) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Pessoa getUsuario() {
        return usuario;
    }
    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String finalizarEmprestimo(String status, String emprestimo){


        
        return emprestimo;
    }

}
