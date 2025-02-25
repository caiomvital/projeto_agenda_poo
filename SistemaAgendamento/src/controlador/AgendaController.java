package controlador;

import java.util.Scanner;

import recursos.Menus;

public class AgendaController {

    //private final ContatoServico contatoServico;
   // private final CompromissoServico compromissoServico;
    
    private final ContatoController contatoController;
    private final CompromissoController compromissoController;
    
    private final Scanner scan = new Scanner(System.in);  // Inicializando o Scanner aqui

    // Construtor com injeção de dependência para repositórios e serviços
    public AgendaController(ContatoController contatoController, 
    		CompromissoController compromissoController) {
        this.contatoController = contatoController;
        this.compromissoController = compromissoController;
    }

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println(Menus.getMenuPrincipal());
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> contatoController.exibirMenuContatos();
                case 2 -> compromissoController.exibirMenuCompromissos();
                case 3 -> {
                    System.out.println("Saindo...");
                    return;  // Finaliza a execução do método e sai do loop
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public void iniciarAgenda() {
        exibirMenuPrincipal();
    }

    

    

	

}
