package Src.Armazenamento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GerenciadorBinario {
    public void salvarLista(ArrayList<Carro> lista){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("carros.dat"))){
            
            out.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            
        }
    }

    public ArrayList<Carro> carregarLista(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("carros.dat"))) {

            return ArrayList<Carro> in.readObject();
        } catch (IOException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
            return new ArrayList<>();
        } 
        
        return null;
    }
}
