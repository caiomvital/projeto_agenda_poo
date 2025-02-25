package modelos;

public class Contato {


	
	private long id; // pertencente ao objeto
	private static long contador = 1; // pertence à classe
	private String nome;
	private String telefone;
	private String email;
	
	public Contato() {
		this.id = contador;
		contador++;
	}
	
	public Contato(String nome, String telefone, String email) {
		this.id = contador;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		
		contador++;
		}
	
	public long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
	
		String dados = String.format("""
				ID do contato: %d
				Nome: %s
				Telefone: %s
				Email: %s
				""", id, nome, telefone, email);
		
		return dados;
	
	}	
	
}
