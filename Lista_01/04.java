import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int dinheiro = scanner.nextInt();
        int moeda100, moeda50, moeda25, moeda20, moeda10, moeda5, moeda1;

        moeda100 = dinheiro / 100;
        dinheiro %= 100;

        moeda50 = dinheiro / 50;
        dinheiro %= 50;

        moeda25 = dinheiro / 25;
        dinheiro %= 25;

        moeda20 = dinheiro / 20;
        dinheiro %= 20;

        moeda10 = dinheiro / 10;
        dinheiro %= 10;

        moeda5 = dinheiro / 5;
        dinheiro %= 5;

        moeda1 = dinheiro;

        System.out.printf("Moedas de 1 real: %d\n" +
                "Moedas de 50 centavos: %d\n" +
                "Moedas de 25 centavos: %d\n" +
                "Moedas de 20 centavos: %d\n" +
                "Moedas de 10 centavos: %d\n" +
                "Moedas de 5 centavos: %d\n" +
                "Moedas de 1 centavo: %d\n", moeda100, moeda50, moeda25, moeda20, moeda10, moeda5, moeda1);
        scanner.close();
    }
}
