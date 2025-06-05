package Src;

public class CarroEsportivo extends Carro {

    private boolean turbo;

    public CarroEsportivo(String marca, int ano, boolean turbo) {
            super(marca, ano);
            this.turbo = turbo;
    }

    @Override
    public void acelerar(double velocidade){
        if (turbo){
            velocidade *= 1.5; //aumenta a velocidade em 50%
            System.out.println(getMarca() + " tá com turbo ligado");
        }
        super.acelerar(velocidade);
    }

    @Override
    public void exibir_informacoes(){
        super.exibir_informacoes();
        System.out.println("Turbo: " + (turbo ? "Ligado" : "Desligado"));
    }   

    public static void main(String[] args) {
        Carro fusca = new Carro("Volkswagen", 2020);
        fusca.acelerar(50);
        fusca.exibir_informacoes();
        
        System.out.println("\n........\n");

        CarroEsportivo ferrari = new CarroEsportivo("Ferrari", 2025, true);
        ferrari.acelerar(50);
        ferrari.exibir_informacoes();

        System.out.println("\n........\n");

        ferrari.frear();
        ferrari.exibir_informacoes();
    }

    

    
    
}
