import java.util.Date;

public class Fornecedor extends Contato {
    private int indiceQualidade;

    public Fornecedor(int id, String nome, String telefone, String email, String endereco, Date dataNascimento, int indiceQualidade) {
        super(id, nome, telefone, email, endereco, dataNascimento);
        this.indiceQualidade = indiceQualidade;
    }

    // Getters e Setters
    public int getIndiceQualidade() { return indiceQualidade; }

    @Override
    public String toString() {
        return super.toString() + ", Índice de Qualidade: " + indiceQualidade;
    }
}
