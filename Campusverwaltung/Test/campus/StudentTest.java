package campus;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;

import org.junit.Test;

public class StudentTest {

  @Test
  public void testAttributes() {
    // Check whether attributes might be used as auxiliary variables
    int nrStrings = 0;
    int nrInts = 0;
    int nrStudiengang = 0;
    int nrLinkedLists = 0;
    Field[] fields = Student.class.getDeclaredFields();

    // Check for five attributes
    assertEquals("Falsche Zahl von Attributen in " + Student.class.getName(), 5,
        fields.length);

    // Check types
    for (Field field : fields) {
      field.setAccessible(true);
      if (field.getType().equals(String.class)) {
        nrStrings++;
      } else if (field.getType().equals(int.class)) {
        nrInts++;
      } else if (field.getType().equals(Studiengang.class)) {
        nrStudiengang++;
      } else if (field.getType().equals(LinkedList.class)) {
        nrLinkedLists++;
        ParameterizedType listType = (ParameterizedType) field
            .getGenericType();
        assertEquals(
            "LinkedList '" + field.getName()
                + "' sollte mit Pruefung parametrisiert sein",
            Pruefung.class, listType.getActualTypeArguments()[0]);
      }
    }
    assertEquals("Student sollte genau zwei String-Attribut besitzen", 2,
        nrStrings);
    assertEquals("Student sollte genau ein int-Attribut besitzen", 1, nrInts);
    assertEquals("Student sollte genau ein Studiengang-Attribut besitzen", 1,
        nrStudiengang);
    assertEquals("Student sollte genau ein LinkedList-Attribut besitzen", 1,
        nrLinkedLists);
  }

  @Test
  public void test() {
    Student s = new Student("Ellen", "Salmon", 678542, Studiengang.WINF);

    assertEquals("Durchschnittsnotenberechnung falsch", -1.0,
        s.durchschnittsnote(), 1e-9);

    String ziel1 = "Name: Salmon, Ellen\n" + "Matrikelnummer: 00678542\n"
        + "Studiengang: Wirtschaftsinformatik\n";
    assertEquals("toString von " + Student.class.getName() + " arbeitet falsch",
        ziel1, s.toString());

    s.pruefungHinzufuegen(Modul.MATH, Note.N2_0);
    s.pruefungHinzufuegen(Modul.GWI, Note.N1_7);

    assertEquals("Falsche Matrikelnummer", 678542L, s.getMatrikelnummer());
    assertEquals("Durchschnittsnotenberechnung falsch", 1.85,
        s.durchschnittsnote(), 1e-9);

    s.pruefungHinzufuegen(Modul.PJ1, Note.N1_3);

    String ziel2 = "Name: Salmon, Ellen\n" + "Matrikelnummer: 00678542\n"
        + "Studiengang: Wirtschaftsinformatik\n" + "\n"
        + "Durchschnittsnote: 1,67\n" + "\n" + "Mathematik: 2,0\n"
        + "Grundlagen der Wirtschaftsinformatik: 1,7\n"
        + "Programmierung in Java 1: 1,3\n";

    assertEquals("toString von " + Student.class.getName() + " arbeitet falsch",
        ziel2, s.toString());
  }
}
