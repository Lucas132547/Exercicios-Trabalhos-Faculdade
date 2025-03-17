package Src;

public class ExemploSwitchCase {
    public static void main(String[] args) {
        int opcao = 1;
        switch (opcao) {
            case 1:
                System.out.println("Opcao 1 Escolhida");     
                break;
        
            case 2:
                System.out.println("Opcao 2 escolhida");
                break;
            
            default:
                System.out.println("opcao invalida");
        }
    }
}
