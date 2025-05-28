import java.util.Vector;
public interface PokemonDAO{
    void aggiungiPokemon(Pokemon p);
    void togliPokemon(int i);
    Pokemon cercaPokemon(int i);
    void save();
    void carica();
    Vector<Pokemon> getListaPokemon();
}