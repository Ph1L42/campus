package campus;


public class Pruefung {

    private Modul fach;
    private Note note;

    public Pruefung(Modul fach, Note note) {
        this.fach = fach;
        this.note = note;
    }

    public Note getNote() {
        return note;
    }

    public Modul getFach() {
        return fach;
    }

    public String toString() {
        return fach.toString() + ": " + note.getName();
    }


}
