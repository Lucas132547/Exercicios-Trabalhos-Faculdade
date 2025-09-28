package Src.Armazenamento;

public class Carro {
    protected String marca;
    private int ano;

    public Carro(String marca, int ano){
        this.marca = marca;
        this.ano = ano;
    }

    public void exibir_informacoes(){
        System.out.println("A marca do carro é " + marca);
        System.out.println("O ano do carro é " + ano);
    }

    public String getMarca(){
        return marca;
    }

    public int getAno(){
        return ano;
    }
}
