package Src;
import java.util.Scanner;

public class EntradaSaida {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.println("Olá " +nome+ ", bem vindo ao Java!");
            scanner.close();
        }
    }
}