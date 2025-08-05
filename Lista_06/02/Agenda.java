import java.util.Scanner;

public class Agenda implements AgendaTelefonica{
    // Atributos
    private int totalContatos;
    private String[][] listaDeContatos = new String[1][2];

    // Metodo Construtor
    public Agenda(){
        this.totalContatos = 0;
    }

    // Metodos da Classe
    private int getTotalContatos(){
        return this.totalContatos;
    }

    private void setTotalContatos(boolean option){
        if (option){ // Adicionou um cadastro
            this.totalContatos += 1;
        }
        else{ // Removeu um cadastro
            this.totalContatos -= 1;
        }
    }

    private int opcoes(){
        Scanner scan = new Scanner(System.in);
        System.out.println("(1) Quantidade de cadastros");
        System.out.println("(2) Exibir cadastros");
        System.out.println("(3) Cadastrar um novo contato");
        System.out.println("(4) Remover contato");
        System.out.println("(5) Sair");
        System.out.println("Escolha uma opcao: ");
        int opcao = scan.nextInt();
        return opcao;
    }

    public void menu(){
        int opcao = opcoes();
        while (opcao != 5){
            if (opcao == 1){
                quantidadeDeContatos();
            }
            else if (opcao == 2){
                mostraContatos();
            }
            else if (opcao == 3){
                novoContato();
            }
            else if (opcao == 4){
                retirarContato();
            }
            opcao = opcoes();
        }
    }

    // Metodos Abstratos

    @Override
    public void quantidadeDeContatos(){
        System.out.printf("%d contatos cadastrados.\n\n", getTotalContatos());
    }

    @Override
    public void mostraContatos(){
        Contato contatos = new Contato();
        contatos.exibirContatos(this.listaDeContatos, getTotalContatos());
    }

    @Override
    public void novoContato(){
        Contato contato = new Contato();
        this.listaDeContatos = contato.adicionarContato(this.listaDeContatos, getTotalContatos());
        setTotalContatos(true); // Aumenta a quantidade contatos
        System.out.println("Contato cadastrado com sucesso!");
    }

    @Override
    public void retirarContato(){
        Contato contato = new Contato();
        this.listaDeContatos = contato.removerContato(this.listaDeContatos, getTotalContatos());
        setTotalContatos(false); // Diminui a quantidade de contatos
        System.out.println("Contato removido com sucesso!");
    }
}
