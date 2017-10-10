package be.vdab.valueobjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersoonTest {

	@Test(expected = IllegalArgumentException.class)
	public void persoonZonderVoornaamIsVerkeerd() {
		new Persoon(new String[] {});
	}
	@Test(expected = IllegalArgumentException.class)
	public void persoonMet2DezelfdeVoornamenIsVerkeerd() {
		new Persoon(new String[] {"Koen", "Joris", "Koen"});
	}
	@Test(expected = IllegalArgumentException.class)
	public void persoonMet2DezelfdeVoornamenIgnoreCaseIsVerkeerd() {
		new Persoon(new String[] {"Koen", "Joris", "koen"});
	}
	@Test(expected = IllegalArgumentException.class)
	public void persoonMetEenBlancoEersteVoornaamIsVerkeerd() {
		new Persoon(new String[] {"  ", "Koen", "Karel"});
	}
	@Test(expected = IllegalArgumentException.class)
	public void persoonMetEenBlancoLaatsteVoornaamIsVerkeerd() {
		new Persoon(new String[] {"Koen", "Karel", "   "});
	}
	@Test(expected = IllegalArgumentException.class)
	public void voornaamNullIsVerkeerd() {
		new Persoon(new String[] {"Koen", null});
	}
	@Test(expected = IllegalArgumentException.class)
	public void persoonMetNullIsVerkeerd() {
		new Persoon(null);
	}
	@Test
	public void eenJuistePersoonMet5Voornamen() {
		new Persoon(new String[] {"Karel", "Koen", "Elise", "Joris", "Jos"});
	}
	@Test
	public void eenJuistePersoonMet1Voornaam() {
		new Persoon(new String[] {"Koen"});
	}
	@Test
	public void toStringMoetAlleVoornamenTeruggevenInJuisteVolgorde() {
		String voornamen = "Karel Koen Elise Joris Jos";
		assertEquals(voornamen, new Persoon(voornamen.split(" ")).toString());
	}
}
