import java.io.Serializable;
public class Fuoco extends Pokemon implements Serializable{
    /*
    * All'interno del costruttore di un pokemon generico di tipo fuoco creaiamo i tre attacchi comuni ai pokemon di tipo Fuoco 
    */
    private Attacco a1 = new Attacco("Azione", 20);
    private Attacco a2 = new Attacco("Sventolata di Fiamme", 40);
    private Attacco a3 = new Attacco("Brucia Culo", 60);

    public Fuoco(int id, String nome, int salute){
        super(id, nome, "Fuoco", salute, 1);

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