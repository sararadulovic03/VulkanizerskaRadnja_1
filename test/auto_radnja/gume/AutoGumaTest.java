package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Marka", 15, 150, 30);
		
		assertNotNull(ag);
		assertEquals("Marka", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());
		assertEquals(150, ag.getSirina());
		assertEquals(30, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Michelin Pilot");
		
		assertEquals("Michelin Pilot", ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, ()->ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelPrekratko() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setMarkaModel("ab"));
	}

	@ParameterizedTest
	@DisplayName("Testovi za precnik")
	@CsvSource({
		"13","15","22"
	})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@Test
	void testSetPrecnikVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(12));
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(23));
	}

	@ParameterizedTest
	@DisplayName("Testovi za sirinu")
	@CsvSource({
		"135","250","355"
	})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		
		assertEquals(sirina, ag.getSirina());
	}
	
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(134));
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(356));
	}

	@ParameterizedTest
	@DisplayName("Testovi za visinu")
	@CsvSource({
		"25","50","95"
	})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		
		assertEquals(visina, ag.getVisina());
	}
	
	@Test
	void testSetVisinaVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setVisina(24));
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setVisina(96));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Michelin Pilot");
		ag.setPrecnik(15);
		ag.setSirina(150);
		ag.setVisina(50);
		
		String s = ag.toString();
		
		assertTrue(s.contains("Michelin Pilot"));
		assertTrue(s.contains("15"));
		assertTrue(s.contains("150"));
		assertTrue(s.contains("50"));
	}

	@ParameterizedTest
	@DisplayName("Testovi za equals")
	@CsvSource({
		"Michelin Pilot, 15,150,50, Michelin Pilot, 15,150,50, true",
		"Michelin Pilot, 15,150,50, Marka, 15,150,50,false",
		"Michelin Pilot, 15,150,50, Michelin Pilot, 16,150,50, false",
		"Michelin Pilot, 15,150,50, Michelin Pilot, 15,151,50, false",
		"Michelin Pilot, 15,150,50, Michelin Pilot, 15,150,51, false",
		"Michelin Pilot, 15,150,50, Marka, 16,151,51, false"
	})
	void testEqualsObject(String markaModel1, int precnik1, int sirina1, int visina1,String markaModel2, int precnik2, int sirina2, int visina2, boolean jednako ) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma ag2 = new AutoGuma(markaModel2, precnik2, sirina2, visina2);
		
		assertEquals(jednako, ag.equals(ag2));
	}
	
	@Test
	void testEqualsObjectNull() {
		assertFalse(ag.equals(null));
	}
	
	@Test
	void testEqualsObjectDrugaKlasa() {
		assertFalse(ag.equals(new String()));
	}
	
	@Test
	void testEqualsObjectIstiObjekat() {
		assertTrue(ag.equals(ag));
	}

}
