import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        if (a == b && b == c) System.out.println("Triângulo Esquilátero\n");
        else if (a != b && a != c && b != c) System.out.println("Triângulo Isósceles\n");
        else System.out.println("Triângulo Escaleno\n");
        scanner.close();
    }
}
