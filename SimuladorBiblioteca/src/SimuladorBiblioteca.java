import java.util.Scanner;

public class SimuladorBiblioteca {

    static int PRAZO_PADRAO_DIAS = 14;
    static int LIMITE_EMPRESTIMOS = 3;
    static double MULTA_POR_DIA = 0.50;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("=== Biblioteca Universitaria - Simulador de Regras ===");
            System.out.println("1 - Verificar se o membro pode pegar novo emprestimo");
            System.out.println("2 - Calcular multa por atraso");
            System.out.println("3 - Verificar se um exemplar pode ser reservado");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = lerInteiro(entrada);

            switch (opcao) {
                case 1 -> verificarLimite(entrada);
                case 2 -> calcularMulta(entrada);
                case 3 -> verificarReserva(entrada);
                case 0 -> System.out.println("Encerrando o simulador.");
                default -> System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        entrada.close();
    }

    // Lê um inteiro; se o usuário digitar outra coisa, devolve -1 em vez de quebrar o programa
    static int lerInteiro(Scanner entrada) {
        if (entrada.hasNextInt()) {
            return entrada.nextInt();
        }
        entrada.next();
        return -1;
    }

    // um membro não pode ter mais de 3 empréstimos ativos simultâneos
    static void verificarLimite(Scanner entrada) {
        System.out.print("Quantos emprestimos ativos o membro possui? ");
        int ativos = lerInteiro(entrada);

        if (ativos < 0) {
            System.out.println("Quantidade invalida.");
        } else if (ativos >= LIMITE_EMPRESTIMOS) {
            System.out.println("Emprestimo NEGADO: limite de " + LIMITE_EMPRESTIMOS + " emprestimos ativos atingido.");
        } else {
            int restantes = LIMITE_EMPRESTIMOS - ativos;
            System.out.println("Emprestimo permitido. Ainda pode pegar " + restantes + " livro(s).");
        }
    }

    // prazo padrão de 14 dias; multa por dia corrido de atraso
    static void calcularMulta(Scanner entrada) {
        System.out.print("Ha quantos dias o livro foi retirado? ");
        int diasDesdeRetirada = lerInteiro(entrada);

        if (diasDesdeRetirada < 0) {
            System.out.println("Quantidade de dias invalida.");
            return;
        }

        int diasAtraso = diasDesdeRetirada - PRAZO_PADRAO_DIAS;

        if (diasAtraso <= 0) {
            int diasRestantes = PRAZO_PADRAO_DIAS - diasDesdeRetirada;
            System.out.println("Dentro do prazo. Faltam " + diasRestantes + " dia(s). Sem multa.");
        } else {
            double multa = diasAtraso * MULTA_POR_DIA;
            System.out.printf("Atrasado em %d dia(s). Multa: R$ %.2f%n", diasAtraso, multa);
        }
    }

    //  um exemplar só pode ser reservado se já estiver emprestado
    static void verificarReserva(Scanner entrada) {
        System.out.print("O exemplar esta emprestado no momento? (s/n): ");
        char resposta = Character.toLowerCase(entrada.next().charAt(0));

        if (resposta == 's') {
            System.out.println("Reserva permitida: o exemplar esta emprestado.");
        } else if (resposta == 'n') {
            System.out.println("Reserva NEGADA: o exemplar esta disponivel, faca o emprestimo direto.");
        } else {
            System.out.println("Resposta invalida. Use 's' ou 'n'.");
        }
    }
}