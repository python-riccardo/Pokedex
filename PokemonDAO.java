import java.util.Vector;

/**
 * Interfaccia DAO per la gestione dei Pokemon
 */
public interface PokemonDAO{
    /**
     * Aggiunge un Pokemon alla lista
     * @param p Pokemon da aggiungere
     */
    void aggiungiPokemon(Pokemon p);

    /**
     * Rimuove un Pokemon dalla lista tramite ID
     * @param i id del Pokemon da rimuovere
     */
    void togliPokemon(int i);

    /**
     * Cerca un Pokemon nella lista tramite ID
     * @param i id del Pokemon da cercare
     * @return Pokemon trovato o null se non esiste
     */
    Pokemon cercaPokemon(int i);

    /**
     * Salva la lista di Pokemon su file
     */
    void save();

    /**
     * Carica la lista di Pokemon da file
     */
    void carica();

    /**
     * Restituisce la lista di Pokemon attuale
     * @return Vector contenente i Pokemon
     */
    Vector<Pokemon> getListaPokemon();
}