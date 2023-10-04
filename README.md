# LibraDesk-PIES
Sistema de gerenciamento de empréstimo de livros para a biblioteca pública de Quixadá

## Prototipação

https://www.figma.com/file/RDGRSCh5gtYOECqFjsRTgT/LibraDesk?type=design&node-id=0%3A1&mode=design&t=7zkUA7FT11PAErhU-1

## Escopo do LibraDesk

O projeto LibraDesk incluirá:
    Desenvolvimento de um sistema de gerenciamento de empréstimos e devoluções de livros.
    Implementação de um banco de dados centralizado para rastreamento de livros, empréstimos e devoluções.
    Implementação de cálculo de multas com base em datas de devolução.
    Interface de usuário intuitiva para bibliotecárias realizarem empréstimos e devoluções de forma simples.

O projeto LibraDesk não incluirá:
    Pagamento de multas por atraso.
    Sistema de reserva de livros pelos leitores.
    Interface de usuário direta para os leitores.
    Integração com sistemas externos não relacionados ao gerenciamento de empréstimos e devoluções.

## Requisitos Funcionais:

    RF001 - Manter leitor: o sistema deve permitir o cadastro de informações pessoais dos leitores, incluindo nome, email, endereço, número de telefone e identificação única (como número de matrícula ou CPF), além da edição, exclusão e busca dos mesmos.
    RF002 - Manter livro: o sistema deve possibilitar o cadastro de informações sobre os livros, como título, autor, ISBN, editora, ano de publicação, local que se encontra dentro da biblioteca e número de exemplares disponíveis, além da edição, exclusão e busca dos mesmo.
    RF003 - Realizar empréstimo: o sistema deve ter a capacidade de registrar empréstimos, associando o usuário ao livro emprestado.
    RF004 - Estipular datas: o sistema deve ser capaz de registrar a data de empréstimo e definir a data de devolução do livro. 
    RF005 - Registrar devolução: o sistema deve permitir o registro da devolução de livros na data correta.
    RF006 - Calcular multa: o sistema deve calcular automaticamente as multas por devoluções atrasadas, se aplicável.
    RF007 -  Realizar login: o sistema deve possibilitar aos bibliotecários realizarem login no sistema.
    RF008 - Manter bibliotecário: o sistema deve ser capaz de adicionar, alterar, excluir e buscar bibliotecários.


## Requisitos Não Funcionais:

    RNF001 - Segurança: Implementar autenticação robusta para acessar o sistema de administração.
    RNF002 - Privacidade: o sistema deve proteger os dados pessoais e informações sensíveis dos usuários.
    RNF003 - Confiabilidade: o sistema deve minimizar a possibilidade de falhas e ter mecanismos de backup e recuperação de dados em caso de falhas.
    RNF004 - Manutenibilidade: o sistema deve ser de fácil manutenção e atualização.
    RNF005 - Usabilidade: a interface do usuário deve ser intuitiva e de fácil utilização minimizando a curva de aprendizado.


## Regras de Negócio:

    RN001 - Validação: Os campos obrigatórios, como nome e identificação única, devem ser validados antes de permitir o cadastro.
    RN002 - Confirmação de cadastro: Após o cadastro, os usuários devem receber uma confirmação de registro.
    RN003 - Cadastro de livros: Os campos de informações sobre os livros devem ser devidamente preenchidos para concluir o cadastro.
    RN004 - Prevenção de erros: O sistema deve impedir o cadastro de livros com informações faltantes ou inválidas.
    RN005 - Disponibilidade: Após o cadastro, os livros devem ser disponibilizados para empréstimo.
    RN006 - Automação: A data de empréstimo deve ser registrada automaticamente no sistema.
    RN007 - Confirmação de empréstimo: O usuário deve receber uma confirmação do empréstimo realizado.
    RN008 - Registro de datas: A data de devolução deve ser registrada e comparada à data esperada para cálculo de multas.
    RN009 - Calcular multa: Caso a devolução seja feita após a data esperada, o sistema deve calcular a multa corretamente.

