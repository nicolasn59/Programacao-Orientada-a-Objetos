import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = scanner.nextInt();
        if (num % 2 == 0) System.out.printf("O número %d é par!\n", num);
        else System.out.printf("O número %d é ímpar!\n", num);
        scanner.close();
    }
}
