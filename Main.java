public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nel Pokedex!");

        System.out.println("Questa applicazione salverà nella memoria di massa i dati del pokedex.");
        System.out.println("Il salvataggio si trova in questa cartella, nel formato .DAT");



        Menu menuApp = new Menu();

        Opzione opz1 = new Opzione("1","Digitare 1 per aggiungere un pokemon.");
        Opzione opz2 = new Opzione("2","Digitare 2 per togliere un pokemon.");
        Opzione opz3 = new Opzione("3","Digitare 3 per mostrare tutti i pokemon.");
        Opzione opz4 = new Opzione("4","Digitare 4 per salvare il pokedex.");
        Opzione opz0 = new Opzione("0","Digitare 0 per uscire.");
        
        menuApp.aggiungi(opz1);
        menuApp.aggiungi(opz2);
        menuApp.aggiungi(opz3);
        menuApp.aggiungi(opz4);
        menuApp.aggiungi(opz0);

        boolean uscita = false;

        do{
            System.out.println("--------------------------------------------------------------");
            menuApp.stampaMenu();
            uscita = true;
        }while(!uscita);
    }
}




fare classe Fuoco.java e Erba.java
fare salvataggi diversi