package repositorios;

import java.util.ArrayList;
import java.util.List;

import modelos.Compromisso;

public class CompromissoRepositorio {
    
    private final List<Compromisso> compromissos = new ArrayList<>();
    
    
    public void adicionarCompromisso(Compromisso novoCompromisso) {
        compromissos.add(novoCompromisso);
    }

    public void listarCompromissos() {
        for (Compromisso compromisso : compromissos) {
            System.out.println(compromisso);
        }
    }

    public Compromisso localizarCompromissoPorId(long id) {
        for (Compromisso compromisso : compromissos) {
            if (compromisso.getId() == id) {
                return compromisso;
            }
        }
        return null;
    }

    //alterar o retorno para compromisso
    //alterar também no service
    public void alterarCompromisso(Compromisso compromisso) {
        Compromisso compromissoParaAtualizar = localizarCompromissoPorId(compromisso.getId());
        if (compromissoParaAtualizar != null) {
            compromissos.set(compromissos.indexOf(compromissoParaAtualizar), compromisso);
            System.out.println("Compromisso alterado com sucesso.");
        } else {
            System.out.println("Compromisso não encontrado.");
        }
    }


    // Método para remover um compromisso por ID
    public void removerCompromissoPorId(long id) {
        Compromisso compromisso = localizarCompromissoPorId(id);
        if (compromisso != null) {
            compromissos.remove(compromisso);
        }
    }

   

}
