package utils;

import java.sql.Date;

public class Recept {
	
	int SifraRecepta;
	int IDLekara;
	String JMBG;
	Date DatumIzadvanja;
	String Recept;
	
	public Recept(){
		
	}


	public int getSifraRecepta() {
		return SifraRecepta;
	}

	public void setSifraRecepta(int sifraRecepta) {
		SifraRecepta = sifraRecepta;
	}

	public int getIDLekara() {
		return IDLekara;
	}

	public void setIDLekara(int iDLekara) {
		IDLekara = iDLekara;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public Date getDatumIzadvanja() {
		return DatumIzadvanja;
	}

	public void setDatumIzadvanja(Date datumIzadvanja) {
		DatumIzadvanja = datumIzadvanja;
	}

	public String getRecept() {
		return Recept;
	}

	public void setRecept(String recept) {
		Recept = recept;
	}

}
