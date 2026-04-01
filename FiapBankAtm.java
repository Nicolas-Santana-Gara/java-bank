import java.util.Scanner;

public class FiapBankAtm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome completo: ");
        String nome = sc.nextLine().trim();

        String primeiroNome = nome.split(" ")[0];
        System.out.println("Bem-vindo, " + primeiroNome + "!");

        String senha;

        while (true) {
            System.out.print("Cadastre uma senha forte: ");
            senha = sc.nextLine();

            if (validarSenha(senha)) {
                break;
            } else {
                System.out.println("Senha inválida! Deve conter:");
                System.out.println("- Mínimo 8 caracteres");
                System.out.println("- 1 número");
                System.out.println("- 1 letra maiúscula");
                System.out.println("- 1 caractere especial");
            }
        }

        int tentativas = 0;
        boolean acessoLiberado = false;

        while (tentativas < 3) {
            System.out.print("Digite sua senha para acessar: ");
            String tentativa = sc.nextLine();

            if (tentativa.equals(senha)) {
                acessoLiberado = true;
                break;
            } else {
                tentativas++;
                System.out.println("Senha incorreta!");
            }
        }

        if (!acessoLiberado) {
            System.out.println("ACESSO BLOQUEADO");
            return;
        }

        double saldo = 0.0;
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("[1] Consultar Saldo");
            System.out.println("[2] Fazer Depósito");
            System.out.println("[3] Fazer Saque");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f\n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = sc.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("Valor inválido!");
                    } else {
                        saldo += deposito;
                        System.out.println("Depósito realizado!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double saque = sc.nextDouble();

                    if (saque <= 0) {
                        System.out.println("Valor inválido!");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        saldo -= saque;
                        System.out.println("Saque realizado!");
                    }
                    break;

                case 4:
                    System.out.println("O FIAP Bank agradece sua preferência!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        sc.close();
    }

    public static boolean validarSenha(String senha) {
        return senha.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=<>?]).{8,}$");
    }
}
