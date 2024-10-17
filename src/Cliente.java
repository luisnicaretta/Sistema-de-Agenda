import java.util.Date;

public class Cliente extends Contato {
    private String fidelidade;
    private Date dataUltimaCompra;

    public Cliente(int id, String nome, String telefone, String email, String endereco, Date dataNascimento, String fidelidade, Date dataUltimaCompra) {
        super(id, nome, telefone, email, endereco, dataNascimento);
        this.fidelidade = fidelidade;
        this.dataUltimaCompra = dataUltimaCompra;
    }

    // Getters e Setters
    public String getFidelidade() { return fidelidade; }
    public Date getDataUltimaCompra() { return dataUltimaCompra; }

    @Override
    public String toString() {
        return super.toString() + ", Fidelidade: " + fidelidade + ", Data da Última Compra: " + dataUltimaCompra;
    }
}
