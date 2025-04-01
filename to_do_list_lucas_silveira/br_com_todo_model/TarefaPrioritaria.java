package to_do_list_lucas_silveira.br_com_todo_model;

public class TarefaPrioritaria extends Tarefa {

    private boolean prioritaria;

    public TarefaPrioritaria(String nome, String descricao, boolean prioritaria) {
            super(nome, descricao);
            this.prioritaria = prioritaria;
    }

    public boolean isPrioritaria(){
        return prioritaria;
    }

    public void setPrioritaria(boolean prioritaria){
        this.prioritaria = prioritaria;
    }

    @Override
    public String toString() {
        return super.toString() + "| Prioritaria: " +(prioritaria ? "Sim" : "Não");
    }





    

    
}
