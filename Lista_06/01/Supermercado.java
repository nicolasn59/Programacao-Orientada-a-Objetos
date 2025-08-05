import java.util.Scanner;

public class Supermercado {
    private String[] nomeDoProduto = new String[2];
    private float[] precoDoProduto = new float[2];
    private int[] quantidadeEstoque = new int[2];


    // METODO CONSTRUTOR
    public Supermercado(){
        this.nomeDoProduto[0] = "Leite";
        this.nomeDoProduto[1] = "Biscoito";

        this.precoDoProduto[0] = 4.99f;
        this.precoDoProduto[1] = 8.99f;

        this.quantidadeEstoque[0] = 12;
        this.quantidadeEstoque[1] = 7;
    }

    private String getNomeDoProduto(int indice){
        return this.nomeDoProduto[indice];
    }
    private float getPrecoDoProduto(int indice){

        return this.precoDoProduto[indice];
    }
    private int getQuantidadeEstoque(int indice){
        return this.quantidadeEstoque[indice];
    }
    private void setQuantidadeEstoque(int reducao, int indice){
        this.quantidadeEstoque[indice] -= reducao;
    }

    private void verificarEstoque(){
        // Variáveis para formatação das strings
        int larguraProduto = 15;
        int larguraPreco = 10;
        int larguraQuantidade = 10;
        int larguraCodigo = 12;

        System.out.printf("%-" + larguraProduto + "s", "Produto");
        System.out.printf("%-" + larguraPreco + "s", "Preco");
        System.out.printf("%" + (larguraQuantidade+2) + "s", "Quantidade");
        System.out.printf("%" + (larguraCodigo+1) + "s", "Codigo\n");
        for (int i=0; i < 50; i++){
            System.out.print("-");
        }
        System.out.println();
        for (int i=0; i < 2; i++){
            System.out.printf("%-" + larguraProduto + "s", getNomeDoProduto(i));
            System.out.printf("R$%-" + larguraPreco + ".2f", getPrecoDoProduto(i));
            System.out.printf("%" + larguraQuantidade + "d", getQuantidadeEstoque(i));
            System.out.printf("%" + (larguraCodigo) + "d\n", i);
        }
        System.out.println();
    }

    private void pedido(){
        float valor = 0f; // Valor total do pedido do cliente
        Scanner scan = new Scanner(System.in);

        int qtdProdutos = 0; // Quantidade de produtos que o cliente quer comprar
        int[][] produtos = new int[1][2];
        // Garantido entrar no laço
        while (qtdProdutos < 1){
            System.out.println("Digite a quantidade de produtos que voce deseja comprar: ");
            qtdProdutos = scan.nextInt(); // Recebe a quantidade de produtos que o cliente quer comprar
            if (qtdProdutos == 1){
                System.out.print("Digite o codigo do produto: ");
                int codigo = scan.nextInt(); // Codigo do produto
                produtos[0][0] = codigo; // Armazena o código do produto que o cliente deseja
            }
            else{
                produtos = new int[qtdProdutos][2]; // Redimensionando o tamanho do vetor
                for (int i=0; i < qtdProdutos; i++){
                    System.out.printf("Digite o codigo do %dº produto: ", (i+1));
                    int codigo = scan.nextInt(); // Codigo do produto
                    produtos[i][0] = codigo; // Armazena o código do produto que o cliente deseja
                }
            }
            System.out.println();
        }

        for (int i=0; i < qtdProdutos; i++){
            System.out.printf("Digite quantas unidade(s) de %s que voce deseja comprar: ", getNomeDoProduto(produtos[i][0]));
            int qtd = scan.nextInt(); // Quantidade de unidades de um produto que o cliente quer comprar
            // Verifica a quantidade de produtos no estoque do mercado
            while (qtd > getQuantidadeEstoque(produtos[i][0])){
                System.out.printf("Nao temos essa quantidade de %s no estoque!\n", getNomeDoProduto(produtos[i][0]));
                System.out.printf("Por favor, digite outra unidade de %s que voce deseja comprar: ", getNomeDoProduto(produtos[i][0]));
                qtd = scan.nextInt();
            }
            produtos[i][1] = qtd; // Armazena a quantidade de unidades de um produto que o cliente deseja
            setQuantidadeEstoque(qtd, produtos[i][0]); // Reduz no estoque
        }

        for (int i=0; i < qtdProdutos; i++){
            // Calcula o valor total do pedido
            valor += getPrecoDoProduto(produtos[i][0]) * produtos[i][1];
        }

        System.out.println("\nPedido: ");
        for (int i=0; i < qtdProdutos; i++){
            System.out.printf("%d unidade(s) de %s por R$%.2f cada\n", produtos[i][1], getNomeDoProduto(produtos[i][0]), getPrecoDoProduto(produtos[i][0]));
        }

        System.out.printf("Valor total: R$%.2f\n", valor);
        System.out.println("\nDeseja confirmar o pedido?");
        System.out.println("(1) Sim\n(2) Nao");
        if (scan.nextInt() == 1){ // Verifica a resposta do cliente
            pagamento(valor, produtos); // Chama o métod de pagamento
        }
        else{
            System.out.println("Pedido cancelado!");
            produtos = new int[1][2];
        }
    }

