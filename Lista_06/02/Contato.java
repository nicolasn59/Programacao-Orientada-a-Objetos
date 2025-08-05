import java.util.Scanner;

public class Contato {
    // Atributos
    private String nome;
    private String numero;
    private int ID;

    // Metodo Construtor
    public Contato(){
        this.nome = "";
        this.numero = "";
        this.ID = -1;
    }

    // Metodos da classe
    public void exibirContatos(String[][] listaDeContatos, int qtdContatos){
        // Formatação de string
        System.out.printf("%-" + 15 + "s", "Nome");
        System.out.printf("%-" + 15 + "s", "Numero");
        System.out.printf("%" + 10 + "s", "ID");
        System.out.println(); // Quebra linha

        for (int i=0; i < 50; i++){
            System.out.print("-");

        }
        System.out.println(); // Quebra linha
        for (int i=0; i < qtdContatos; i++){ // Imprime os contatos cadastrados (nome e numero)
            System.out.printf("%-" + 15 + "s", listaDeContatos[i][0]);
            System.out.printf("%-" + 15 + "s", listaDeContatos[i][1]);
            System.out.printf("%" + 10 + "d", i);
            System.out.println();
        }
        System.out.println();
    }

    public String[][] adicionarContato(String[][] listaDeContatos, int qtdContatos){
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        this.nome = scan.nextLine(); // Atributo declarado no início da classe
        System.out.print("Informe o numero: ");
        this.numero = scan.nextLine(); // Atributo declarado no início da classe

        if (qtdContatos == 1){
            listaDeContatos[0][0] = nome;
            listaDeContatos[0][1] = numero;
        }
        else{
            // Definindo um novo tamanho para a lista de contatos
            int novoTamanho = listaDeContatos.length + 1;

            // Novo array com tamanho aumentado
            String[][] novaListaDeContatos = new String[novoTamanho][2];

            // Copiando os dados do antigo array para o novo array
            System.arraycopy(listaDeContatos, 0, novaListaDeContatos, 0, listaDeContatos.length);
            // System.arraycopy(arrayOrigem, posInicialOrigem, arrayDestino, posInicialDestino, numElementosACopiar);

            // Atualizando a referência (lista de contatos)
            listaDeContatos = novaListaDeContatos;

            // Cadastrando um novo contato
            for (int i=0; i < listaDeContatos.length; i++){
                System.out.printf("Lista: %s\n", listaDeContatos[i][0]);
                if (listaDeContatos[i][0] == null){ // Se o indice 0 está vazio, então o indice 1 também está vazio
                    listaDeContatos[i][0] = nome;
                    listaDeContatos[i][1] = numero;
                }
            }
        }

        // Retorna a lista de contatos com um novo contato
        return listaDeContatos;
    }

    public String[][] removerContato(String [][] listaDeContatos, int qtdContatos){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o ID para remover o contato: ");
        this.ID = scan.nextInt();

        if (qtdContatos <= 1){
            listaDeContatos[0][0] = null;
            listaDeContatos[0][1] = null;
        }
        else{
            // Definindo um novo tamanho para a lista de contatos
            int novoTamanho = listaDeContatos.length - 1;
            System.out.printf("\n\nNovo tamanho do vetor: %d\n\n", novoTamanho);
            // Novo array com tamanho diminuído
            String[][] novaListaDeContatos = new String[novoTamanho][2];

            // Copiando array antigo para array novo
            int cont = 0;
            for (int i=0; i < qtdContatos; i++){
                // Não vai copiar o contato a ser removido
                if (i != this.ID){ // Se i for diferente de ID
                    novaListaDeContatos[cont][0] = listaDeContatos[i][0];
                    novaListaDeContatos[cont][1] = listaDeContatos[i][1];
                    cont += 1;
                }
            }

            // Atualizando a referência (listaDeContatos)
            listaDeContatos = novaListaDeContatos;
        }

        // Retorna a lista de contatos com um contato removido
        return listaDeContatos;
    }
}
