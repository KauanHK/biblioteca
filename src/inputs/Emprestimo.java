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

        if (usuario.atingiuLimiteEmprestimos()){
            System.out.println("Empréstimo negado: " + usuario.getNome() + " atingiu seu limite de empréstimos (" + usuario.getLimiteEmprestimo() + ")");
            return;
        }

        Livro livro;
        try {
            livro = inputLivro(scanner, biblioteca.getLivrosDisponiveis());
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

        while (true) {

            System.out.print("Digite o nome do usuário: ");
            String nome = scanner.nextLine();

            List<Pessoa> usuarios = biblioteca.pesquisarUsuarioPorNome(nome);
            if (usuarios.isEmpty()) {
                throw new UsuarioNaoEncontradoException(nome);
            }

            if (usuarios.size() == 1)
                return usuarios.getFirst();

            System.out.println("Existem " + usuarios.size() + " usuários com esse nome.");
            System.out.print("Digite o número de telefone: ");
            String telefone = scanner.nextLine();
            try {
                return biblioteca.pesquisarUsuarioPorTelefone(telefone);
            } catch (IndexOutOfBoundsException e){
                System.out.println("Entrada inválida.");
            }
        }
    }

    private static Livro inputLivro(Scanner scanner, List<Livro> livros){

        while (true) {
            System.out.println("\nLivros:");
            int n = 1;
            for (Livro livro : livros) {
                System.out.println(n + " - " + livro.getTitulo());
                n++;
            }
            System.out.print("\nDigite o número de um livro: ");
            n = scanner.nextInt();
            try {
                return livros.get(n - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Entrada inválida.");
            }
        }
    }

    public static void finalizarEmprestimo(Scanner scanner, Biblioteca biblioteca){

        Pessoa usuario;
        try {
            usuario = inputUsuario(scanner, biblioteca);
        } catch (UsuarioNaoEncontradoException e){
            System.out.println("Erro: usuário não encontrado.");
            return;
        }

        Livro livro = inputLivro(scanner, biblioteca.getLivrosEmprestados());
        biblioteca.finalizarEmprestimo(livro);

    }

}