    private void formasDePagamento(){
        System.out.println("Formas de pagamentos: ");
        System.out.println("(1) Dinheiro/PIX sem taxas adicionais");
        System.out.println("(2) Cartao de credito até 6x com juros");
        System.out.println("(3) Debito com taxa de 5% do valor");
        System.out.println("(4) Consultar o valor da compra");
        System.out.println("(5) Cancelar compra");
    }

    private void pagamento(float valor, int[][] produtos){
        Scanner scan = new Scanner(System.in);
        int pagar = 0; // Forma de pagamento que o cliente preferir
        while (((pagar < 1) || (pagar > 4))){
            formasDePagamento(); // Mostra as formas de pagamento
            System.out.print("Escolha uma forma de pagamento: ");
            pagar = scan.nextInt();

            if (pagar == 1){ // Dinheiro/Pix
                System.out.println("\nDeseja confirmar a compra?");
                System.out.println("(1) Sim\n(2) Nao");
                if (scan.nextInt() == 1){
                    System.out.println("Pagamento aprovado!");
                }
                else{
                    System.out.println("Pagamento cancelado!\n");
                    pagar = -1;
                }
            }
            else if (pagar == 2){ // Crédito
                int parcelas = -1;
                while ((parcelas < 0 || parcelas > 6)){
                    System.out.println("\nParcelas: ");
                    System.out.printf("1x de R$%.2f\n", ((valor*105)/100));
                    System.out.printf("2x de R$%.2f\n", ((valor*107)/100));
                    System.out.printf("3x de R$%.2f\n", ((valor*109)/100));
                    System.out.printf("4x de R$%.2f\n", ((valor*111)/100));
                    System.out.printf("5x de R$%.2f\n", ((valor*113)/100));
                    System.out.printf("6x de R$%.2f\n", ((valor*115)/100));
                    System.out.println("Digite o numero de parcelas ou digite 0 para cancelar: ");
                    parcelas = scan.nextInt();
                    if (parcelas == 0){
                        System.out.println("Pagamaneto cancelado!\n");
                        pagar = -1;
                    }
                    else if (parcelas >= 1 && parcelas <= 6){
                        System.out.println("Pagamento aprovado!");
                    }
                }
            }
            else if (pagar == 3){ // Débito
                System.out.printf("\nDeseja confirmar a compra de R$%.2f no debito?\n", ((valor*105)/100));
                System.out.println("(1) Sim\n(2) Nao");
                if (scan.nextInt() == 1){
                    System.out.println("Pagamento aprovado!");
                }
                else{
                    System.out.println("Pagamento cancelado!\n");
                    pagar = -1;
                }
            }
            else if (pagar == 4){
                System.out.println("\nVoce esta comprando: ");
                for (int i=0; i < produtos.length; i++){
                    System.out.printf("%d unidade(s) de %s(s) por R$%.2f cada.\n", produtos[i][1], getNomeDoProduto(produtos[i][0]), getPrecoDoProduto(produtos[i][0]));
                }
                System.out.printf("Valor total: %.2f\n", valor);
                System.out.println();
                pagar = -1;
            }
            else if (pagar == 5){
                System.out.println("Compra cancelada!");
                pagar = 1;
            }
            else{
                System.out.println("\nForma de pagamento invalida!");
            }
        }
    }
    public void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bem-vindo ao NicMarket!");
        int opcao = 0;
        while (opcao == 0){
            System.out.println("O que voce deseja?");
            System.out.println("(1) Ver produtos\n" +
                               "(2) Fazer um pedido\n" +
                               "(3) Sair");
            opcao = scan.nextInt();
            if (opcao == 1){
                verificarEstoque();
                opcao = 0;
            }
            else if (opcao == 2){
                pedido();
                opcao = 0;
            }
            else if (opcao == 3){
                System.out.println("Saindo...");
            }
            else{
                System.out.println("Opcao inválida!\n");
                opcao = 0;
            }
        }
        System.out.println("Obrigado pela presenca, volte sempre!");
        scan.close();
    }
}
