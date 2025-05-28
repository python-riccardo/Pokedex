# Pokedex
Questa è un'applicazione scritta in Java che simula un Pokedex.  
Permette di creare, salvare, caricare e gestire una collezione di Pokémon di tre tipi (Fuoco, Acqua, Erba).  
I Pokémon hanno statistiche base, attacchi specifici e possono aumentare di livello imparando nuove mosse.

## Funzionalità principali
- Creazione di nuovi Pokémon (Fuoco, Acqua, Erba) con ID, nome, salute e tipo.
- Aggiunta e rimozione di Pokémon dalla collezione.
- Visualizzazione di tutti i Pokémon salvati.
- Ricerca di un Pokémon tramite ID.
- Salvataggio e caricamento dei dati da file `.dat` utilizzando serializzazione.
- Sistema a menu per interazione tramite console.

## Struttura del progetto
- `Main.java`: punto di ingresso dell'applicazione con il menu di interazione.
- `Pokemon` (astratta): classe base per i Pokémon.
- `Fuoco.java`, `Acqua.java`, `Erba.java`: sottoclassi che definiscono attacchi e comportamenti specifici per tipo.
- `Attacco.java`: rappresenta un attacco con nome e danno.
- `PokemonDAO` (interfaccia) e `PokemonDAOimpl`: gestione del salvataggio/caricamento e della lista Pokémon.
- `Menu.java` e `Opzione.java`: gestione del menu di testo.
- `ChiediDati.java` (non mostrata): utility per leggere input da console.

## Come usare
1. Compila i codici sorgenti ed esegui Main.
2. Scegli se caricare un salvataggio esistente o crearne uno nuovo.
3. Inserisci il nome del file di salvataggio (senza estensione).
4. Usa il menu per aggiungere, rimuovere, mostrare, cercare Pokémon o salvare i dati.
5. Esci dall'applicazione scegliendo l'opzione 0 (salverà automaticamente).

## Requisiti
- Java 8 o superiore.

## Note
- Se il file di salvataggio specificato non esiste, verrà creato un nuovo salvataggio.
- Il salvataggio avviene tramite serializzazione Java in un file `.dat`.
- Sono supportati solo Pokémon di tipo Fuoco, Acqua e Erba.


Di seguito il diagramma UML della classe Abstract Pokemon e delle tre classi concrete: Acqua, Fuoco, Erba.
![image](https://github.com/user-attachments/assets/440cc382-f5a0-4c30-8a11-ad01b0ad42cd)

Di seguito il diagramma UML del pattern DAO creato.
![image](https://github.com/user-attachments/assets/995da578-53b9-4a68-a88b-21f30e9ebd17)

Di seguito il diagramma UML della classe Attacco.
![image](https://github.com/user-attachments/assets/cbdfea78-e74b-43ae-98df-5927dcc534d8)

Di seguito il diagramma UML della classe Menu.
![image](https://github.com/user-attachments/assets/a7ef2fb3-669c-4d09-b636-be088d3eb747)

Di seguito il diagramma UML della classe Opzione.
![image](https://github.com/user-attachments/assets/8c8b0027-ba7b-4f37-b126-04bf17c0ea52)

---

Autore: Riccardo Costantini e Alessandro Contri
Data: 28 Maggio 2025 
