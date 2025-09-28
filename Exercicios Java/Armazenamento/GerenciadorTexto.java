package Src.Armazenamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorTexto {
    public void salvarCarro(Carro carro){
        try (BufferedWriter writer = new BufferedWriter(new BufferedWriter("carros.txt",  ))){
            writer.write(carro.getMarca() + ";" + carro.getAno());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar Carro" + e.getMessage());
        }
    }

    public void lerCarro(){
        try (BufferedReader Reader = new BufferedReader (new FileReader("carros.txt"))) {
            String linha;
            while ((linha = reader.readLine()) =! null){
                String[] partes = linha.split(";");
                String marca = partes[0];
                int ano = Integer.parseInt(partes[1]);
                System.out.println("Mara: " + marca + "|  Ano: " + ano);
            }
        } catch (IOException e) {
           System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }
}
