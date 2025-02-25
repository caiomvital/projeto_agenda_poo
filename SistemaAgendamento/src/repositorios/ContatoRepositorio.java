package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.Contato;

public class ContatoRepositorio {

    private final List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato novoContato) {
        contatos.add(novoContato);
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }

    public Contato localizarContatoPorId(long id) {
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                return contato;
            }
        }
        return null;
    }

    public void alterarContato(Contato contato) {
        Contato contatoParaAtualizar = localizarContatoPorId(contato.getId());
        if (contatoParaAtualizar != null) {
           contatos.set(contatos.indexOf(contatoParaAtualizar), contato);
           System.out.println("Contato alterado com sucesso.");

        } else {
            System.out.println("Contato não encontrado.");

        }
    }

    public void removerContatoPorId(long id) {
        Contato contato = localizarContatoPorId(id);
        if (contato != null) {
            contatos.remove(contato);
        }
    }

    
}
