import java.util.Scanner;

public class Main{
    public static void notas(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Informe a nota da prova 1: ");
        double nota1 = scan.nextDouble();
        System.out.printf("Informe a nota da prova 2: ");
        double nota2 = scan.nextDouble();
        System.out.printf("Informe a nota do trabalho 1: ");
        double nota3 = scan.nextDouble();
        System.out.printf("Informe a nota do trabalho 2: ");
        double nota4 = scan.nextDouble();
	scan.close();
        media(nota1, nota2, nota3, nota4);
    }
    public static void media(double Nota1, double Nota2, double Nota3, double Nota4){
        double Media = (Nota1 + Nota2 + Nota3 + Nota4) / 3;
        System.out.printf("Sua nota final é %.2f\n", Media);
        situacao(Media);
    }

    public static void situacao(double Media){
        if (Media >= 6.0){
            System.out.printf("Aprovado!\n");
        }
        else if (Media < 4.0){
            System.out.printf("Reprovado!\n");
        }
        else{
            System.out.printf("Verificação Suplementar!\n");
        }
    }

    public static void main(String[] args){
        // Só isso
        notas();
    }
}
