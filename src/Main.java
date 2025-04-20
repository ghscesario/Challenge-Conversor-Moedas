import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversorMoedas conversorMoedas = new ConversorMoedas();
        boolean sair = false;
        while (!sair){
            System.out.println("**************************************************************");
            System.out.println("Seja bem vindo(a) ao Conversor de Moedas");
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileiro");
            System.out.println("4) Real Brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Argentino =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("**************************************************************");

            int resposta = sc.nextInt();

            if (resposta == 7) {
                System.out.println("Programa encerrado.");
                break;
            }

            System.out.println("Digite o valor que deseja converter:");
            double valor = sc.nextDouble();

            switch (resposta) {
                case 1 -> conversorMoedas.convertCurrency("USD", "ARS", valor);
                case 2 -> conversorMoedas.convertCurrency("ARS", "USD", valor);
                case 3 -> conversorMoedas.convertCurrency("USD", "BRL", valor);
                case 4 -> conversorMoedas.convertCurrency("BRL", "USD", valor);
                case 5 -> conversorMoedas.convertCurrency("USD", "COP", valor);
                case 6 -> conversorMoedas.convertCurrency("COP", "USD", valor);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            sair = true;
        }
        sc.close();
    }
}