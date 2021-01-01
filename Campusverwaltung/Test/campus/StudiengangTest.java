package campus;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudiengangTest {

  @Test
  public void test() {
    assertEquals("toString von Studiengang arbeitet falsch",
        "Betriebswirtschaftslehre", Studiengang.BW.toString());
  }

}
