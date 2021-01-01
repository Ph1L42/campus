package campus;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoteTest {

  @Test
  public void test() {
    assertEquals("toString von " + Note.class.getName() + " arbeitet falsch",
        "2,7", Note.N2_7.toString());

    double[] numVals = { 1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0,
        5.0 };

    for (Note n : Note.values()) {
      assertEquals("Falscher numerischer Wert für Note " + n.toString(),
          numVals[n.ordinal()], n.getWert(), 1e-9);
    }
  }
}
