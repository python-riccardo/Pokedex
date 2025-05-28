import java.io.Serializable;

/**
 * Classe che rappresenta un attacco di un Pokemon
 */
public class Attacco implements Serializable{
    private String nome;
    private int danno;

    /**
     * Costruttore Attacco
     * @param nome nome dell'attacco
     * @param danno danno inflitto dall'attacco
     */
    public Attacco(String nome, int danno){
        this.nome = nome;
        this.danno = danno;
    }

    /**
     * Restituisce il nome dell'attacco
     * @return nome attacco
     */
    public String getNome(){
        return nome;
    }

    /**
     * Restituisce il danno inflitto dall'attacco
     * @return danno attacco
     */
    public int getDanno(){
        return danno;
    }
}