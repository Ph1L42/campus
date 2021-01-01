
package campus;

import static org.junit.Assert.*;

import org.junit.Test;

public class CampusManagerTest {

  @Test
  public void test() {
    CampusManager studVerwaltung = new CampusManager();

    studVerwaltung.studentEinfuegen("Claus", "Thaler", 123456,
        Studiengang.WINF);
    studVerwaltung.pruefungHinzufuegen(123456, Modul.PJ1, Note.N2_0);
    studVerwaltung.pruefungHinzufuegen(123456, Modul.GWI, Note.N2_3);

    assertFalse("Student mit Matnr. 47110815L darf sich nicht löschen lassen",
        studVerwaltung.studentLoeschen(47110815));

    studVerwaltung.studentEinfuegen("Dummy", "Dummy", 47110815,
        Studiengang.BW);

    studVerwaltung.studentEinfuegen("Inge", "Noehr", 456231, Studiengang.MT);
    studVerwaltung.pruefungHinzufuegen(456231, Modul.PJ1, Note.N2_7);
    studVerwaltung.pruefungHinzufuegen(456231, Modul.IM1, Note.N1_0);
    studVerwaltung.pruefungHinzufuegen(456231, Modul.IM2, Note.N1_0);
    studVerwaltung.pruefungHinzufuegen(456231, Modul.KON, Note.N1_0);
    studVerwaltung.pruefungHinzufuegen(456231, Modul.BS, Note.N1_0);

    assertTrue("Student mit Matnr. 47110815L muss sich löschen lassen",
        studVerwaltung.studentLoeschen(47110815));

    String ziel = "**********\n" + "Name: Thaler, Claus\n"
        + "Matrikelnummer: 00123456\n" + "Studiengang: Wirtschaftsinformatik\n"
        + "\n" + "Durchschnittsnote: 2,15\n" + "\n"
        + "Programmierung in Java 1: 2,0\n"
        + "Grundlagen der Wirtschaftsinformatik: 2,3\n" + "**********\n"
        + "**********\n" + "Name: Noehr, Inge\n" + "Matrikelnummer: 00456231\n"
        + "Studiengang: Mechatronik\n" + "\n" + "Durchschnittsnote: 1,34\n"
        + "\n" + "Programmierung in Java 1: 2,7\n"
        + "Ingenieurmathematik 1: 1,0\n" + "Ingenieurmathematik 2: 1,0\n"
        + "Konstruktion: 1,0\n" + "Betriebssysteme: 1,0\n" + "**********\n";

    assertEquals(
        "Falsche Ausgabe von toString für " + CampusManager.class.getName(),
        ziel, studVerwaltung.toString());
  }

}

