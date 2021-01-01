package campus;

import java.util.LinkedList;

public class Student {
    private String vorname;
    private String nachname;
    private int matrikelnummer;
    private Studiengang studiengang;
    LinkedList<Pruefung> pruefungen = new LinkedList<>();

    Student(String vorname, String nachname, int matrikelnummer, Studiengang studiengang) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.matrikelnummer = matrikelnummer;
        this.studiengang = studiengang;
    }

    //Methode um Prüfungen hinzuzufügen aus Fach und Note
    public void pruefungHinzufuegen(Modul fach, Note note) {
        Pruefung pruefung = new Pruefung(fach, note);
        this.pruefungen.add(pruefung);
    }


    //Getter für matrikel nummer
    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public double durchschnittsnote() {
        if (pruefungen.size() == 0) {
            return -1.0;

        }
        double gesamtnote = 0;
        for (int i = 0; i < pruefungen.size(); i++) {
            gesamtnote = gesamtnote + pruefungen.get(i).getNote().getWert();
        }

        // einfacher
//        double summeAllerNoten = 0;
//        for (Pruefung pruefung : pruefungen) {
//            summeAllerNoten += pruefung.getNote().getWert();
//        }

        double durchschnittsnote;
        durchschnittsnote = gesamtnote / pruefungen.size();
        return durchschnittsnote;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder()
                .append("Name: ")
                .append(nachname)
                .append(", ")
                .append(vorname)
                .append("\n")
                .append("Matrikelnummer: ")
                .append(String.format("%08d", matrikelnummer))
                .append("\n")
                .append("Studiengang: ")
                .append(studiengang)
                .append("\n");

        if (pruefungen.size() > 0) {
            stringbuilder.append("\n")
                    .append("Durchschnittsnote: ")
                    .append(String.format("%1.2f", durchschnittsnote()))
                    .append("\n\n");
        }


        for (Pruefung p1 : pruefungen) {
            stringbuilder.append(p1);
            stringbuilder.append("\n");

        }

        return stringbuilder.toString();
    }


    public static void main(String[] args) {
        Student s = new Student("Ellen", "Salmon", 678542, Studiengang.BW);
        s.pruefungHinzufuegen(Modul.MATH, Note.N2_0);
        s.pruefungHinzufuegen(Modul.GWI, Note.N1_7);

        System.out.println(s);


    }


}
