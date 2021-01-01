package campus;

import java.util.LinkedList;

public class CampusManager {
    LinkedList<Student> studenten = new LinkedList<>();

    public void studentEinfuegen(String nachname, String vorname, int matrikelnummer, Studiengang studiengang) {
        Student student = new Student(nachname, vorname, matrikelnummer, studiengang);
        this.studenten.add(student);
    }

    public boolean studentLoeschen(int matrikelnummer) {
        for (Student student : studenten) {
            if (student.getMatrikelnummer() == matrikelnummer) {
                studenten.remove(student);
                return true;
            }
        }
        return false;
    }

    public void pruefungHinzufuegen(int matrikelnummer, Modul fach, Note note) {
        for (Student student : studenten) {
            if (student.getMatrikelnummer() == matrikelnummer) {
                student.pruefungHinzufuegen(fach, note);
            }
        }
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();

        for (Student student : studenten) {

            stringbuilder.append("**********");
            stringbuilder.append("\n");
            stringbuilder.append(student);
            stringbuilder.append("**********");
            stringbuilder.append("\n");
        }

        return stringbuilder.toString();
    }

}

