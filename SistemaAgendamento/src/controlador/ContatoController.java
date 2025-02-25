package controlador;

import java.util.Scanner;

import recursos.Menus;
import servicos.ContatoServico;

public class ContatoController {

    private final ContatoServico contatoServico;
    private static final Scanner scan = new Scanner(System.in);

    public ContatoController(ContatoServico contatoServico) {
        this.contatoServico = contatoServico;
    }

    public void exibirMenuContatos() {
        while (true) {
            System.out.println(Menus.getMenuContatos());
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> contatoServico.adicionarContato();
                case 2 -> {
                    System.out.println("Informe o id");
                    int id = scan.nextInt();
                    scan.nextLine();
                    
                    System.out.println(contatoServico.localizarContatoPorId(id)); 
                }
                case 3 -> contatoServico.listarContatos();
                case 4 -> {
                    System.out.println("Informe o id");
                    int id = scan.nextInt();
                    scan.nextLine();
                    contatoServico.alterarContato(id);
                }
                case 5 -> {
                    System.out.println("Informe o id");
                    int id = scan.nextInt();
                    scan.nextLine();
                    contatoServico.removerContato(id);
                }
                case 6 -> {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
