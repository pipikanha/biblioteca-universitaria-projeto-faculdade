# Sistema de Gestão de Biblioteca Universitária - TP1

- **Aluno:** João Victor
- **Disciplina:** Fundamentos de Desenvolvimento com Java [26E4_1]
- **Trilha:** Java (JDK 21 LTS + IntelliJ IDEA Community Edition)

Projeto da disciplina, evoluído a cada TP até a Apresentação Final.
Este TP1 cobre a análise e a modelagem (requisitos e casos de uso em UML) e um primeiro programa standalone, ainda sem orientação a objetos.

## Estrutura do repositório

```
docs/
  TP1_JoaoVictor_26E4_1_Requisitos.pdf   requisitos (funcionais e não funcionais), casos de uso e justificativa de escopo
  diagrama-casos-de-uso.png              diagrama de casos de uso (UML)
src/
  SimuladorBiblioteca.java               programa standalone inicial (menu de console)
```

## Como executar

Pelo IntelliJ: abra o projeto, abra `src/SimuladorBiblioteca.java` e clique em Run.

Pelo terminal (JDK 21):

```bash
cd src
java SimuladorBiblioteca.java
```

## O que o programa faz

O programa simula três regras de negócio de referência da especificação, usando tipos primitivos, operadores e controle de fluxo:

1. **Limite de empréstimos:** um membro não pode ter mais de 3 empréstimos ativos simultâneos.
2. **Multa por atraso:** prazo padrão de 14 dias e multa por dia corrido de atraso (valor assumido: R$ 0,50 por dia).
3. **Reserva:** um exemplar só pode ser reservado se já estiver emprestado.

## Uso de IA

Usei a IA como apoio para organizar o projeto, esclarecer pontos subentendidos na especificação e revisar o código. As decisões finais e os testes foram feitos por mim.

## Escopo

Ficaram para as próximas entregas as classes de domínio (Livro, Exemplar, Membro, Empréstimo e Reserva), a persistência em banco de dados, a API com Spring Boot e a autenticação. As suposições feitas ao interpretar a especificação estão registradas no PDF da pasta `docs/`.
