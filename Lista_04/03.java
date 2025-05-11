import java.util.Scanner;

public class Main{
    public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       System.out.printf("Digite o tamanho do vetor: ");
       int n = scan.nextInt();  // Tamanho do vetor
       if (n != 0){
           int[] v = new int[n]; // Vetor v
           System.out.printf("Informe os números inteiros do vetor: \n");
           for (int i=0; i<n; i++){
               v[i] = scan.nextInt();
           }
           System.out.printf("Vetor original: ");
           for (int i=0; i<n; i++){
               System.out.printf("%d ", v[i]);
           }
           System.out.printf("\n");
           System.out.printf("Digite o número e a posição em que será inserido no vetor: \n");
           // p > 0
           int k = scan.nextInt(), p = scan.nextInt();  // k será inserido na posição p do vetor
           boolean posCheck = true;  // Verifica se a posição de p é válida
           if (p < 1 || p > n){
               System.out.printf("Posição inválida.\n");
               posCheck = false;
           }
           else if (p != n){
               // Temos que deslocar todos os valores de v[p] em diante para frente, fazendo com que o último elemento saia do vetor
               for (int i=p-1; i < n; i++){
                   int temp = v[i];
                   v[i] = k;
                   k = temp;
               }
           }
           else{  // k será inserido na última posição do vetor
               v[p-1] = k;
           }
           if (posCheck){
               System.out.printf("Vetor alterado: ");
               for (int i=0; i<n; i++){
                   System.out.printf("%d ", v[i]);
               }
               System.out.printf("\n");
           }
       }
       scan.close();
    }
}
