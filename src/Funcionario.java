public class Funcionario extends Pessoa{
    
    private String departamento;
    private String cargo;
    
    public Funcionario(String nome, String telefone, int id, String status, int limiteEmprestimo, String departamento,
            String cargo) {
        super(nome, telefone, id, status, limiteEmprestimo);
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}
