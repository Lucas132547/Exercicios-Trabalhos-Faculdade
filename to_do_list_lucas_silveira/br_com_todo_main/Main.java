package to_do_list_lucas_silveira.br_com_todo_main;

import java.util.Scanner;

public class Main {
    static int opcao;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("############# TO DO LIST #############");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Visualizar tarefas");
            System.out.println("3. Editar tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Marcar tarefa como concluida");
            System.out.println("\nEscolha uma opcao: ");
    
            opcao = scanner.nextInt();
            scanner.close();



    }
    
}
