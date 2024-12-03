import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    // Constantes para auxiliar no status da pessoa
    protected static final String NORMAL = "Normal";
    protected static final String PENDENTE = "Pendente";

    private String nome;
    private String telefone;
    private String status;
    private int limiteEmprestimo;
    private List<Livro> livrosEmprestados;
    private List<Emprestimo> historicoEmprestimo;
    private List<Multa> multas;

    private final int id;
    private static int idCounter = 0;

    public Pessoa(String nome, String telefone, int limiteEmprestimo) {
        this.nome = nome;
        this.telefone = telefone;
        this.limiteEmprestimo = limiteEmprestimo;
        this.livrosEmprestados = new ArrayList<Livro>();
        this.historicoEmprestimo = new ArrayList<>();
        this.status = NORMAL;
        this.id = idCounter;
        idCounter++;
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

    public void emprestaLivro(Livro livro){
        livrosEmprestados.add(livro);
        LocalDate hoje = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo(livro,this, hoje, hoje.plusDays(14));
        historicoEmprestimo.add(emprestimo);
    }

    public void devolverLivro(Livro livro) {
        if (!livrosEmprestados.contains(livro)){
            System.out.println("ERRO: Usuário " + nome + " não tem o livro " + livro.getTitulo() + " emprestado.");
            return;
        }
        livro.devolver();
        livrosEmprestados.remove(livro);
        System.out.println("Livro " + livro.getTitulo() + " devolvido com sucesso.");
    }

}
