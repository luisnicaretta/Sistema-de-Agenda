import java.io.*;
import java.util.*;

public class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void incluirContato(Contato contato) {
        contatos.add(contato);
    }

    public void excluirContato(int id) {
        contatos.removeIf(contato -> contato.getId() == id);
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }

    public Contato consultarContato(int id) {
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                return contato;
            }
        }
        return null;
    }

    public void lerContatosDeArquivo(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> lista = (List<?>) obj;
                for (Object item : lista) {
                    if (item instanceof Contato) {
                        contatos.add((Contato) item);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void gravarContatosEmArquivo(String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(contatos);
        }
    }
}
