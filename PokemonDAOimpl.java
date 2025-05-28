import java.io.*;
import java.util.Vector;
import java.io.Serializable;

/**
 * Implementazione dell'interfaccia PokemonDAO
 * Gestisce la lista di Pokemon e il salvataggio/caricamento su file
 */
public class PokemonDAOimpl implements PokemonDAO{
    private Vector<Pokemon> listaPokemon = new Vector<>();
    private String file;

    /**
     * Costruttore che riceve il nome del file per salvataggio/caricamento
     * @param file nome del file
     */
    public PokemonDAOimpl(String file){
        this.file = file;
    }

    /**
     * Aggiunge un Pokemon alla lista
     * @param p Pokemon da aggiungere
     */
    @Override
    public void aggiungiPokemon(Pokemon p){
        listaPokemon.add(p);
    }

    /**
     * Rimuove un Pokemon dalla lista tramite id
     * @param i id del Pokemon da rimuovere
     */
    @Override    
    public void togliPokemon(int i){
        for(int c = 0; c < listaPokemon.size(); c++){
            if(listaPokemon.elementAt(c).getId() == i){
                listaPokemon.remove(c);
                return;
            }
        }
        System.out.println("Pokemon non trovato!");
    }

    /**
     * Cerca un Pokemon tramite id
     * @param i id del Pokemon da cercare
     * @return Pokemon trovato o null se non esiste
     */
    @Override
    public Pokemon cercaPokemon(int i){
        for(int c = 0; c < listaPokemon.size(); c++){
            if(listaPokemon.elementAt(c).getId() == i){
                System.out.println("Trovato pokemon " + listaPokemon.elementAt(c).getNome());
                return listaPokemon.elementAt(c);
            }
        }
        return null;
    }

    /**
     * Salva la lista di Pokemon nel file specificato
     */
    @Override
    public void save(){
        try{
            FileOutputStream f1 = new FileOutputStream(file);
            ObjectOutputStream fOUT = new ObjectOutputStream(f1);

            for(int i = 0; i < listaPokemon.size(); i++){
                fOUT.writeObject(listaPokemon.elementAt(i));
            }
            System.out.println("Pokemon salvati con successo nel file " + file + "!");
            fOUT.flush();
            fOUT.close();
        }catch(Exception e){
            System.out.println("Errore " + e);
        }
    }

    /**
     * Carica la lista di Pokemon dal file specificato
     */
    @Override
    public void carica(){
        try {
            FileInputStream f2 = new FileInputStream(file);
            ObjectInputStream fIN = new ObjectInputStream(f2);
            Pokemon p;
            boolean uscita = false;
            while(!uscita){
                try{
                    p = (Pokemon) fIN.readObject();
                    listaPokemon.add(p);
                }catch(Exception e){
                    uscita = true;
                }
            }
            f2.close();
            System.out.println("Pokemon caricati dal file " + file + "!");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento: " + e);
        }
    }

    /**
     * Restituisce la lista di Pokemon attuale
     * @return Vector di Pokemon
     */
    @Override
    public Vector<Pokemon> getListaPokemon(){
        return listaPokemon;
    }

    @Override
    public String toString(){
        String txt = "";
        for(int c = 0; c < listaPokemon.size(); c++){
            txt += listaPokemon.elementAt(c) + "\n";
        }
        return txt;
    }
}