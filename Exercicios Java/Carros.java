package Src;
public class Carros {
    private String marca;
    private int ano;
    
    public void exibir_informacoes(){
        System.out.println("A marca do carro é " + marca);
        System.out.println("O ano do carro é " + ano);
    }

    public String getmarca(){
        return marca;
    }

    public int getano(){
        return ano;
    }

    public void setmarca(String marca){
        this.marca = marca;
    }

    public void setano(int ano){
        this.ano = ano;
    }

    public Carros(String marca, int ano){
        this.marca = marca;
        this.ano = ano;
    }
    public static void main(String[] args) {
        Carros meusCarros = new Carros("Ford", 2018);
        meusCarros.exibir_informacoes();

        meusCarros.setmarca("Jaguar");
        meusCarros.setano(2025);

        System.out.println("\nModelo " + meusCarros.getmarca());
        System.out.println("Ano " + meusCarros.getano());
    }
   
}