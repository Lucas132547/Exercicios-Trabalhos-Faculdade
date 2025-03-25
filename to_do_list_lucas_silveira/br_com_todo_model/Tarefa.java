package to_do_list_lucas_silveira.br_com_todo_model;

public class Tarefa {
    //Getters e Setters
    public static String nome_tarefa;
    public static boolean status_tarefa;
    public static String descricao_tarefa;
    
    public String getnome_tarefa(){
        return nome_tarefa;
    }
    public Boolean getstatus_tarefa(){
        return status_tarefa;
    }
    public String getdescricao_tarefa(){
        return descricao_tarefa;
    }

    /////////////////////////////////////////////////////////
    
    public void setnome_tarefa(String nome_tarefa){
        Tarefa.nome_tarefa = nome_tarefa;
    }
    public void setstatus_tarefa(boolean status_tarefa){
        Tarefa.status_tarefa = status_tarefa;
    }
    public void setdescricao_tarefa(String descricao_tarefa){
        Tarefa.descricao_tarefa = descricao_tarefa;
    }
    

}
