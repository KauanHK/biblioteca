import java.util.ArrayList;
import java.util.List;

public class Acervo {

    private final List<Livro> livros;

    public Acervo(List<Livro> livros){
        this.livros = livros;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    
    public void removerLivro(Livro livro){
        boolean removido = livros.remove(livro);
        if (removido){
            System.out.println("Livro " + livro.getTitulo() + "removido com sucesso");
        } else {
            System.out.println("Erro: O acervo não contém o livro " + livro.getTitulo());
        }
    }
    
    public List<Livro> pesquisarLivros(String pesquisa){
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.getTitulo().equals(pesquisa) || livro.getAutor().equals(pesquisa)){
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
    
    public boolean contemLivro(String pesquisa) {
        for (Livro livro : livros){
            if (livro.getTitulo().equals(pesquisa) || livro.getAutor().equals(pesquisa)){
                return true;
            }
        }
        return false;
    }


    
    public List<Livro> getLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.isDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

}
