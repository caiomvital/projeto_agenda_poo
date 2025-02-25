package controlador;

import java.util.Scanner;

import recursos.Menus;
import servicos.CompromissoServico;

public class CompromissoController {

    private final CompromissoServico compromissoServico;
    private static final Scanner scan = new Scanner(System.in);

    public CompromissoController(CompromissoServico compromissoServico) {
        this.compromissoServico = compromissoServico;
    }

    public void exibirMenuCompromissos() {
        while (true) {
            System.out.println(Menus.getMenuCompromissos());
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> compromissoServico.adicionarCompromisso();
                case 2 -> {
                    System.out.println("Informe o id");
                    int id = scan.nextInt();
                    scan.nextLine();
                    compromissoServico.localizarCompromissoPorId(id);
                }
                case 3 -> compromissoServico.listarCompromissos();
                case 4 -> {
                    System.out.println("Informe o id");
                    int id = scan.nextInt();
                    scan.nextLine();
                    compromissoServico.alterarCompromisso(id);
                }
                case 5 -> {
                    System.out.println("Informe o id");
                    int id = scan.nextInt();
                    scan.nextLine();
                    compromissoServico.removerCompromisso(id);
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

