package Src.Armazenamento;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", 2023);
        Carro carro2 = new Carro("Honda", 2018);


        GerenciadorTexto txt = new GerenciadorTexto();
        txt.salvarCarro(carro);
        txt.salvarCarro(carro2);
        

        ArrayList<Carro> lista = new ArrayList<>();
        lista.add(carro);
        lista.add(carro2);

        GerenciadorBinario bin = new GerenciadorBinario();
        bin.salvarLista(lista);
        ArrayList<Carro> carregados = bin.carregarLista();

        System.out.println("\n Carros Carregados via Serialização");
        for (Carro c : carregados){
            c.exibir_informacoes();
        }

        
    }

    

}
