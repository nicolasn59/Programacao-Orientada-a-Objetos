import java.util.Scanner;

public class Main{
    public static double calculadora(double Opcao){
        Scanner scan = new Scanner(System.in);
        double valor;
        System.out.printf("Digite um valor: ");
        valor = scan.nextDouble();
	scan.close();
        if ((Opcao == 4) && (valor == 0)){
            System.out.printf("Operação indeterminada!\n");
            return 1.0;
        }
        else{
            return valor;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao=0;
        double memoria=0;
        while (opcao != 6){
            System.out.printf("Estado da memória: %.2f\n", memoria);
            System.out.printf("Opções: \n" +
                              "(1) Somar\n" +
                              "(2) Subtrair\n" +
                              "(3) Multiplicar\n" +
                              "(4) Dividir\n" +
                              "(5) Limpar memória\n" +
                              "(6) Sair do programa\n" +
                              "Qual opção você deseja?\n");

            opcao = scan.nextInt();

            if (opcao == 1){
                memoria += calculadora(opcao);
            }
            else if (opcao == 2){
                memoria -= calculadora(opcao);
            }
            else if (opcao == 3){
                memoria *= calculadora(opcao);
            }
            else if (opcao == 4){
                memoria /= calculadora(opcao);
            }
            else if (opcao == 5){
                memoria = 0;
            }
            else if (opcao != 6){
                System.out.printf("Opção inválida!\n");
            }
            System.out.printf("\n");
        }
        System.out.printf("Fim do programa!\n");
        scan.close();
    }
}
