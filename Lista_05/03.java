import java.util.Scanner;

public class Main {
    public static void inputs(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o tempo em segundos: ");
        int segundos = scan.nextInt();
        scan.close();
        horario(segundos);
    }

    public static void horario(int Segundos){
        // Irá converter segungos para horas:minutos:segundos
        System.out.printf("Horário: %02d hora(s), %02d minuto(s) e %02d segundo(s)\n", (Segundos/3600), ((Segundos/60)%60), ((Segundos%60)));
        System.out.printf("%02d:%02d:%02d\n", (Segundos/3600), ((Segundos/60)%60), (Segundos%60));
    }

    public static void main(String[] args){
        inputs();  // Chama o metodo inputs(), onde irá receber um entrada do usuário
    }
}
