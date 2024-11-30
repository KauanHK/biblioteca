import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Livro> livros = new ArrayList<>();

        Livro livro = new Livro(
                "Diário de um Banana 1",
                "Robert Einstein",
                2012
        );
        livros.add(livro);

        livro = new Livro(
                "Diário de um Banana 2",
                "Robert Einstein",
                2014
        );
        livros.add(livro);

        livro = new Livro(
                "Diário de um Banana 3",
                "Robert Einstein",
                2014
        );
        livro.emprestar();
        livros.add(livro);

        livro = new Livro(
                "Diário de um Banana 4",
                "Robert Einstein",
                2015
        );
        livros.add(livro);

        Acervo acervo = new Acervo(livros);

        for (Livro l : acervo.getLivros()){
            l.imprimir();
        }

    }
}