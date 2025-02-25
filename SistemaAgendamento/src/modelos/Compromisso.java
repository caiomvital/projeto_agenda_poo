package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {

	private long id;
	private static long contador = 1;
	
	private String nome;
	private String descricao;
	private LocalDateTime dataHora;
	private Contato contato;
	
	public Compromisso() {
		this.id = contador;
		contador++;
	}
	
	public Compromisso(String nome, String descricao, Contato contato) {
		this.id = contador;
		this.nome = nome;
		this.descricao = descricao;
		this.contato = contato;
		
		contador++;
	}
	
	/*
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	String dataTexto = "23/02/2024 10:15";
	LocalDateTime dataHora = LocalDateTime.parse(dataTexto, formatter);
	*/
	
	public long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public String toString() {
	    // Formatar a data e hora
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy 'às' HH:mm");
	    String dataHoraFormatada = dataHora.format(formatter);

	    // Montar a string final
	    String dados = String.format("""
	            ID do Compromisso: %d
	            Compromisso: %s
	            Descrição: %s
	            Data/Hora: %s
	            Contato Associado: 
	            -----
	            %s
	            -----
	            """, id, nome, descricao, dataHoraFormatada, contato);

	    return dados;
	}
	
	
	
}
