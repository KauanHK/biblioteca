import biblioteca.Acervo;
import biblioteca.Biblioteca;
import livro.Livro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(new Acervo());

        int opcao;
        do {
            inputs.Common.exibirOpcoes();
            opcao = inputs.Common.getOpcao(scanner, 7);
            inputs.Common.executar(scanner, biblioteca, opcao);
        } while (opcao != inputs.Common.getSair());

        scanner.close();

    }





}
