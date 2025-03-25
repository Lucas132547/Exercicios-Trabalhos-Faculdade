package to_do_list_lucas_silveira.br_com_todo_util;

import java.io.IOException;

public class Arquivo {

    public  static void limpar_tela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao limpar a tela.");
        }
    }
    
}
