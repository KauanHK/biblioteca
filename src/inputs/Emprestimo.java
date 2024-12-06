package inputs;

import java.util.List;
import java.util.Scanner;
import biblioteca.Biblioteca;
import exceptions.LivroIndisponivelException;
import exceptions.LivroNaoEncontradoException;
import exceptions.TelefoneNaoEncontradoException;
import exceptions.UsuarioNaoEncontradoException;
import livro.Livro;
import usuarios.Pessoa;

public class Emprestimo {

    public static void fazerEmprestimo(Scanner scanner, Biblioteca biblioteca){

        Pessoa usuario;
        try {
            usuario = inputUsuario(scanner, biblioteca);
        } catch (UsuarioNaoEncontradoException e){
            System.out.println("Erro: usuário não encontrado.");
            return;
        }

        Livro livro;
        try {
            livro = inputLivro(scanner, biblioteca);
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro: Livro não encontrado.");
            return;
        }

        if (!livro.isDisponivel()){
            System.out.println("Livro indisponível até " + livro.getDataDevolucao());
            return;
        }
        biblioteca.fazerEmprestimo(usuario, livro);

    }

    private static Pessoa inputUsuario(Scanner scanner, Biblioteca biblioteca){

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        List<Pessoa> usuarios = biblioteca.pesquisarUsuarioPorNome(nome);
        if (usuarios.isEmpty()){
            throw new UsuarioNaoEncontradoException(nome);
        }

        if (usuarios.size() == 1)
            return usuarios.getFirst();

        System.out.println("Existem " + usuarios.size() + " usuários com esse nome.");
        System.out.print("Digite o número de telefone: ");
        String telefone = scanner.nextLine();

        return biblioteca.pesquisarUsuarioPorTelefone(telefone);
    }

    private static Livro inputLivro(Scanner scanner, Biblioteca biblioteca){
        System.out.println("\nLivros:");
        for (Livro livro : biblioteca.getLivros()){
            if (livro.isDisponivel())
                System.out.println(livro.getTitulo());
        }
        System.out.print("\nDigite o título do livro: ");
        String titulo = scanner.nextLine();
        return biblioteca.pesquisarLivro(titulo);
    }

}
