import java.util.HashMap;
import java.util.Vector;
import java.io.Serializable;

public abstract class Pokemon implements Serializable {
    protected int id;
    protected String nome;
    protected String tipo;
    protected int salute;
    protected int livello;
    protected boolean ko;
    protected Vector<Attacco> listaAttacchi = new Vector<Attacco>(); //Lista di attacchi imparabili
    protected HashMap<String, Attacco> mappaAttacchi = new HashMap<>(); //Lista di attacchi imparati

    /**
     * Costruttore per la classe Pokemon
     * @param id identificativo del Pokemon
     * @param nome nome del Pokemon
     * @param tipo tipo del Pokemon (es. Fuoco, Acqua, Erba)
     * @param salute punti salute iniziali del Pokemon
     * @param livello livello iniziale del Pokemon
     */
    public Pokemon(int id, String nome, String tipo, int salute,int livello){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.salute = salute;
        this.livello = livello;
        this.ko = false;
    }

    /**
     * Aggiunge un attacco imparato alla mappa degli attacchi del Pokemon
     * @param a attacco da aggiungere
     */
    public void aggiungiAttacco(Attacco a) {
        mappaAttacchi.put(a.getNome(), a);
    }

    /**
     * Il metodo attacca infligge danno ad un altro Pokemon
     * @param attacco nome dell'attacco da utilizzare
     * @param p Pokemon bersaglio dell'attacco
     */
    public void attacca(String attacco,Pokemon p){
        if (mappaAttacchi.containsKey(attacco)) {
            p.setSalute(p.getSalute() - mappaAttacchi.get(attacco).getDanno());
            if(p.getSalute() <= 0){
                p.setKO();
            }
        }
        else{
            System.out.println(nome + " non conosce questa mossa!");
        }
    }

    /**
     * Metodo astratto per aumentare il livello del Pokemon
     * @param c incremento del livello
     */
    public abstract void aumentaLivello(int c);

    //Metodi Getter

    /**
     * Restituisce l'id del Pokemon
     * @return id del Pokemon
     */
    public int getId(){
        return id;
    }

    /**
     * Restituisce il nome del Pokemon
     * @return nome del Pokemon
     */
    public String getNome(){
        return nome;
    }

    /**
     * Restituisce il tipo del Pokemon
     * @return tipo del Pokemon
     */
    public String getTipo(){
        return tipo;
    }

    /**
     * Restituisce la salute attuale del Pokemon
     * @return salute del Pokemon
     */
    public int getSalute(){
        return salute;
    }

    /**
     * Indica se il Pokemon è KO
     * @return true se è KO, false altrimenti
     */
    public boolean isKO(){
        return ko;
    }

    //Metodi Setter

    /**
     * Imposta i punti salute del Pokemon
     * @param salute nuovi punti salute
     */
    public void setSalute(int salute){
        this.salute = salute;
    }

    /**
     * Imposta lo stato KO del Pokemon e stampa messaggio
     */
    public void setKO(){
        ko = true;
        System.out.println(nome + " è andato KO!");
    }

    @Override
    public String toString(){
        return "ID = " + id +
                "\nNome = " + nome  +
                "\nTipo = " + tipo +
                "\nSalute = " + salute +
                "\nLivello = " + livello +
                "\nAttacchi disponibili: " + mappaAttacchi.keySet();
    }
}
