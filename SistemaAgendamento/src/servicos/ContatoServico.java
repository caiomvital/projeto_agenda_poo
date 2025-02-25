package servicos;

import java.util.Scanner;

import modelos.Contato;
import repositorios.ContatoRepositorio;

public class ContatoServico {
    
    private ContatoRepositorio contatoRepositorio;
    private static Scanner scan = new Scanner(System.in);
    
    public ContatoServico(ContatoRepositorio contatoRepositorio) {
        this.contatoRepositorio = contatoRepositorio;
    }
    
    public void adicionarContato() {
        
    	System.out.println("Informe o nome do contato: ");
        String nome = scan.nextLine();
        System.out.println("Informe o telefone do contato: ");
        String telefone = scan.nextLine();
        System.out.println("Informe o email do contato: ");
        String email = scan.nextLine();
    	
    	
    	while (nome == null || nome.trim().isEmpty()) {
            System.out.println("Campo NOME não pode ser vazio.");
            System.out.println("Digite novamente: ");
            nome = scan.nextLine();
        }
        
        while (telefone == null || telefone.trim().isEmpty()) {
        	System.out.println("Campo TELEFONE não pode ser vazio.");
            System.out.println("Digite novamente: ");
            telefone = scan.nextLine();
        }
        
        while (email == null || email.trim().isEmpty()) {
        	System.out.println("Campo EMAIL não pode ser vazio.");
            System.out.println("Digite novamente: ");
            email = scan.nextLine();
        }
        
        Contato novoContato = new Contato(nome, telefone, email);
        contatoRepositorio.adicionarContato(novoContato);
        System.out.println("Contato adicionado com sucesso!");
    }
    
    public void listarContatos() {
        contatoRepositorio.listarContatos();
    }
    
    
    public Contato localizarContatoPorId(int id) {
    	Contato contato = contatoRepositorio.localizarContatoPorId(id);
    	
    	if(contato != null) {
    		return contato;
    	} else {
    		return null;
    	}
    }
    
/*com o uso do Optional
    public Optional<Contato> localizarContatoPorId(int id) {
    	
       Contato contato = contatoRepositorio.localizarContatoPorId(id);
       Optional<Contato> optional = Optional.ofNullable(contato);
        
       return optional;
        
   
    } */
    
    public void alterarContato(int id) {
        
        Contato contato = contatoRepositorio.localizarContatoPorId(id);
        
    	if (contato != null) {
            
    		System.out.println("Informe o novo nome do contato: ");
            String nome = scan.nextLine();
            System.out.println("Informe o novo telefone do contato: ");
            String telefone = scan.nextLine();
            System.out.println("Informe o novo email do contato: ");
            String email = scan.nextLine();
            
            if(!contato.getNome().equalsIgnoreCase(nome)) {
            	contato.setNome(nome);
            }
            
            if (!contato.getTelefone().equalsIgnoreCase(telefone)) {
            	contato.setTelefone(telefone);
            }
            
            if(!contato.getEmail().equalsIgnoreCase(email)) {
            	contato.setEmail(email);
            }
            
            contatoRepositorio.alterarContato(contato);
            System.out.println("Contato alterado com sucesso.");
            
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
 
    public void removerContato(int id) {
        
        Contato contato = contatoRepositorio.localizarContatoPorId(id);
    	
        if (contato != null) {
            contatoRepositorio.removerContatoPorId(id);
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
