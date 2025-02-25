package recursos;

public class Menus {
	
	private static final String MENU_PRINCIPAL = """
            1 Contatos
            2 Compromissos
            3 Sair
            """;
	
	private static final String MENU_COMPROMISSOS = """
            1 Adicionar Compromisso
            2 Localizar Compromisso por ID
            3 Listar Compromissos
            4 Alterar Compromisso
            5 Remover Compromisso
            6 Sair
            """;
	
	private static final String MENU_CONTATOS = """
            1 Adicionar Contato
            2 Localizar Contato por ID
            3 Listar Contatos
            4 Alterar Contato
            5 Remover Contato
            6 Sair
            """;
	
	public static String getMenuPrincipal() {
		return MENU_PRINCIPAL;
	}
	
	public static String getMenuCompromissos() {
		return MENU_COMPROMISSOS;
	}
	
	public static String getMenuContatos() {
		return MENU_CONTATOS;
	}

}
