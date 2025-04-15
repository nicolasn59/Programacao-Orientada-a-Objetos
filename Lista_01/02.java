import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a temperatura em Celsius: ");
        int celsius = scanner.nextInt();
        System.out.printf("%dºC equivale a %.0fºF\n", celsius, ((celsius*1.8f)+32));
    }
}