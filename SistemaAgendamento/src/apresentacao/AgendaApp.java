package apresentacao;

import controlador.AgendaController;
import controlador.CompromissoController;
import controlador.ContatoController;
import repositorios.CompromissoRepositorio;
import repositorios.ContatoRepositorio;
import servicos.CompromissoServico;
import servicos.ContatoServico;



public class AgendaApp {

	public static void main(String[] args) {
		
		AgendaApp.iniciar();
		
	}
	
	
	
	public static void iniciar() {

		// instancias dos repositorios
		ContatoRepositorio contatoRepositorio = new ContatoRepositorio();
		CompromissoRepositorio compromissoRepositorio = new CompromissoRepositorio();

		// instancias dos servicos
		ContatoServico contatoServico = new ContatoServico(contatoRepositorio);
		CompromissoServico compromissoServico = new CompromissoServico(compromissoRepositorio, contatoRepositorio);

		// instancias dos controladores
		ContatoController contatoController = new ContatoController(contatoServico);
		CompromissoController compromissoController = new CompromissoController(compromissoServico);

		AgendaController agendaController = new AgendaController(contatoController, compromissoController);

		agendaController.exibirMenuPrincipal();
	}


}
