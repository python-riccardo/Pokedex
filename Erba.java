import java.io.Serializable;
public class Erba extends Pokemon implements Serializable{
    /*
    * All'interno del costruttore di un pokemon generico di tipo erba creaiamo i tre attacchi comuni ai pokemon di tipo Erba 
    */
    private Attacco a1 = new Attacco("Azione", 20);
    private Attacco a2 = new Attacco("Allucinazioni Marijuana", 40);
    private Attacco a3 = new Attacco("Foglialama", 60);
    
    public Erba(int id, String nome, int salute){
        super(id, nome, "Erba", salute, 1);

        listaAttacchi.add(a1);
        listaAttacchi.add(a2);
        listaAttacchi.add(a3);

        mappaAttacchi.put(a1.getNome(),a1);
    }
    
    /*
    * Metodo per aumentare il livello di un pokemon.
    * Se il livello lo permette, il pokemon impara una nuova mossa.
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