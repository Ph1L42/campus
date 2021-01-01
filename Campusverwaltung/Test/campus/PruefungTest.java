package campus;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruefungTest {

  @Test
  public void test() {
    assertEquals(
        "toString von " + Pruefung.class.getName() + " arbeitet falsch",
        "Programmierung in Java 1: 2,0",
        new Pruefung(Modul.PJ1, Note.N2_0).toString());
    assertEquals(
        "toString von " + Pruefung.class.getName() + " arbeitet falsch",
        "Mathematik: 3,7", new Pruefung(Modul.MATH, Note.N3_7).toString());
  }
}
