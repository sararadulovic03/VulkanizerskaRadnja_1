package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavalja radnju u kojoj mogu da se dodaju pronalaze i pregledaju sve gume.
 * 
 * @author Sara 
 * @version 1.0
 *
 */
public interface Radnja {
	/**
	 * Dodaje prosledjenu gumu u radju.
	 * 
	 * Prosledjena guma ne sme biti null i ne sme postojati u radnji.
	 * 
	 * @param a Nova guma koju treba dodati.
	 * 
	 * @throws java.lang.NullPointerException Ako je prosledjena guma null.
	 * @throws java.lang.IllegalArgumentException Ako prosledjena guma vec postoji u prodavnici.
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazi gumu na osnovu marke i modela.
	 * 
	 * Moze se proslediti deo ili ceo naziv marke i modela
	 * 
	 * @param markaModel Ceo ili deo naziva marke i modela kao String.
	 * 
	 * @return Lista objekta klase AutoGuma koji u svom nazivu sadrze prosledjenu vrednost parametara ili prazna lista ukoliko nijedan objekat ne ispunjava kriterijum pretrage.
	 * null - ako je proslednjena vrednost parametra null.
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca listu svih guma iz prodavnice.
	 * 
	 * @return Lista guma iz prodavnice ili praznu listu ukoliko u radnji ne postoji nijedna guma
	 */
	List<AutoGuma> vratiSveGume();
}
