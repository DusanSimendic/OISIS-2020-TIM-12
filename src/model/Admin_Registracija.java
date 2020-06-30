package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import application.Konekcija_Baza;
import model.Apotekar_Dodavanje.Check_Da;
import model.Apotekar_Dodavanje.Check_Ne;
import model.Apotekar_Dodavanje.Dodaj_Lek;
import utils.Korisnik;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Admin_Registracija extends JFrame {
	
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -131149905198311973L;
	
		Color col = new Color(255, 134, 123);
		Color colPolje = new Color(255, 178, 171);
		
		JTextField txtUser=new JTextField();
		JTextField txtLozinka=new JTextField();
		JTextField txtImeKor = new JTextField();
		JTextField txtPreKor = new JTextField();
		JButton dodajKorisnika = new JButton("Dodaj Korisnika");
		JCheckBox lekar = new JCheckBox();
	    JCheckBox apotekar = new JCheckBox();
	    JLabel lblNaslov2 = new JLabel("Registracija");
	    
	    Konekcija_Baza conn = new Konekcija_Baza();
		
	public Admin_Registracija() throws IOException  {
		
		
		 setTitle("Apoteka 12");
		 setSize(800,490);
		 setLocationRelativeTo(null);
		 setMaximumSize(new Dimension(810,495));
		 setMinimumSize(new Dimension(700,400));
		 setBackground(col);
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 setVisible(true);
		 setLayout(new BorderLayout());
		 
		 JPanel mid = new JPanel();
		 mid.setBackground(col);
		 add(mid, BorderLayout.EAST);
		 
		 JPanel mid2 = new JPanel();
		 mid2.setBackground(col);
		 add(mid2, BorderLayout.SOUTH);
		 
		 JPanel header = new JPanel();
		 header.setBackground(col);
		 header.setPreferredSize(new Dimension(800, 80));
		 
		 BoxLayout box=new BoxLayout(header, BoxLayout.X_AXIS);
		 header.setLayout(box);
		 
		 BufferedImage slika = ImageIO.read(new File("externi_resursi/Admin.jpg"));
		 JLabel apoteka = new JLabel(new ImageIcon(slika));
		 apoteka.setPreferredSize(new Dimension(150, 50));
		 
		 JLabel ime = new JLabel("Administrator");
		 ime.setFont(new Font("Montserrat", Font.ITALIC, 30));
		 ime.setSize(new Dimension(150, 50));
		 
		 header.add(apoteka, new FlowLayout(FlowLayout.LEFT));
		 header.add(Box.createHorizontalStrut(320));
		 header.add(ime);
		 
		 add(header, BorderLayout.NORTH);
		 
		 
		 JPanel meni = new JPanel();
		 BoxLayout box3=new BoxLayout(meni, BoxLayout.Y_AXIS);
		 meni.setLayout(box3);
		 meni.setPreferredSize(new Dimension(220, 300));
		 meni.setBackground(col);
		 
		 
		 
		 JPanel polje1 = new JPanel();
		 polje1.setPreferredSize(new Dimension(180, 30));
		 polje1.setBackground(col);
		 JButton dug1 = new JButton("Dodavanje_Leka");
		 dug1.setFont(new Font("Montserrat", Font.ITALIC, 16));
			dug1.setPreferredSize(new Dimension(200, 40));
			dug1.setMinimumSize(new Dimension(300, 150));
			dug1.setBackground(colPolje);
			dug1.setForeground(new Color(0, 0, 0));
			dug1.addMouseListener(new Klik_Admin_Dodavanje());
			
		JPanel polje2 = new JPanel();
		polje2.setPreferredSize(new Dimension(180, 30));
		polje2.setBackground(col);
		JButton dug2 = new JButton("Izmena_Leka");
		dug2.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug2.setPreferredSize(new Dimension(200, 40));
		dug2.setMinimumSize(new Dimension(300, 150));
		dug2.setBackground(colPolje);
		dug2.setForeground(new Color(0, 0, 0));
		dug2.addMouseListener(new Klik_Admin_Izmena());
		
		JPanel polje3 = new JPanel();
		polje3.setPreferredSize(new Dimension(180, 30));
		polje3.setBackground(col);
		JButton dug3 = new JButton("Registracija");
		dug3.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug3.setPreferredSize(new Dimension(200, 40));
		dug3.setMinimumSize(new Dimension(300, 150));
		dug3.setBackground(colPolje);
		dug3.setForeground(new Color(255, 255, 255));
		
		
		JPanel polje4 = new JPanel();
		polje4.setPreferredSize(new Dimension(180, 30));
		polje4.setBackground(col);
		JButton dug4 = new JButton("Prikaz Korisnika");
		dug4.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug4.setPreferredSize(new Dimension(200, 40));
		dug4.setMinimumSize(new Dimension(300, 150));
		dug4.setBackground(colPolje);
		dug4.setForeground(new Color(0, 0, 0));
		dug4.addMouseListener(new Klik_Admin_Prikaz());
		
		JPanel polje5 = new JPanel();
		polje5.setPreferredSize(new Dimension(180, 30));
		polje5.setBackground(col);
		JButton dug5 = new JButton("Kreriranje Izvestaja");
		dug5.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug5.setPreferredSize(new Dimension(200, 40));
		dug5.setMinimumSize(new Dimension(300, 150));
		dug5.setBackground(colPolje);
		dug5.setForeground(new Color(0, 0, 0));
		dug5.addMouseListener(new Klik_Admin_Izvestaj());
		
		JPanel polje6 = new JPanel();
		polje6.setPreferredSize(new Dimension(180, 30));
		polje6.setBackground(col);
		JButton dug6 = new JButton("Logicko Brisanje");
		dug6.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug6.setPreferredSize(new Dimension(200, 40));
		dug6.setMinimumSize(new Dimension(300, 150));
		dug6.setBackground(colPolje);
		dug6.setForeground(new Color(0, 0, 0));
		dug6.addMouseListener(new Klik_Admin_Brisanje());
		
		JPanel polje7 = new JPanel();
		polje7.setPreferredSize(new Dimension(180, 30));
		polje7.setBackground(col);
		JButton dug7 = new JButton("Odjava");
		dug7.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug7.setPreferredSize(new Dimension(200, 40));
		dug7.setMinimumSize(new Dimension(300, 150));
		dug7.setBackground(colPolje);
		dug7.setForeground(new Color(0, 0, 0));
		dug7.addMouseListener(new Klik_Odjava());
		
		 
		 
		 polje1.add(dug1);
		 meni.add(polje1);
		 meni.add(Box.createVerticalStrut(5));
		 polje2.add(dug2);
		 meni.add(polje2);
		 meni.add(Box.createVerticalStrut(5)); 
		 polje3.add(dug3);
		 meni.add(polje3);
		 meni.add(Box.createVerticalStrut(5)); 
		 polje4.add(dug4);
		 meni.add(polje4);
		 meni.add(Box.createVerticalStrut(5)); 
		 polje5.add(dug5);
		 meni.add(polje5);
		 meni.add(Box.createVerticalStrut(5)); 
		 polje6.add(dug6);
		 meni.add(polje6);
		 meni.add(Box.createVerticalStrut(5)); 
		 polje7.add(dug7);
		 meni.add(polje7);
		 meni.add(Box.createVerticalStrut(5)); 

		 
		 add(meni, BorderLayout.WEST);
		 
		 JPanel prozor = new JPanel();
		 BoxLayout box4=new BoxLayout(prozor, BoxLayout.Y_AXIS);
		 prozor.setLayout(box4);
		 prozor.setPreferredSize(new Dimension(450, 280));
		 prozor.setBackground(col);
		 
		 JPanel glavniProzor = new JPanel();
		 glavniProzor.setBackground(new Color(255, 255, 255));
		 BoxLayout boxGlavni=new BoxLayout(glavniProzor, BoxLayout.Y_AXIS);
		 glavniProzor.setLayout(boxGlavni);
		 
		 JPanel panNaslov=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 panNaslov.setBackground(new Color(255, 255, 255));
	
	     lblNaslov2.setFont(new Font("Montserrat", Font.ITALIC, 28));
	     lblNaslov2.setPreferredSize(new Dimension(300,30));
	     
	     panNaslov.add(Box.createHorizontalStrut(150)); 
	     panNaslov.add(lblNaslov2);
		 
		 JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 panIme.setBackground(new Color(255, 255, 255));

	        
	     txtUser.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     txtUser.setPreferredSize(new Dimension(250,30));
	     
	     JLabel lblIme = new JLabel("Korisnicko Ime:");
	     lblIme.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblIme.setPreferredSize(new Dimension(150,30));
	     
	     panIme.add(Box.createHorizontalStrut(20)); 
	     panIme.add(lblIme);
	     panIme.add(Box.createHorizontalStrut(70)); 
	     panIme.add(txtUser);
	     
	       
	     JPanel panSifra=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panSifra.setBackground(new Color(255, 255, 255));
	     
	     JLabel lblSifra = new JLabel("Lozinka:");
	     lblSifra.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblSifra.setPreferredSize(new Dimension(150,30));
	        
	       
	     txtLozinka.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     txtLozinka.setPreferredSize(new Dimension(250,30));
	     
	     panSifra.add(Box.createHorizontalStrut(20));
	     panSifra.add(lblSifra);
	     panSifra.add(Box.createHorizontalStrut(70)); 
	     panSifra.add(txtLozinka);
	     
	     //
	     
	     JPanel panProizvodjac=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panProizvodjac.setBackground(new Color(255, 255, 255));

	        
	     txtImeKor.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     txtImeKor.setPreferredSize(new Dimension(250,30));
	     
	     JLabel lblProizvodjac = new JLabel("Ime:");
	     lblProizvodjac.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblProizvodjac.setPreferredSize(new Dimension(150,30));
	     
	     panProizvodjac.add(Box.createHorizontalStrut(20)); 
	     panProizvodjac.add(lblProizvodjac);
	     panProizvodjac.add(Box.createHorizontalStrut(70)); 
	     panProizvodjac.add(txtImeKor);
	     
	     //
	     
	     JPanel panCena=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panCena.setBackground(new Color(255, 255, 255));

	        
	     txtPreKor.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     txtPreKor.setPreferredSize(new Dimension(250,30));
	     
	     JLabel lblCena = new JLabel("Prezime:");
	     lblCena.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblCena.setPreferredSize(new Dimension(150,30));
	     
	     panCena.add(Box.createHorizontalStrut(20)); 
	     panCena.add(lblCena);
	     panCena.add(Box.createHorizontalStrut(70)); 
	     panCena.add(txtPreKor);
	     
	     //
	     
	     JPanel panRecept=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panRecept.setBackground(new Color(255, 255, 255));

	        
	     
	     apotekar.setBackground(new Color(255, 255, 255));
	     apotekar.addMouseListener(new Check_Da());
	     lekar.setBackground(new Color(255, 255, 255));
	     lekar.addMouseListener(new Check_Ne());
	     
	     JLabel lblRecept = new JLabel("Tip korisnika:");
	     lblRecept.setFont(new Font("Montserrat", Font.ITALIC, 19));
	     lblRecept.setPreferredSize(new Dimension(150,30));
	     
	     JLabel lblDa = new JLabel("Apotekar");
	     lblDa.setFont(new Font("Montserrat", Font.ITALIC, 14));
	     lblDa.setPreferredSize(new Dimension(60,30));
	     
	     JLabel lblNe = new JLabel("Lekar");
	     lblNe.setFont(new Font("Montserrat", Font.ITALIC, 16));
	     lblNe.setPreferredSize(new Dimension(40,30));
	     
	     panRecept.add(Box.createHorizontalStrut(20)); 
	     panRecept.add(lblRecept);
	     panRecept.add(Box.createHorizontalStrut(100)); 
	     panRecept.add(apotekar);
	     panRecept.add(lblDa);
	     panRecept.add(Box.createHorizontalStrut(50));
	     panRecept.add(lekar);
	     panRecept.add(lblNe);
	     
	     
	     //
	     
	     JPanel panDodaj=new JPanel();
	     panDodaj.setBackground(new Color(255, 255, 255));
	     dodajKorisnika.setPreferredSize(new Dimension(200, 50));
	     dodajKorisnika.setBackground(col);
	     dodajKorisnika.addMouseListener(new Dodaj_Lek());
	     dodajKorisnika.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     
	     panDodaj.add(dodajKorisnika);
	     
	     glavniProzor.add(panNaslov);
	     glavniProzor.add(Box.createVerticalStrut(15));
	     glavniProzor.add(panIme);
	     glavniProzor.add(panSifra);
	     glavniProzor.add(panProizvodjac);
	     glavniProzor.add(panCena);
	     glavniProzor.add(panRecept);
	     glavniProzor.add(panDodaj);
	     glavniProzor.add(Box.createVerticalStrut(15));
		 
		 
		 prozor.add(glavniProzor);
		 add(prozor, BorderLayout.CENTER);

	}
	
	
	
	public class Dodaj_Lek implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
			if(txtUser.getText() != null && txtLozinka.getText() != null && txtImeKor.getText() != null &&
					txtPreKor.getText() != null && (apotekar.isSelected() || lekar.isSelected())) {
			Korisnik k_reg = new Korisnik();
			k_reg.setIDKorisnika(conn.Korisnici().get(conn.Korisnici().size()-1).getIDKorisnika() + 1);
			k_reg.setUser(txtUser.getText());
			k_reg.setPass(txtLozinka.getText());
			k_reg.setIme(txtImeKor.getText());
			k_reg.setPrezime(txtPreKor.getText());
			if(apotekar.isSelected()) {
			k_reg.setTip("Apotekar");
			}
			else {
				k_reg.setTip("Lekar");
			}
			conn.DodajKorisnika(k_reg);
			Dodaj_Kor_Dialog dialog = new Dodaj_Kor_Dialog();
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(lblNaslov2);
			txtUser.setText(null);
			txtLozinka.setText(null);
			txtImeKor.setText(null);
			txtPreKor.setText(null);
			apotekar.setSelected(false);
			lekar.setSelected(false);
			
			}
			else {
				Dodaj_Lek_Greska greska = new Dodaj_Lek_Greska();
				greska.setVisible(true);
				greska.setLocationRelativeTo(lblNaslov2);
			}
			}
			catch(Exception eX) {
				Dodaj_Lek_Greska greska = new Dodaj_Lek_Greska();
				greska.setVisible(true);
				greska.setLocationRelativeTo(lblNaslov2);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Check_Da implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(lekar.isSelected()) {
			lekar.setSelected(false);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
	public class Check_Ne implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(apotekar.isSelected()) {
				apotekar.setSelected(false);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
	public class Klik_Admin_Dodavanje implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Admin_Dodavanje_Leka dodaj;
			try {
				dodaj = new Admin_Dodavanje_Leka();
				dodaj.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Klik_Admin_Izmena implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Admin_Izmena_Leka izmena;
			try {
				izmena = new Admin_Izmena_Leka();
				izmena.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public class Klik_Admin_Izvestaj implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Admin_Izvestaj izvestaj;
			try {
				izvestaj = new Admin_Izvestaj();
				izvestaj.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Klik_Admin_Prikaz implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Admin_Prikaz prikaz;
			try {
				prikaz = new Admin_Prikaz();
				prikaz.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Klik_Admin_Brisanje implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Admin_Brisanje brisanje;
			try {
				brisanje = new Admin_Brisanje();
				brisanje.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Klik_Odjava implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Login_unos login;
			try {
				login = new Login_unos();
				login.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
