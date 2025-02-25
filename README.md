# projeto_agenda_poo
projeto java com poo simulando spring boot

Sistema de Agendamento de Compromissos

Objetivo

Criar um sistema que permita aos usuários gerenciar seus compromissos diários, cadastrando, listando e removendo compromissos de forma organizada.

Descrição

O sistema deve permitir que cada compromisso tenha um contato associado e deve manter um identificador único para cada registro.

Requisitos

1. Cadastro de Contato

Cada contato deve ter:

Nome

Telefone

Email


2. Cadastro de Compromisso

Cada compromisso deve conter:

ID único gerado automaticamente

Nome do compromisso

Descrição

Data e hora

Contato relacionado


3. Funcionalidades do Sistema

Adicionar compromisso: 
O usuário deve fornecer os detalhes e associá-lo a um contato existente.
Localizar Compromisso por ID:
O usuário deve poder localizar um compromisso pelo ID.

Listar compromissos: 
O sistema deve exibir todos os compromissos cadastrados.

Atualizar Compromisso:
O usuário pode atualizar um compromisso informando o ID.

Excluir compromisso: 
O usuário pode remover um compromisso informando o ID.


Execução contínua: O sistema deve permanecer em funcionamento até que o usuário escolha sair.


Desafios Extras

Implementar busca de compromissos por nome ou data.

Validações e Erros: Lidar com tentativas de remoção de compromissos inexistentes e garantir que as entradas sejam feitas corretamente.

Criar uma estrutura que organize os compromissos de forma mais eficiente.
