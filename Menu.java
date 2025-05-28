import java.util.Vector;

public class Menu {
    private Vector<Opzione> scelta;

    public Menu() {
        scelta = new Vector<>();
    }

    public void aggiungi(Opzione opz) {
        scelta.addElement(opz);
    }

    public void stampaMenu() {
        for (int i = 0; i < scelta.size(); i++) {
            System.out.println(scelta.elementAt(i).getDescrizione());
        }
    }
}
