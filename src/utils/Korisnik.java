package utils;

public class Korisnik {

	int IDKorisnika;
	String User;
	String Pass;
	String Ime;
	String Prezime;
	String Tip;
	
	public Korisnik() {
		
	}
	
	public int getIDKorisnika() {
		return IDKorisnika;
	}
	public void setIDKorisnika(int iDKorisnika) {
		IDKorisnika = iDKorisnika;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getTip() {
		return Tip;
	}
	public void setTip(String tip) {
		Tip = tip;
	}
}
