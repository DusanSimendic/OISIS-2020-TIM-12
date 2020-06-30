package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.BrisaniPodaci;
import utils.Korisnik;
import utils.Lek;
import utils.Recept;

public class Konekcija_Baza {
	
	public Connection myCon;
	
	public Konekcija_Baza() {
		
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String dburl = "jdbc:sqlserver://localhost:1433;databaseName=Baza;integratedSecurity=true;";
		
		try {
			myCon = DriverManager.getConnection(dburl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Korisnik> Korisnici() throws SQLException{
		
		Statement stmt= myCon.createStatement();
		 ResultSet rs=stmt.executeQuery("SELECT * FROM Korisnik");
		 
		 List<Korisnik> korisnici = new ArrayList<Korisnik>();
		 while (rs.next()){
		 int IDKorisnika=rs.getInt(1);//ili rs.getString("OZNAKA_PLANA");
		 String Username=rs.getString(2);//ili rs.getString("SIFRA_PREDMETA");
		 String Sifra = rs.getString(3);//ili rs.getString("NAZIV_PREDMETA");
		 String Ime=rs.getString(4); // ili rs.getString("TRAJE_SEMESTARA");
		 String Prezime=rs.getString(5);
		 String TipKorisnika=rs.getString(6);
		 
		 Korisnik k = new Korisnik();
		 k.setIDKorisnika(IDKorisnika);
		 k.setUser(Username);
		 k.setPass(Sifra);
		 k.setIme(Ime);
		 k.setPrezime(Prezime);
		 k.setTip(TipKorisnika);
		 
		 korisnici.add(k);// ili rs.getString("BROJ_KREDITA");
		 }
		 //obavezno je zatvaranje Statement i ResultSet objekta
		 rs.close();
		 stmt.close();
		 
		 return korisnici;
	}
	
public List<Lek> Lekovi() throws SQLException{
		
		Statement stmt= myCon.createStatement();
		 ResultSet rs=stmt.executeQuery("SELECT * FROM Lekovi");
		 
		 List<Lek> lekovi = new ArrayList<Lek>();
		 while (rs.next()){
		 int IDLeka=rs.getInt(1);//ili rs.getString("OZNAKA_PLANA");
		 String SifraLeka=rs.getString(2);//ili rs.getString("SIFRA_PREDMETA");
		 String ImeLeka = rs.getString(3);//ili rs.getString("NAZIV_PREDMETA");
		 String Proizvodjac=rs.getString(4); // ili rs.getString("TRAJE_SEMESTARA");
		 String Recept=rs.getString(5);
		 int Cena=rs.getInt(6);
		 
		 Lek l = new Lek();
		 l.setIDLeka(IDLeka);
		 l.setSifraLeka(SifraLeka);
		 l.setImeLeka(ImeLeka);
		 l.setProizvodjac(Proizvodjac);
		 l.setRecept(Recept);
		 l.setCena(Cena);
		 
		 lekovi.add(l);// ili rs.getString("BROJ_KREDITA");
		 }
		 //obavezno je zatvaranje Statement i ResultSet objekta
		 rs.close();
		 stmt.close();
		 
		 return lekovi;
	}

public List<Recept> Recepti() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	 ResultSet rs=stmt.executeQuery("SELECT * FROM Recepti");
	 
	 List<Recept> recepti = new ArrayList<Recept>();
	 while (rs.next()){
	 int SifraRecepta=rs.getInt(2);//ili rs.getString("SIFRA_PREDMETA");
	 int IDLekara = rs.getInt(3);//ili rs.getString("NAZIV_PREDMETA");
	 String JMBG=rs.getString(4); // ili rs.getString("TRAJE_SEMESTARA");
	 Date DatumIzadvanja=rs.getDate(5);
	 String Recept=rs.getString(6);
	 
	 Recept r = new Recept();
	 r.setSifraRecepta(SifraRecepta);
	 r.setIDLekara(IDLekara);
	 r.setJMBG(JMBG);
	 r.setDatumIzadvanja(DatumIzadvanja);
	 r.setRecept(Recept); 
	 
	 recepti.add(r);// ili rs.getString("BROJ_KREDITA");
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return recepti;
}

public List<BrisaniPodaci> Podaci() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	 ResultSet rs=stmt.executeQuery("SELECT * FROM BrisaniLekovi");
	 
	 List<BrisaniPodaci> podaci = new ArrayList<BrisaniPodaci>();
	 while (rs.next()){
	 int ID=rs.getInt(1);//ili rs.getString("OZNAKA_PLANA");
	 String ImeLeka=rs.getString(2);//ili rs.getString("SIFRA_PREDMETA");
	 String Proizvodjac = rs.getString(3);//ili rs.getString("NAZIV_PREDMETA");
	 String SifraLeka=rs.getString(4); // ili rs.getString("TRAJE_SEMESTARA");
	 int IDKor=rs.getInt(5);
	 
	 BrisaniPodaci p = new BrisaniPodaci();
	 p.setID(ID);
	 p.setImeLeka(ImeLeka);
	 p.setProizvodjac(Proizvodjac);
	 p.setSifraLeka(SifraLeka);
	 p.setIDKor(IDKor);
	 
	 podaci.add(p);// ili rs.getString("BROJ_KREDITA");
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return podaci;
}
	
	public void DodajKorisnika(Korisnik k) throws SQLException {
		Statement stmt= myCon.createStatement();
		String statement =  "INSERT INTO Korisnik(IDKorisnika, Username, Sifra, Ime, Prezime, TipKorisnika)"
							+ " VALUES ("+ k.getIDKorisnika()+",'"+ k.getUser()+"','"+ k.getPass()+"','"+ k.getIme()+"','"+ k.getPrezime()+"','"
								+ k.getTip()+"')";
		 stmt.executeUpdate(statement);
		 
		 
		 
		 //obavezno je zatvaranje Statement i ResultSet objekta
		 stmt.close();
	}
	
	public void DodajLek(Lek l) throws SQLException {
		Statement stmt= myCon.createStatement();
		String statement = "INSERT INTO Lekovi(IDLeka, SifraLeka, ImeLeka, Proizvodjac, Recept, Cena) "
							+ " VALUES ("+ l.getIDLeka()+",'"+ l.getSifraLeka()+"','"+ l.getImeLeka()+"','"+ l.getProizvodjac()+"','"
							+ l.getRecept()+"',"+ l.getCena()+")";
		 stmt.executeUpdate(statement);
		 
		 
		 
		 //obavezno je zatvaranje Statement i ResultSet objekta
		 stmt.close();
	}
	
	public void IzmeniLek(Lek l) throws SQLException {
		Statement stmt= myCon.createStatement();
		String statement = "UPDATE Lekovi " +
							"SET ImeLeka ='"+ l.getImeLeka()+"',Proizvodjac='"+ l.getProizvodjac()+"',Cena="
							+l.getCena() +" WHERE SifraLeka='"+ l.getSifraLeka()+"'";
		 stmt.executeUpdate(statement);
		
		 stmt.close();
	}
	
	public void UpisPodatka(BrisaniPodaci p) throws SQLException {
		Statement stmt= myCon.createStatement();
		 String statement = "INSERT INTO BrisaniLekovi(ID, ImeLeka, Proizvodjac, SifraLeka, IDKor) " +
					"VALUES ("+ p.getID()+",'"+ p.getImeLeka()+"','"+p.getProizvodjac() + "','"+ p.getSifraLeka()+ "',"+ p.getIDKor()+")";
		 stmt.executeUpdate(statement);
		 
		 stmt.close();
	}
	
	
public List<Korisnik> KorisniciIme() throws SQLException{
		
		Statement stmt= myCon.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT Ime, Prezime, TipKorisnika FROM Korisnik ORDER BY Ime ASC;");
		 
		 List<Korisnik> korisnici = new ArrayList<Korisnik>();
		 while (rs.next()){
		 String Ime=rs.getString(1); 
		 String Prezime=rs.getString(2);
		 String TipKorisnika=rs.getString(3);
		 
		 Korisnik k = new Korisnik();
		 k.setIme(Ime);
		 k.setPrezime(Prezime);
		 k.setTip(TipKorisnika);
		 
		 korisnici.add(k);
		 }
		 //obavezno je zatvaranje Statement i ResultSet objekta
		 rs.close();
		 stmt.close();
		 
		 return korisnici;
	}

public List<Korisnik> KorisniciPrezime() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT Ime, Prezime, TipKorisnika FROM Korisnik ORDER BY Prezime ASC;");
	 
	 List<Korisnik> korisnici = new ArrayList<Korisnik>();
	 while (rs.next()){
	 String Ime=rs.getString(1); 
	 String Prezime=rs.getString(2);
	 String TipKorisnika=rs.getString(3);
	 
	 Korisnik k = new Korisnik();
	 k.setIme(Ime);
	 k.setPrezime(Prezime);
	 k.setTip(TipKorisnika);
	 
	 korisnici.add(k);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return korisnici;
}

public List<Korisnik> KorisniciTip() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT Ime, Prezime, TipKorisnika FROM Korisnik ORDER BY TipKorisnika ASC;");
	 
	 List<Korisnik> korisnici = new ArrayList<Korisnik>();
	 while (rs.next()){
	 String Ime=rs.getString(1); 
	 String Prezime=rs.getString(2);
	 String TipKorisnika=rs.getString(3);
	 
	 Korisnik k = new Korisnik();
	 k.setIme(Ime);
	 k.setPrezime(Prezime);
	 k.setTip(TipKorisnika);
	 
	 korisnici.add(k);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return korisnici;
}

public List<Lek> LekIme() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT ImeLeka, SifraLeka, Proizvodjac, Recept, Cena FROM Lekovi ORDER BY ImeLeka ASC;");
	 
	 List<Lek> lekovi = new ArrayList<Lek>();
	 while (rs.next()){
	 String ImeLeka=rs.getString(1); 
	 String SifraLeka=rs.getString(2);
	 String Prozivodjac=rs.getString(3);
	 String Recept=rs.getString(4);
	 int Cena=rs.getInt(5);
	 
	 Lek l = new Lek();
	 l.setImeLeka(ImeLeka);
	 l.setSifraLeka(SifraLeka);
	 l.setProizvodjac(Prozivodjac);
	 l.setRecept(Recept);
	 l.setCena(Cena);
	 
	 lekovi.add(l);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return lekovi;
}


public List<Lek> LekCena() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT ImeLeka, SifraLeka, Proizvodjac, Recept, Cena FROM Lekovi ORDER BY Cena ASC;");
	 
	 List<Lek> lekovi = new ArrayList<Lek>();
	 while (rs.next()){
	 String ImeLeka=rs.getString(1); 
	 String SifraLeka=rs.getString(2);
	 String Prozivodjac=rs.getString(3);
	 String Recept=rs.getString(4);
	 int Cena=rs.getInt(5);
	 
	 Lek l = new Lek();
	 l.setImeLeka(ImeLeka);
	 l.setSifraLeka(SifraLeka);
	 l.setProizvodjac(Prozivodjac);
	 l.setRecept(Recept);
	 l.setCena(Cena);
	 
	 lekovi.add(l);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return lekovi;
}

public List<Lek> LekProzivodjac() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT ImeLeka, SifraLeka, Proizvodjac, Recept, Cena FROM Lekovi ORDER BY Proizvodjac ASC;");
	 
	 List<Lek> lekovi = new ArrayList<Lek>();
	 while (rs.next()){
	 String ImeLeka=rs.getString(1); 
	 String SifraLeka=rs.getString(2);
	 String Prozivodjac=rs.getString(3);
	 String Recept=rs.getString(4);
	 int Cena=rs.getInt(5);
	 
	 Lek l = new Lek();
	 l.setImeLeka(ImeLeka);
	 l.setSifraLeka(SifraLeka);
	 l.setProizvodjac(Prozivodjac);
	 l.setRecept(Recept);
	 l.setCena(Cena);
	 
	 lekovi.add(l);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return lekovi;
}

public List<Lek> PretragaIme(String s) throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT ImeLeka, SifraLeka, Proizvodjac, Recept, Cena FROM Lekovi WHERE ImeLeka LIKE"+
									"'%"+s+"%'");
	 
	 List<Lek> lekovi1 = new ArrayList<Lek>();
	 while (rs.next()){
	 String ImeLeka=rs.getString(1); 
	 String SifraLeka=rs.getString(2);
	 String Prozivodjac=rs.getString(3);
	 String Recept=rs.getString(4);
	 int Cena=rs.getInt(5);
	 
	 Lek l = new Lek();
	 l.setImeLeka(ImeLeka);
	 l.setSifraLeka(SifraLeka);
	 l.setProizvodjac(Prozivodjac);
	 l.setRecept(Recept);
	 l.setCena(Cena);
	 
	 lekovi1.add(l);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return lekovi1;
}

public List<Lek> PretragaSifra(String s) throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT ImeLeka, SifraLeka, Proizvodjac, Recept, Cena FROM Lekovi WHERE SifraLeka LIKE"+
									"'%"+s+"%'");
	 
	 List<Lek> lekovi1 = new ArrayList<Lek>();
	 while (rs.next()){
	 String ImeLeka=rs.getString(1); 
	 String SifraLeka=rs.getString(2);
	 String Prozivodjac=rs.getString(3);
	 String Recept=rs.getString(4);
	 int Cena=rs.getInt(5);
	 
	 Lek l = new Lek();
	 l.setImeLeka(ImeLeka);
	 l.setSifraLeka(SifraLeka);
	 l.setProizvodjac(Prozivodjac);
	 l.setRecept(Recept);
	 l.setCena(Cena);
	 
	 lekovi1.add(l);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return lekovi1;
}

public List<Lek> PretragaProiz(String s) throws SQLException{
	
	Statement stmt= myCon.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT ImeLeka, SifraLeka, Proizvodjac, Recept, Cena FROM Lekovi WHERE Proizvodjac LIKE"+
									"'%"+s+"%'");
	 
	 List<Lek> lekovi1 = new ArrayList<Lek>();
	 while (rs.next()){
	 String ImeLeka=rs.getString(1); 
	 String SifraLeka=rs.getString(2);
	 String Prozivodjac=rs.getString(3);
	 String Recept=rs.getString(4);
	 int Cena=rs.getInt(5);
	 
	 Lek l = new Lek();
	 l.setImeLeka(ImeLeka);
	 l.setSifraLeka(SifraLeka);
	 l.setProizvodjac(Prozivodjac);
	 l.setRecept(Recept);
	 l.setCena(Cena);
	 
	 lekovi1.add(l);
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return lekovi1;
}


public List<Recept> ReceptiSifra() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	 ResultSet rs=stmt.executeQuery("SELECT SifraRecepta, IDLekara, JMBG, DatumIzadvanja, Recept FROM Recepti ORDER BY SifraRecepta ASC;");
	 
	 List<Recept> recepti = new ArrayList<Recept>();
	 while (rs.next()){
	 int SifraRecepta=rs.getInt(1);//ili rs.getString("SIFRA_PREDMETA");
	 int IDLekara = rs.getInt(2);//ili rs.getString("NAZIV_PREDMETA");
	 String JMBG=rs.getString(3); // ili rs.getString("TRAJE_SEMESTARA");
	 Date DatumIzadvanja=rs.getDate(4);
	 String Recept=rs.getString(5);
	 
	 Recept r = new Recept();
	 r.setSifraRecepta(SifraRecepta);
	 r.setIDLekara(IDLekara);
	 r.setJMBG(JMBG);
	 r.setDatumIzadvanja(DatumIzadvanja);
	 r.setRecept(Recept);
	 
	 recepti.add(r);// ili rs.getString("BROJ_KREDITA");
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return recepti;
}

public List<Recept> ReceptiID() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	 ResultSet rs=stmt.executeQuery("SELECT SifraRecepta, IDLekara, JMBG, DatumIzadvanja, Recept FROM Recepti ORDER BY IDLekara ASC;");
	 
	 List<Recept> recepti = new ArrayList<Recept>();
	 while (rs.next()){
	 int SifraRecepta=rs.getInt(1);//ili rs.getString("SIFRA_PREDMETA");
	 int IDLekara = rs.getInt(2);//ili rs.getString("NAZIV_PREDMETA");
	 String JMBG=rs.getString(3); // ili rs.getString("TRAJE_SEMESTARA");
	 Date DatumIzadvanja=rs.getDate(4);
	 String Recept=rs.getString(5);
	 
	 Recept r = new Recept();
	 r.setSifraRecepta(SifraRecepta);
	 r.setIDLekara(IDLekara);
	 r.setJMBG(JMBG);
	 r.setDatumIzadvanja(DatumIzadvanja);
	 r.setRecept(Recept);
	 
	 recepti.add(r);// ili rs.getString("BROJ_KREDITA");
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return recepti;
}

public List<Recept> ReceptiDatum() throws SQLException{
	
	Statement stmt= myCon.createStatement();
	 ResultSet rs=stmt.executeQuery("SELECT SifraRecepta, IDLekara, JMBG, DatumIzadvanja, Recept FROM Recepti ORDER BY DatumIzadvanja ASC;");
	 
	 List<Recept> recepti = new ArrayList<Recept>();
	 while (rs.next()){
	 int SifraRecepta=rs.getInt(1);//ili rs.getString("SIFRA_PREDMETA");
	 int IDLekara = rs.getInt(2);//ili rs.getString("NAZIV_PREDMETA");
	 String JMBG=rs.getString(3); // ili rs.getString("TRAJE_SEMESTARA");
	 Date DatumIzadvanja=rs.getDate(4);
	 String Recept=rs.getString(5);
	 
	 Recept r = new Recept();
	 r.setSifraRecepta(SifraRecepta);
	 r.setIDLekara(IDLekara);
	 r.setJMBG(JMBG);
	 r.setDatumIzadvanja(DatumIzadvanja);
	 r.setRecept(Recept);
	 
	 recepti.add(r);// ili rs.getString("BROJ_KREDITA");
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return recepti;
}

public List<Recept> ReceptiPret(int s) throws SQLException{
	
	Statement stmt= myCon.createStatement();
	 ResultSet rs=stmt.executeQuery("SELECT SifraRecepta, IDLekara, JMBG, DatumIzadvanja, Recept FROM Recepti WHERE SifraRecepta LIKE"+
				"'%"+s+"%'");
	 List<Recept> recepti = new ArrayList<Recept>();
	 while (rs.next()){
	 int SifraRecepta=rs.getInt(1);//ili rs.getString("SIFRA_PREDMETA");
	 int IDLekara = rs.getInt(2);//ili rs.getString("NAZIV_PREDMETA");
	 String JMBG=rs.getString(3); // ili rs.getString("TRAJE_SEMESTARA");
	 Date DatumIzadvanja=rs.getDate(4);
	 String Recept=rs.getString(5);
	 
	 Recept r = new Recept();
	 r.setSifraRecepta(SifraRecepta);
	 r.setIDLekara(IDLekara);
	 r.setJMBG(JMBG);
	 r.setDatumIzadvanja(DatumIzadvanja);
	 r.setRecept(Recept);
	 
	 recepti.add(r);// ili rs.getString("BROJ_KREDITA");
	 }
	 //obavezno je zatvaranje Statement i ResultSet objekta
	 rs.close();
	 stmt.close();
	 
	 return recepti;
}



}
