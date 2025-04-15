import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int n = teclado.nextInt();
        int maior = teclado.nextInt();
        int menor = teclado.nextInt();
        if (maior > menor){
            if (n < menor) System.out.print("Antes do intervalo!\n");
            else if (n > maior) System.out.print("Depois do intervalo!\n");
            else System.out.print("Dentro do intervalo!\n");
        }
        else{  // maior < menor e maior == menor
            if (n < maior) System.out.print("Antes do intervalo!\n");
            else if (n > menor) System.out.print("Depois do intervalo!\n");
            else System.out.print("Dentro do intervalo!\n");
        }
        teclado.close();
    }
}
