public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nel Pokedex!");

        System.out.println("Questa applicazione salverà nella memoria di massa i dati del pokedex.");
        System.out.println("Puoi caricare un salvataggio (1) o crearne uno nuovo (2).");
        System.out.println("ATTENZIONE!\nSe viene caricato un salvataggio che non esiste, verrà creato un nuovo salvataggio");
        int sceltainiziale = ChiediDati.ChiediIntero("Digita la tua scelta");

        
        String nomefile = ChiediDati.ChiediStringa("Inserisci il nome del file di salvataggio (senza estensione)");
        nomefile = nomefile + ".dat";

        PokemonDAO pokemonDAO = new PokemonDAOimpl(nomefile);
        pokemonDAO.carica();
        Menu menuApp = new Menu();

        Opzione opz1 = new Opzione("1","Digitare 1 per aggiungere un Pokemon.");
        Opzione opz2 = new Opzione("2","Digitare 2 per togliere un Pokemon.");
        Opzione opz3 = new Opzione("3","Digitare 3 per mostrare tutti i Pokemon.");
        Opzione opz4 = new Opzione("4","Digitare 4 per cercare un Pokemon.");
        Opzione opz5 = new Opzione("5","Digitare 5 per salvare.");
        Opzione opz0 = new Opzione("0","Digitare 0 per uscire.");
        
        menuApp.aggiungi(opz1);
        menuApp.aggiungi(opz2);
        menuApp.aggiungi(opz3);
        menuApp.aggiungi(opz4);
        menuApp.aggiungi(opz5);
        menuApp.aggiungi(opz0);

        boolean uscita = false;
        int scelta;
        int id;
        String nome;
        int salute;
        String tipo;
        Pokemon nuovoPokemon;
        do{
            System.out.println("--------------------------------------------------------------");
            menuApp.stampaMenu();

            scelta = ChiediDati.ChiediIntero("Inserire scelta");

            switch(scelta){
                case 1:
                    id = ChiediDati.ChiediIntero("Inserisci ID del Pokemon");
                    nome = ChiediDati.ChiediStringa("Inserisci nome del Pokemon");
                    salute = ChiediDati.ChiediIntero("Inserisci salute del Pokemon");
                    tipo = ChiediDati.ChiediStringa("Inserisci tipo (Fuoco, Acqua, Erba)");
                    
                    switch (tipo.toLowerCase()) {
                        case "fuoco":
                            nuovoPokemon = new Fuoco(id, nome, salute);
                            pokemonDAO.aggiungiPokemon(nuovoPokemon);
                            break;
                        case "acqua":
                            nuovoPokemon = new Acqua(id, nome, salute);
                            pokemonDAO.aggiungiPokemon(nuovoPokemon);
                            break;
                        case "erba":
                            nuovoPokemon = new Erba(id, nome, salute);
                            pokemonDAO.aggiungiPokemon(nuovoPokemon);
                            break;
                        default:
                            System.out.println("Tipo non riconosciuto! Pokemon non aggiunto.");
                            break;
                    }

                    break;
                case 2:
                    id = ChiediDati.ChiediIntero("Inserire id del Pokemon da rimuovere");
                    pokemonDAO.togliPokemon(id);
                    break;
                case 3:
                    if (pokemonDAO.toString() == ""){
                        System.out.println("Non ci sono Pokemon nel Pokedex!");
                    }
                    else{
                        System.out.println(pokemonDAO);
                    }
                    break;
                case 4:
                    id = ChiediDati.ChiediIntero("Inserire id del Pokemon da cercare");
                    System.out.println(pokemonDAO.cercaPokemon(id));
                    break;
                case 5:
                    pokemonDAO.save();
                    break;
                case 0:
                    pokemonDAO.save();
                    System.out.println("Chiusura dell'applicazione. Arrivederci!");
                    uscita = true;
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }while(!uscita);
    }
}
// fare salvataggi diversi