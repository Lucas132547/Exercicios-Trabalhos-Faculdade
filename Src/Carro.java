package Src;

public class Carro {
    protected String marca;
    private int ano;
    private double velocidadeAtual = 0;

    public Carro(String marca, int ano){
        this.marca = marca;
        this.ano = ano;
    }

    public String getMarca(){
        return marca;
    }

    public void acelerar(double velocidade){
        this.velocidadeAtual += velocidade;
        System.out.println(marca + " acelerou para " + velocidadeAtual + " Km/h.");
    }

    public void exibir_informacoes(){
        System.out.println("A marca do carro é " + marca);
        System.out.println("O ano do carro é " + ano);
        System.out.println("A velocidade atual é: " + velocidadeAtual);
    }

    public void frear(){
        this.velocidadeAtual = 0;
        System.out.println(marca + " parou.");
    }
    public static void main(String[] args) {
        Carro meusCarro = new Carro("Ford", 2018 );
        meusCarro.exibir_informacoes();

        
    }
}
