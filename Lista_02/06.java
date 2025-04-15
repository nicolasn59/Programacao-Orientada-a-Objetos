import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int qtd = scanner.nextInt();
        if (qtd <= 10) System.out.printf("%s: R$ %.2f\n", nome, qtd*preco);
        else if (qtd <= 20) System.out.printf("%s: R$ %.2f\n", nome, qtd*(preco*0.9));
        else if (qtd <= 50) System.out.printf("%s: R$ %.2f\n", nome, qtd*(preco*0.8));
        else System.out.printf("%s: R$ %.2f\n", nome, qtd*(preco*0.25));
        scanner.close();
    }
}
