package Src;

import java.util.Scanner;

public class PrimeiroMenu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            int sair = 0;
            do{
                System.out.println("############ MENU PRINCIPAL ############");
                System.out.println("1. Adicionar tarefa");
                System.out.println("2. Listar Tarefas");
                System.out.println("3. Sair");
                System.out.println("Escolha uma opção:");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Adicionar Tarefas");
                        break;
                    case 2:
                        System.out.println("Listar tarefas");
                        break;
                    case 3:
                        System.out.println("Sair");
                        sair = 1;
                        break;
                    
                    default:
                        break;
                }
            } while (sair != 1);{
                scanner.close();
            }
        }   
    }
}
