package to_do_list_lucas_silveira.br_com_todo_main;

import to_do_list_lucas_silveira.br_com_todo_model.Tarefa;
import to_do_list_lucas_silveira.br_com_todo_util.Arquivo;
import java.util.Scanner;

public class Main {

    public Main(String nome_tarefa, boolean status_tarefa, String descricao_tarefa){
        Tarefa.nome_tarefa = nome_tarefa;
        Tarefa.status_tarefa = status_tarefa;
        Tarefa.descricao_tarefa = descricao_tarefa;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        Main teste = new Main("Exemplo", true, "qualquer coisa");

        System.out.println("Teste " + teste.getnome_tarefa());

        teste.setnome_tarefa("Depois da mudança");

        do {
            System.out.println("############# TO DO LIST #############");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Editar tarefa");
            System.out.println("4. Visualizar tarefas");
            System.out.println("5. Marcar tarefa como concluída");
            System.out.println("6. Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            
            Arquivo.limpar_tela();  

            switch (opcao) {
                case 1:
                    scanner.nextLine();  

                    System.out.println("Digite o nome da tarefa que você deseja adicionar:");
                    String nome = scanner.nextLine();
            
                    if (nome.trim().isEmpty()) {
                        System.out.println("Você deve fornecer um nome válido para a tarefa.");
                    } else {
                        System.out.println("Tarefa adicionada com sucesso: " + nome);
                    }

                    break;
                case 2:
                    System.out.println("Remover tarefa...");
                    break;
                case 3:
                    System.out.println("Editar tarefa...");
                    break;
                case 4:

                    int opcao4;

                do {
                    System.out.println("1. Visualizar apenas tarefas a serem realizadas");
                    System.out.println("2. Visualizar tarefas a serem realizadas e tarefas já concluídas");
                    System.out.print("\nEscolha uma opção: ");
                    opcao4 = scanner.nextInt();

                    Arquivo.limpar_tela();
                    
                    if (opcao4 == 1) {
                        System.out.println("Visualizar tarefas a serem realizadas");
                    } else if (opcao4 == 2) {
                        System.out.println("Visualizar todas as tarefas.");
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                } while (opcao4 != 1 && opcao4 != 2);  

                    break;
                case 5:
                    System.out.println("Marcar tarefa como concluída...");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
