import java.util.Date;

public class Geral extends Contato {
    public Geral(int id, String nome, String telefone, String email, String endereco, Date dataNascimento) {
        super(id, nome, telefone, email, endereco, dataNascimento);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
