import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final Acervo acervo;
    public final List<Pessoa> usuarios = new ArrayList<>();
    private List<Multa> multas;

    public Biblioteca(Acervo acervo){
        this.acervo = acervo;
        this.multas = new ArrayList<>();
    }

    public void cadastrarUsuario(Pessoa usuario){
        if (usuarios.contains(usuario)){
            System.out.println("Usuário já cadastrado.");
            return;
        } else {
            for (Pessoa user : usuarios){
                if (user.getTelefone().equals(usuario.getTelefone())){
                    System.out.println("Cadastro negado: Já existe um usuário com esse número de telefone.");
                    return;
                }
            }
        }
        usuarios.add(usuario);
        if (usuario instanceof Aluno){
            System.out.print("Aluno: ");
        } else if (usuario instanceof Professor){
            System.out.print("Professor: ");
        } else
            System.out.print("Funcionário: ");
        System.out.println(usuario.getNome() + " cadastrado com sucesso.");

    }

    public void fazerEmprestimo(Pessoa usuario, Livro livro){

        if (!livro.isDisponivel()){
            System.out.println("Livro " + livro.getTitulo() + " indisponível até " + livro.getDataDevolucao());
            return;
        }

        if (usuario.isPendente()){
            System.out.println("Empreśtimo negado: " + usuario.getNome() + " possui devolução de livro(s) ou multa(s) pendente(s).");
            return;
        }

        LocalDate hoje = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo(livro, usuario, hoje, hoje.plusDays(14));
        livro.emprestar(emprestimo);
        usuario.emprestar(emprestimo);
        System.out.println("Livro '" + livro.getTitulo() + "' emprestado para " + usuario.getNome() + " com sucesso.");

    }

    public void finalizarEmprestimo(Livro livro){

        Pessoa usuario = livro.getEmprestimo().getUsuario();
        double valorMulta = livro.calcularMulta();
        if (valorMulta > 0) {
            Multa multa = new Multa(valorMulta, livro.getEmprestimo());
            multas.add(multa);
            usuario.adicionarMulta(multa);
            System.out.println("Devolução atrasada. Multa: R$" + valorMulta);
        }

        usuario.devolver(livro);

        System.out.println("Livro " + livro.getTitulo() + " devolvido com sucesso.");

    }

    public void pagarMulta(Pessoa usuario, double valor){

        if (!usuario.isPendente()){
            System.out.println(usuario.getNome() + " não possui multas a pagar.");
            return;
        }

        System.out.println(usuario.getNome() + " possui R$" + usuario.getSomaMultas() + " em multa(s) para pagar.");
        usuario.pagarMulta(valor);

    }

    public String gerarRelatorioEmprestimos() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Empréstimos:\n");
        for (Livro livro : acervo.getLivros()) {
            if (!livro.isDisponivel()) {
                relatorio.append("Livro: ").append(livro.getTitulo()).append(", Data de Devolução: ")
                        .append(livro.getDataDevolucao()).append("\n");
            }
        }
        return relatorio.toString();
    }

    public String gerarRelatorioMultas() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Multas:\n");
        for (Multa multa : multas) {
            relatorio.append("Usuário: ").append(multa.getEmprestimo().getUsuario().getNome()).append(", Valor: R$")
                    .append(multa.getValor()).append(", Status: ").append(multa.getStatus()).append("\n");
        }
        return relatorio.toString();
    }

    public String gerarRelatorioUsuarios() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Usuários:\n");
        for (Aluno aluno : alunos) {
            relatorio.append("Aluno: ").append(aluno.getNome()).append("\n");
        }
        for (Professor professor : professores) {
            relatorio.append("Professor: ").append(professor.getNome()).append("\n");
        }
        for (Funcionario funcionario : funcionarios) {
            relatorio.append("Funcionário: ").append(funcionario.getNome()).append("\n");
        }
        return relatorio.toString();
    }
}
