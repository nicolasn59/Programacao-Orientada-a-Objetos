import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] nomes = new String[10];
        int[] idades = new int[10];
        System.out.printf("Digite o nome e idade das 10 pessoas: \n");
        for (int i=0; i<10; i++){
            nomes[i] = scan.nextLine();
            idades[i] = scan.nextInt();
            scan.nextLine();
        }
        for (int i=0; i<9; i++){
            for (int j=i+1; j<10; j++){
                if (nomes[i].compareToIgnoreCase(nomes[j]) > 0){  // Ordena alfabéticamente
                    String tempName = new String(nomes[i]);
                    nomes[i] = nomes[j];
                    nomes[j] = tempName;

                    int tempAge = idades[i];
                    idades[i] = idades[j];
                    idades[j] = tempAge;
                }
                if (nomes[i].equals(nomes[j]) && idades[i] > idades[j]){  // Ordena de forma crescente de acordo com a idade
                    int tempAge = idades[i];
                    idades[i] = idades[j];
                    idades[j] = tempAge;
                }
            }
        }
        for (int i=0; i<10; i++){
            System.out.printf("%s - %d anos\n", nomes[i], idades[i]);
        }
        scan.close();
    }
}
