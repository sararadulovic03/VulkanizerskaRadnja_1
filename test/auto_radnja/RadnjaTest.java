package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	private Radnja r;
	private AutoGuma ag1,ag2;
	
	public abstract Radnja getInstance();

	@BeforeEach
	void setUp() throws Exception {
		r = getInstance();
		
		ag1 = new AutoGuma("Michelin Pilot", 16, 205, 55);
		ag2 = new AutoGuma("Sava Eskimo", 15, 195, 65);
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

	@Test
	void testDodajGumu() {
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		
		List<AutoGuma> gume = r.vratiSveGume();
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
	}
	
	@Test
	void testDodajGumuNull() {
		Exception e = assertThrows(java.lang.NullPointerException.class, () -> r.dodajGumu(null));
		assertEquals("Guma ne sme biti null", e.getMessage());
	}
	
	@Test
	void testDodajGumuVecPostoji() {
		r.dodajGumu(ag1);
		
		AutoGuma ag3 = new AutoGuma("Michelin Pilot", 16, 205, 55);
		assertThrows(java.lang.RuntimeException.class, () -> r.dodajGumu(ag3));
	}

	@Test
	void testPronadjiGumuViseGuma() {
		AutoGuma ag3 = new AutoGuma("MicHELin Pilot", 16, 205, 55);
		
		r.dodajGumu(ag1);
		r.dodajGumu(ag3);
		
		List<AutoGuma> gume = r.pronadjiGumu("michelin");
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag3));
	}
	
	@Test
	void testPronadjiGumuJednaGuma() {
		r.dodajGumu(ag1);
		List<AutoGuma> gume = r.pronadjiGumu("michelin");
		
		assertEquals(1, gume.size());
		assertTrue(gume.contains(ag1));
	}
	
	@Test
	void testPronadjiGumuPrazno() {
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		List<AutoGuma> gume = r.pronadjiGumu("modelneki");
		
		assertEquals(0, gume.size());
	}

	@Test
	void testPronadjiGumuMarkaModelNull() {
		assertNull(r.pronadjiGumu(null));
	}


	@Test
	void testVratiSveGume() {
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		
		List<AutoGuma> gume = r.vratiSveGume();
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
	}

}
