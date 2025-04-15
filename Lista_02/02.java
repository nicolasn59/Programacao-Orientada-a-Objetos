import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.printf("%d + %d = %d\n", a, b, (a+b));
        System.out.printf("%d - %d = %d\n", a, b, a-b);
        System.out.printf("%d x %d = %.2f\n", a, b, (double)b*a);
        if (b != 0) System.out.printf("%d / %d = %.2f\n", a, b, (double)a/b);
        else System.out.print("Não é possível dividir um número por 0\n");
        scanner.close();
    }
}