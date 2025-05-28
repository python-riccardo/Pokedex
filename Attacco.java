import java.io.Serializable;
public class Attacco implements Serializable{
    private String nome;
    private int danno;

    public Attacco(String nome, int danno){
        this.nome = nome;
        this.danno = danno;
    }

    public String getNome(){
        return nome;
    }
    public int getDanno(){
        return danno;
    }
}