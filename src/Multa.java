public class Multa {

    private float valor;
    private Emprestimo emprestimo;
    private String status;

    public Multa(float valor, Emprestimo emprestimo, String status) {
        this.valor = valor;
        this.emprestimo = emprestimo;
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float calcularMulta(float valor){


        return valor;
    }

    public void pagar(float valor){


    }

    public String verificarStatus(String status){


        return status;
    }
}
