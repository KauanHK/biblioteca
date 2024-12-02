import java.time.LocalDate;

public class Livro {

    // Constantes para auxiliar no status do livro
    private final static String EMPRESTADO = "Emprestado";
    private final static String DISPONIVEL = "Disponível";

    private static int idCounter;

    private final int id;
    private final String titulo;
    private final String autor;
    private final int anoPublicacao;
    private String status;
    private LocalDate dataDevolucao;
    private boolean disponivel;


    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;

        this.id = idCounter;
        idCounter++;
        this.status = DISPONIVEL;
        this.dataDevolucao = null;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getStatus() {
        return status;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void emprestar() {
        this.dataDevolucao = LocalDate.now().plusDays(14);
        this.status = EMPRESTADO;
    }

    public void devolver() {
        this.dataDevolucao = null;
        this.status = "Disponível";
    }

    public void renovar(LocalDate novaData) {
        this.dataDevolucao = novaData;
    }

    public boolean isDisponivel() {
        return this.status.equals(DISPONIVEL);
    }

    public void imprimir() {
        System.out.println("======================================");

        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + anoPublicacao);
        System.out.println("Status: " + status);
        if (!isDisponivel()){
            System.out.println("Data de devolução: " + dataDevolucao);
        }

        System.out.println("======================================");
    }

}
