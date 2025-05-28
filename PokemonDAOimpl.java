import java.io.*;
import java.util.Vector;
import java.io.Serializable;

public class PokemonDAOimpl implements PokemonDAO{
    private Vector<Pokemon> listaPokemon = new Vector<>();
    private String file;

    public PokemonDAOimpl(){
        file = "pokedex.dat";
    }
    @Override
    public void aggiungiPokemon(Pokemon p){
        listaPokemon.add(p); // aggiunge il pokemon
    }

    @Override    
    public void togliPokemon(int i){
        for(int c = 0; c < listaPokemon.size(); c++){
            if(listaPokemon.elementAt(c).getId() == i){
                listaPokemon.remove(c); // cancella il pokemon
                return;
            }
        }
        System.out.println("Pokemon non trovato!");
    }

    @Override
    public Pokemon cercaPokemon(int i){
        for(int c = 0; c < listaPokemon.size(); c++){
            if(listaPokemon.elementAt(c).getId() == i){
                System.out.println("Trovato pokemon " + listaPokemon.elementAt(c).getNome());
                return listaPokemon.elementAt(c); // ritorna il pokemon
            }
        }
        return null; // se non viene trovato il Pokemon ritorna valore null
    }

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