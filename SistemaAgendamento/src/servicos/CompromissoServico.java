package servicos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import modelos.Compromisso;
import modelos.Contato;
import repositorios.CompromissoRepositorio;
import repositorios.ContatoRepositorio;

public class CompromissoServico {
    
    private CompromissoRepositorio compromissoRepositorio;
    private ContatoRepositorio contatoRepositorio;
    private static Scanner scan = new Scanner(System.in);
    
    public CompromissoServico(CompromissoRepositorio compromissoRepositorio, ContatoRepositorio contatoRepositorio) {
        this.compromissoRepositorio = compromissoRepositorio;
        this.contatoRepositorio = contatoRepositorio;
    }
    
    public void adicionarCompromisso() {
        
    	System.out.println("Informe o nome do compromisso: ");
		String nome = scan.nextLine();
		System.out.println("Informe a descrição do compromisso: ");
		String descricao = scan.nextLine();
		System.out.println("Informe o ID do contato associado ao compromisso: ");
		int id = scan.nextInt(); scan.nextLine();
		
		Contato contato = contatoRepositorio.localizarContatoPorId(id);
        
    	if (contato == null) {
            System.out.println("Contato não encontrado.");
            return;
        }
        
    	LocalDateTime dataHora = lerDataHora();
    	
        Compromisso novoCompromisso = new Compromisso(nome, descricao, contato);
        novoCompromisso.setDataHora(dataHora);
        compromissoRepositorio.adicionarCompromisso(novoCompromisso);
        System.out.println("Compromisso adicionado com sucesso!");
    }
    
    public void listarCompromissos() {
        compromissoRepositorio.listarCompromissos();
    }
    
    public Compromisso localizarCompromissoPorId(long id) {
    	Compromisso compromisso = compromissoRepositorio.localizarCompromissoPorId(id);
    	
    	if(compromisso != null) {
    		return compromisso;	
    	} else {
    		System.out.println("Compromisso não encontrado.");
    		return null;
    	}
    	
    }
    
    public void alterarCompromisso(long id) {
        Compromisso compromissoParaAlterar = compromissoRepositorio.localizarCompromissoPorId(id);
        if (compromissoParaAlterar != null) {
            Compromisso compromissoAtualizado = alterarDados(compromissoParaAlterar);
            compromissoRepositorio.alterarCompromisso(compromissoAtualizado);
        } else {
            System.out.println("Compromisso não encontrado.");
        }
    }
    
    public void removerCompromisso(long id) {
        Compromisso compromisso = compromissoRepositorio.localizarCompromissoPorId(id);
        if (compromisso != null) {
            compromissoRepositorio.removerCompromissoPorId(id);
            System.out.println("Compromisso removido com sucesso.");
        } else {
            System.out.println("Compromisso não encontrado.");
        }
    }
    
    private Compromisso alterarDados(Compromisso compromisso) {
        System.out.println("Informe o novo nome (deixe em branco para manter o atual): ");
        String nome = scan.nextLine();
        if (nome.isEmpty()) {
            nome = compromisso.getNome();
        }

        System.out.println("Informe a nova descrição (deixe em branco para manter a atual): ");
        String descricao = scan.nextLine();
        if (descricao.isEmpty()) {
            descricao = compromisso.getDescricao();
        }

        System.out.println("Informe o ID do novo contato (deixe em branco para manter o atual): ");
        int id = scan.nextInt(); scan.nextLine();
        Contato novoContato = contatoRepositorio.localizarContatoPorId(id);
        if (novoContato == null) {
            System.out.println("Contato não encontrado. Mantido o contato original.");
            novoContato = compromisso.getContato();
        }

        compromisso.setNome(nome);
        compromisso.setDescricao(descricao);
        compromisso.setContato(novoContato);

        return compromisso;
    }
    
    private static LocalDateTime lerDataHora() {
        LocalDate date = null;
        LocalTime time = null;
        int dia, mes, ano;

        // Obtendo o dia
        while (true) {
            try {
                System.out.print("Informe o dia ou aperte ENTER para hoje: ");
                String input = scan.nextLine().trim();
                dia = input.isEmpty() ? LocalDate.now().getDayOfMonth() : Integer.parseInt(input);
                if (dia < 1 || dia > 31) {
                    System.out.println("Dia inválido! Deve estar entre 1 e 31.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número entre 1 e 31.");
            }
        }

        // Obtendo o mês
        while (true) {
            try {
                System.out.print("Informe o mês ou aperte ENTER para o mês atual: ");
                String input = scan.nextLine().trim();
                mes = input.isEmpty() ? LocalDate.now().getMonthValue() : Integer.parseInt(input);
                if (mes < 1 || mes > 12) {
                    System.out.println("Mês inválido! Deve estar entre 1 e 12.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número entre 1 e 12.");
            }
        }

        // Obtendo o ano
        while (true) {
            try {
                System.out.print("Informe o ano ou aperte ENTER para o ano atual: ");
                String input = scan.nextLine().trim();
                ano = input.isEmpty() ? LocalDate.now().getYear() : Integer.parseInt(input);
                if (ano < 1900 || ano > 2100) {
                    System.out.println("Ano inválido! Digite um valor entre 1900 e 2100.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número válido para o ano.");
            }
        }

        // Verificando a validade do dia para o mês e ano informados
        while (true) {
            try {
                date = LocalDate.of(ano, mes, dia);

                // Verifica se o dia é válido para o mês e ano informados
                if (dia > date.lengthOfMonth()) {
                    System.out.println("O mês informado tem apenas " + date.lengthOfMonth() + " dias. Tente novamente.");
                    dia = 0;  // Faz o loop pedir novamente o dia
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Data inválida! Tente novamente.");
                dia = 0;  // Faz o loop pedir novamente o dia
            }
        }

        // Obtendo a hora
        while (time == null) {
            try {
                System.out.print("Informe a hora (HH:mm): ");
                String timeInput = scan.nextLine().trim();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                time = LocalTime.parse(timeInput, timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Hora inválida! Use o formato HH:mm.");
            }
        }

        return LocalDateTime.of(date, time);
    }
    

}

