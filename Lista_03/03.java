/*
O Programa A está correto, pois nele o valor -1 não será impresso.
O Programa B pode ser corrigido adicionando uma estrutura de condição que irá verificar se o valor atribuído a
variável "codigo" é diferente de -1.
 */


// Correção do Programa B

import java.util.Scanner;

public class Codigo {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int codigo;

        do{
            System.out.print("Informe o código: ");
            codigo = teclado.nextInt();
            if (codigo != -1) System.out.println("Código: " + codigo); // Controle de fluxo
        } while (codigo != -1);
    }
}
