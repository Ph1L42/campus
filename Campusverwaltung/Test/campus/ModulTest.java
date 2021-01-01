package campus;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModulTest {

  @Test
  public void test() {
    assertEquals("toString von " + Modul.class.getName() + " arbeitet falsch",
        "Grundlagen der Wirtschaftsinformatik", Modul.GWI.toString());
  }

}
