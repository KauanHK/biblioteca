package inputs;

import biblioteca.Biblioteca;
import usuarios.Pessoa;

import java.util.Scanner;

public class PagarMulta {

    public static void pagar(Scanner scanner, Biblioteca biblioteca){

        Pessoa usuario = Common.inputUsuario(scanner, biblioteca);
        if (usuario.getSomaMultas() == 0){
            System.out.println(usuario.getNome() + " não possui nenhuma multa pendente.");
            return;
        }

        System.out.println("Total a pagar: R$" + usuario.getSomaMultas());

        double valor = Common.inputDouble(scanner);
        biblioteca.pagarMulta(usuario, valor);

    }

}
