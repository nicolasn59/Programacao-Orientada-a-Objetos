import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe a quantidade de alunos: ");
        int numAlunos = scan.nextInt();
        if (numAlunos != 0){
            double[] notas = new double[numAlunos];
            double media = 0;
            System.out.printf("Digite as notas dos %d alunos.\n", numAlunos);
            for (int i=0; i<numAlunos; i++){
                notas[i] = scan.nextDouble();
                media += notas[i];
            }
            media /= numAlunos;
            System.out.printf("Média da turma: %.2f\n", media);
            System.out.printf("Notas acima da média: \n -=- ");
            for (int i=0; i < numAlunos; i++){
                if (notas[i] > media){
                    System.out.printf("%.2f -=- ", notas[i]);
                }
            }
        }
        else{
            System.out.printf("Nenhum aluno nessa turma.\n");
        }
        scan.close();
    }
}
