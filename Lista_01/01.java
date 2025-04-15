import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String name = scanner.nextLine();
        System.out.printf("Olá, %s! Bem-vindo ao Java!\n", name);
        scanner.close();
    }
}