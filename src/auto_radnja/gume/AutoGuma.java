package auto_radnja.gume;

/**
 * Predstavlja jednu auto gumu iz radnje.
 * 
 * Svaka auto guma ima marku i model, precnik, sirinu i visinu.
 * 
 * @author Sara
 * @version 1.0
 *
 */
public class AutoGuma {
	/**
	 * Marka i model gume kao String, sa defaultnom vrednoscu null.
	 */
	private String markaModel = null;

	/**
	 * Precnik gume kao int, inicijalizovan na -1.
	 */
	private int precnik = -1;

	/**
	 * Sirina gume kao int, inicijalizovan na -1.
	 */
	private int sirina = -1;

	/**
	 * Visina gume kao int, inicijalizovan na -1.
	 */
	private int visina = -1;

	/**
	 * Kreira objekat klase AutoGuma sa defaultnim vrednostima njegovih atributa.
	 */
	public AutoGuma() {
	}

	/**
	 * Kreira objekat klase AutoGuma i vrednosti njenih atributa postavlja na
	 * prosledjene vrednosti.
	 * 
	 * Poziva set metodu za svaki atribut cime se vrsi logicka kontrola.
	 * 
	 * @param markaModel Marka i model gume kao String.
	 * @param precnik    Precnik gume kao int.
	 * @param sirina     Sirina gume kao int.
	 * @param visina     Visina gume kao int.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume.
	 * 
	 * @return Marka i model gume kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja marku i model gume na prosledjenu vrednost.
	 * 
	 * Marka i model gume ne smeju biti null niti prazan String.
	 * 
	 * @param markaModel Novi marka i model gume.
	 * 
	 * @throws java.lang.NullPointerException Ako su prosledjeni marka i model null.
	 * @throws java.lang.IllegalArgumentException Ako su proslednjeni marka i model kraci od 3 karaktera.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume.
	 * 
	 * @return Precnik gume kao String.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume na unetu vrednost.
	 * 
	 * Prosledjena vrednost ne sme biti manja od 13 ili veca od 22
	 * 
	 * @param precnik Novi precnik gume kao int.
	 * 
	 * @throws java.lang.IllegalArgumentException Ako je prosledjeni precnik izvan dozvoljenog opsega.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume.
	 * 
	 * @return Sirina gume kao int.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu gume na unetu vrednost.
	 * 
	 * Prosledjena vrednost ne sme biti manja od 135 ili veca od 355.
	 * 
	 * @param sirina Nova sirina gume kao int.
	 * 
	 *  @throws java.lang.IllegalArgumentException Ako je prosledjena vrednost izvan dozvoljenog opsega.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visina gume kao int.
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume na unetu vrednsot.
	 * 
	 * Prosledjena vrednost ne sme biti manja od 25 ili veca od 95.
	 * 
	 * @param visina Nova visina gume kao int.
	 * 
	 * @throws java.lang.IllegalArgumentException Ako je proslednjea vrednost van dozvoljenog opsega.
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca String sa svim informacijama o gumi.
	 * 
	 * @return Podaci o gumi u formatu "AutoGuma [markaModel =##, precnik= ##, sirina=##, vidina=###]";
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve gume na osnovu marke i modela, precnika, sirine i visine.
	 * 
	 * @param obj Drugi objekat sa kojim poredimo auto gumu.
	 * 
	 * @return true - Ako su oba objekta klase auto guma i nalaze se na istoj adresi ili imaju iste vrednosti svih atributa.
	 * false = Ako je prosledjeni objekat null, objekat druge klase ili ako je iste klase a razlikuje im se bar jedna vrednost atributa.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
