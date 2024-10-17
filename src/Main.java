import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Incluir contato");
            System.out.println("2. Excluir contato");
            System.out.println("3. Listar contatos");
            System.out.println("4. Consultar contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    incluirContato(agenda, scanner);
                    break;
                case 2:
                    excluirContato(agenda, scanner);
                    break;
                case 3:
                    agenda.listarContatos();
                    break;
                case 4:
                    consultarContato(agenda, scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void incluirContato(Agenda agenda, Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = null;
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoStr);
        } catch (ParseException e) {
            System.out.println("Data de nascimento inválida.");
            return;
        }

        System.out.print("Tipo de Contato (0 - Geral, 1 - Cliente, 2 - Fornecedor): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  

        switch (tipo) {
            case 0:
                agenda.incluirContato(new Geral(id, nome, telefone, email, endereco, dataNascimento));
                break;
            case 1:
                System.out.print("Fidelidade: ");
                String fidelidade = scanner.nextLine();
                System.out.print("Data da Última Compra (dd/MM/yyyy): ");
                String dataUltimaCompraStr = scanner.nextLine();
                Date dataUltimaCompra = null;
                try {
                    dataUltimaCompra = new SimpleDateFormat("dd/MM/yyyy").parse(dataUltimaCompraStr);
                } catch (ParseException e) {
                    System.out.println("Data da última compra inválida.");
                    return;
                }
                agenda.incluirContato(new Cliente(id, nome, telefone, email, endereco, dataNascimento, fidelidade, dataUltimaCompra));
                break;
            case 2:
                System.out.print("Índice de Qualidade: ");
                int indiceQualidade = scanner.nextInt();
                scanner.nextLine(); 
                agenda.incluirContato(new Fornecedor(id, nome, telefone, email, endereco, dataNascimento, indiceQualidade));
                break;
            default:
                System.out.println("Tipo de contato inválido.");
        }
    }

    private static void excluirContato(Agenda agenda, Scanner scanner) {
        System.out.print("ID do contato a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        agenda.excluirContato(id);
    }

    private static void consultarContato(Agenda agenda, Scanner scanner) {
        System.out.print("ID do contato a ser consultado: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        Contato contato = agenda.consultarContato(id);
        if (contato != null) {
            System.out.println(contato);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
