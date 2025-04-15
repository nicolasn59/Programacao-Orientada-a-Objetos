import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double distancia, tempo, consumo;
        distancia = scanner.nextDouble();
        tempo = scanner.nextDouble();
        consumo = scanner.nextDouble();
        System.out.printf("Velocidade Média = %.2f Km/h\n", (distancia/tempo));
        System.out.printf("Consumo de combustível: %.2f Km/l\n", (distancia/consumo));
        scanner.close();
    }
}
