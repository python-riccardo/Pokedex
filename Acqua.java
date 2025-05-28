import java.io.Serializable;

/**
 * Classe Pokemon di tipo Acqua
 */
public class Acqua extends Pokemon implements Serializable{
    private Attacco a1 = new Attacco("Azione", 20);
    private Attacco a2 = new Attacco("Pistolacqua", 40);
    private Attacco a3 = new Attacco("Idrondata", 60);

    /**
     * Costruttore per Pokemon tipo Acqua
     * @param id identificativo
     * @param nome nome del Pokemon
     * @param salute punti salute iniziali
     */
    public Acqua(int id, String nome, int salute){
        super(id, nome, "Acqua", salute, 1);

        listaAttacchi.add(a1);
        listaAttacchi.add(a2);
        listaAttacchi.add(a3);

        mappaAttacchi.put(a1.getNome(),a1);
    }

    /**
     * Aumenta il livello del Pokemon
     * Se il livello raggiunge determinate soglie, il Pokemon impara nuovi attacchi
     * @param c incremento di livello
     */
    @Override
    public void aumentaLivello(int c){
        livello += c;
        if(livello >= 10 && !mappaAttacchi.containsKey(a2.getNome())){
            mappaAttacchi.put(a2.getNome(),a2);
        }
        if(livello >= 20){
            mappaAttacchi.put(a3.getNome(),a3);
        }
    }
}