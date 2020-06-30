package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

import com.sun.imageio.stream.StreamCloser.CloseAction;

import application.Konekcija_Baza;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Apotekar_Izmena;
import model.Apotekar_Prodaja;
import model.Apotekar_Lekovi;
import model.Login_unos;
import model.Login_unos.TXTLozinka;
import model.Login_unos.TXTUser;
import utils.Lek;


public class Apotekar_Dodavanje extends JFrame {
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3691852095320419820L;
	
	
		Color col = new Color(29, 189, 78);
		Color colPolje = new Color(29, 170, 78);
		
		JTextField txtIme=new JTextField();
		JTextField txtSifra=new JTextField();
		JTextField Proizvodjac = new JTextField();
		JTextField Cena = new JTextField();
		JButton dodajLek = new JButton("Dodaj lek");
		JCheckBox da = new JCheckBox();
	    JCheckBox ne = new JCheckBox();
	    JLabel lblNaslov = new JLabel("Dodavanje Leka");
	    
	    Konekcija_Baza conn = new Konekcija_Baza();
		
	public Apotekar_Dodavanje() throws IOException  {
		
		
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
		 header.setBackground(new Color(29, 189, 78));
		 header.setPreferredSize(new Dimension(800, 80));
		 
		 BoxLayout box=new BoxLayout(header, BoxLayout.X_AXIS);
		 header.setLayout(box);
		 
		 BufferedImage slika = ImageIO.read(new File("externi_resursi/Apoteka.jpg"));
		 JLabel apoteka = new JLabel(new ImageIcon(slika));
		 apoteka.setPreferredSize(new Dimension(150, 50));
		 
		 JLabel ime = new JLabel("Apotekar");
		 ime.setFont(new Font("Montserrat", Font.ITALIC, 30));
		 ime.setSize(new Dimension(150, 50));
		 
		 header.add(apoteka, new FlowLayout(FlowLayout.LEFT));
		 header.add(Box.createHorizontalStrut(180));
		 header.add(ime);
		 
		 add(header, BorderLayout.NORTH);
		 
		 
		 JPanel meni = new JPanel();
		 BoxLayout box3=new BoxLayout(meni, BoxLayout.Y_AXIS);
		 meni.setLayout(box3);
		 meni.setPreferredSize(new Dimension(220, 300));
		 meni.setBackground(new Color(29, 189, 78));
		 
		 
		 
		 JPanel polje1 = new JPanel();
		 polje1.setPreferredSize(new Dimension(200, 40));
		 polje1.setBackground(col);
		 JButton dug1 = new JButton("Lekovi");
			dug1.setPreferredSize(new Dimension(200, 40));
			dug1.setMinimumSize(new Dimension(300, 150));
			dug1.setBackground(colPolje);
			dug1.setForeground(new Color(0, 0, 0));
			dug1.addMouseListener(new Klik_Lekovi2());
			dug1.setFont(new Font("Montserrat", Font.ITALIC, 20));
			
		JPanel polje2 = new JPanel();
		polje2.setPreferredSize(new Dimension(200, 40));
		polje2.setBackground(col);
		JButton dug2 = new JButton("Prodaja Lekova");
		dug2.setPreferredSize(new Dimension(200, 40));
		dug2.setMinimumSize(new Dimension(300, 150));
		dug2.setBackground(colPolje);
		dug2.setForeground(new Color(0, 0, 0));
		dug2.addMouseListener(new Klik_Lekovi1());
		dug2.setFont(new Font("Montserrat", Font.ITALIC, 20));
		
		JPanel polje3 = new JPanel();
		polje3.setPreferredSize(new Dimension(200, 40));
		polje3.setBackground(col);
		JButton dug3 = new JButton("Dodavanje Lekova");
		dug3.setPreferredSize(new Dimension(200, 40));
		dug3.setMinimumSize(new Dimension(300, 150));
		dug3.setBackground(colPolje);
		dug3.setForeground(new Color(255, 255, 255));
		dug3.setFont(new Font("Montserrat", Font.ITALIC, 20));
		
		
		JPanel polje4 = new JPanel();
		polje4.setPreferredSize(new Dimension(200, 40));
		polje4.setBackground(col);
		JButton dug4 = new JButton("Izmena Lekova");
		dug4.setPreferredSize(new Dimension(200, 40));
		dug4.setMinimumSize(new Dimension(300, 150));
		dug4.setBackground(colPolje);
		dug4.setForeground(new Color(0, 0, 0));
		dug4.setFont(new Font("Montserrat", Font.ITALIC, 20));
		dug4.addMouseListener(new Klik_Lekovi3());
		
		
		JPanel polje5 = new JPanel();
		polje5.setPreferredSize(new Dimension(200, 40));
		polje5.setBackground(col);
		JButton dug5 = new JButton("Odjava");
		dug5.setPreferredSize(new Dimension(200, 40));
		dug5.setMinimumSize(new Dimension(300, 150));
		dug5.setBackground(colPolje);
		dug5.setForeground(new Color(0, 0, 0));
		dug5.setFont(new Font("Montserrat", Font.ITALIC, 20));
		dug5.addMouseListener(new Klik_Lekovi4());
		 
		 
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
	
	     lblNaslov.setFont(new Font("Montserrat", Font.ITALIC, 28));
	     lblNaslov.setPreferredSize(new Dimension(300,30));
	     
	     panNaslov.add(Box.createHorizontalStrut(150)); 
	     panNaslov.add(lblNaslov);
		 
		 JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 panIme.setBackground(new Color(255, 255, 255));

	        
	     txtIme.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     txtIme.setPreferredSize(new Dimension(250,30));
	     
	     JLabel lblIme = new JLabel("Ime Leka:");
	     lblIme.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblIme.setPreferredSize(new Dimension(150,30));
	     
	     panIme.add(Box.createHorizontalStrut(20)); 
	     panIme.add(lblIme);
	     panIme.add(Box.createHorizontalStrut(70)); 
	     panIme.add(txtIme);
	     
	       
	     JPanel panSifra=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panSifra.setBackground(new Color(255, 255, 255));
	     
	     JLabel lblSifra = new JLabel("Sifra:");
	     lblSifra.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblSifra.setPreferredSize(new Dimension(150,30));
	        
	       
	     txtSifra.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     txtSifra.setPreferredSize(new Dimension(250,30));
	     
	     panSifra.add(Box.createHorizontalStrut(20));
	     panSifra.add(lblSifra);
	     panSifra.add(Box.createHorizontalStrut(70)); 
	     panSifra.add(txtSifra);
	     
	     //
	     
	     JPanel panProizvodjac=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panProizvodjac.setBackground(new Color(255, 255, 255));

	        
	     Proizvodjac.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     Proizvodjac.setPreferredSize(new Dimension(250,30));
	     
	     JLabel lblProizvodjac = new JLabel("Proizvodjac:");
	     lblProizvodjac.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblProizvodjac.setPreferredSize(new Dimension(150,30));
	     
	     panProizvodjac.add(Box.createHorizontalStrut(20)); 
	     panProizvodjac.add(lblProizvodjac);
	     panProizvodjac.add(Box.createHorizontalStrut(70)); 
	     panProizvodjac.add(Proizvodjac);
	     
	     //
	     
	     JPanel panCena=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panCena.setBackground(new Color(255, 255, 255));

	        
	     Cena.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     Cena.setPreferredSize(new Dimension(250,30));
	     
	     JLabel lblCena = new JLabel("Cena:");
	     lblCena.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblCena.setPreferredSize(new Dimension(150,30));
	     
	     panCena.add(Box.createHorizontalStrut(20)); 
	     panCena.add(lblCena);
	     panCena.add(Box.createHorizontalStrut(70)); 
	     panCena.add(Cena);
	     
	     //
	     
	     JPanel panRecept=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     panRecept.setBackground(new Color(255, 255, 255));

	        
	     
	     da.setBackground(new Color(255, 255, 255));
	     da.addMouseListener(new Check_Da());
	     ne.setBackground(new Color(255, 255, 255));
	     ne.addMouseListener(new Check_Ne());
	     
	     JLabel lblRecept = new JLabel("Recept:");
	     lblRecept.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblRecept.setPreferredSize(new Dimension(150,30));
	     
	     JLabel lblDa = new JLabel("Da");
	     lblDa.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblDa.setPreferredSize(new Dimension(40,30));
	     
	     JLabel lblNe = new JLabel("Ne");
	     lblNe.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     lblNe.setPreferredSize(new Dimension(40,30));
	     
	     panRecept.add(Box.createHorizontalStrut(20)); 
	     panRecept.add(lblRecept);
	     panRecept.add(Box.createHorizontalStrut(100)); 
	     panRecept.add(da);
	     panRecept.add(lblDa);
	     panRecept.add(Box.createHorizontalStrut(50));
	     panRecept.add(ne);
	     panRecept.add(lblNe);
	     
	     
	     //
	     
	     JPanel panDodaj=new JPanel();
	     panDodaj.setBackground(new Color(255, 255, 255));
	     dodajLek.setPreferredSize(new Dimension(200, 50));
	     dodajLek.setBackground(col);
	     dodajLek.addMouseListener(new Dodaj_Lek());
	     dodajLek.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     
	     panDodaj.add(dodajLek);
	     
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
				
			
			if(txtIme.getText() != null && txtSifra.getText() != null && Proizvodjac.getText() != null &&
					Cena.getText() != null && (da.isSelected() || ne.isSelected())) {
			Lek l_novi = new Lek();
			l_novi.setIDLeka(conn.Lekovi().get(conn.Lekovi().size()-1).getIDLeka() + 1);
			l_novi.setSifraLeka(txtSifra.getText());
			l_novi.setImeLeka(txtIme.getText());
			l_novi.setProizvodjac(Proizvodjac.getText());
			if(da.isSelected()) {
				l_novi.setRecept("Da");
				}
				else {
					l_novi.setRecept("Ne");
				}
			int jml = Integer.parseInt(Cena.getText());
			l_novi.setCena(jml);
			conn.DodajLek(l_novi);
			Dodaj_Lek_Dialog dialog = new Dodaj_Lek_Dialog();
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(lblNaslov);
			txtIme.setText(null);
			txtSifra.setText(null);
			Proizvodjac.setText(null);
			Cena.setText(null);
			da.setSelected(false);
			ne.setSelected(false);
			}
			else {
				Dodaj_Lek_Greska greska = new Dodaj_Lek_Greska();
				greska.setVisible(true);
				greska.setLocationRelativeTo(lblNaslov);
			}
			}
			catch(Exception eX) {
				Dodaj_Lek_Greska greska = new Dodaj_Lek_Greska();
				greska.setVisible(true);
				greska.setLocationRelativeTo(lblNaslov);
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
			if(ne.isSelected()) {
			ne.setSelected(false);
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
			if(da.isSelected()) {
				da.setSelected(false);
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
	
	public class Klik_Lekovi1 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			
			Apotekar_Prodaja ap;
			try {
				ap = new Apotekar_Prodaja();
				ap.setVisible(true);
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
	
	public class Klik_Lekovi2 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Apotekar_Lekovi al;
			try {
				al = new Apotekar_Lekovi();
				al.setVisible(true);
				setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
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
	
	public class Klik_Lekovi3 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Apotekar_Izmena ai;
			try {
				ai = new Apotekar_Izmena();
				ai.setVisible(true);
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

	public class Klik_Lekovi4 implements MouseListener {

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
