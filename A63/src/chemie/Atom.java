package chemie;

public class Atom {




    // final hier , weil sich das Element nicht aendern soll.
    // Ein Atom ist von einem bestimmten Element (Typ): es hat also eine Klassenvariable
    // vom Typ Element mit dem Namen element
    private final Element element;

    //getter für Element
    public Element getElement() {
        return element;
    }

    //Atom mit Liste von bindnungen
    private Atom[] bindungen = new Atom[100];
    //private LinkedList<Atom> bindungen = new LinkedList<>();

    //Konstruktor für Element
    public Atom(Element element) {
        this.element = element;
    }

    //Methode, die in die Liste bindungen in das Atom a einträgt
    public void addBindungen(Atom a) {
        for (int i = 0; i < this.bindungen.length; i++) {

            if (this.bindungen[i] == null) {
                this.bindungen[i] = a;
                break;
            }

        }
        for (int i = 0; i < a.bindungen.length; i++) {

            if (a.bindungen[i] == null) {
                a.bindungen[i] = this;
                break;
            }

        }
    }


}
