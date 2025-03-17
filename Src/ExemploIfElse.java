package Src;

import java.util.Scanner;

public class ExemploIfElse {

        public static void main(String[] args) {
        
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Digite sua idade:");
                int Idade = scanner.nextInt();
                

                if(Idade >= 18){
                    System.out.println("Você é de maior");
                }
                else{
                    System.out.println("Você é de menor");
                }
            }
    }
}
