import java.io.Serializable;
import java.util.Date;

public abstract class Contato implements Serializable {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Date dataNascimento;

    public Contato(int id, String nome, String telefone, String email, String endereco, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getEndereco() { return endereco; }
    public Date getDataNascimento() { return dataNascimento; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email + ", Endereço: " + endereco + ", Data de Nascimento: " + dataNascimento;
    }
}
