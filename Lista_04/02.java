import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Informe o tamanho do vetor: ");
        int n = scan.nextInt();  // Tamanho do vetor
        boolean check = false;  // Verifica se o número k (número que buscaremos no vetor) existe no vetor
        if (n != 0){
            int[] v = new int[n];  // Vetor v
            System.out.printf("Digite os %d números inteiros do vetor: \n", n);
            for (int i=0; i < n; i++){
                v[i] = scan.nextInt();
            }
            System.out.printf("Digite o número que deseja encontrar no vetor: ");
            int k = scan.nextInt();  // Número k que iremos buscar no vetor
            int cont=1;
            for (int i=0; i < n; i++){
                if (v[i] == k){
                    System.out.printf("O número %d foi encontrado na posição %dº do vetor.\n", k, cont);
                    check = true;
                }
                cont += 1;
            }
        }
        if (!check){  // Se check for igual a false
            System.out.printf("Número não encontrado.\n");
        }
        scan.close();
    }
}
