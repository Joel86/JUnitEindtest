package be.vdab.valueobjects;

import java.util.HashSet;
import java.util.Set;

public class Persoon {
	private String[] voornamen;
	public Persoon(String[] voornamen) {
		setVoornamen(voornamen);
	}
	public void setVoornamen(String[] voornamen) {
		if(voornamen == null || voornamen.length == 0) {
			throw new IllegalArgumentException("Voornamen mag niet leeg of null zijn");
		}
		Set<String> voornamenSet = new HashSet<>();
		for(String voornaam : voornamen) {
			if( voornaam == null || voornaam.trim().isEmpty()) {
				throw new IllegalArgumentException("Een voornaam moet minstens één "
						+ "niet-blanco teken bevatten en mag niet null zijn");
			}
			if(!voornamenSet.add(voornaam.toLowerCase())) {
				throw new IllegalArgumentException("Een persoon mag niet twee keer "
						+ "dezelfde voornaam hebben");
			}
		}
		this.voornamen = voornamen;
	}
	@Override
	public String toString() {
		return String.join(" ", voornamen);
	}
}
