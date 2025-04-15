import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t;
        t = scanner.nextInt(); // Tempo em segundos
        System.out.printf("horas:minutos:segundos = %d:%d:%d\n", (t/3600), ((t / 60) % 60), (t%60));
        scanner.close();
    }
}
