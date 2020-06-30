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
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import application.Konekcija_Baza;

import utils.Korisnik;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class Admin_Prikaz extends JFrame {
	
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 9202446953706427097L;
		Color col = new Color(255, 134, 123);
		Color colPolje = new Color(255, 178, 171);
		
		Konekcija_Baza conn = new Konekcija_Baza();
		
		JButton dugIme = new JButton("Po Imenu");
		JButton dugPrezime = new JButton("Po Prezimenu");
		JButton dugTip = new JButton("Po Tipu");
		
		DefaultTableModel dtm = new DefaultTableModel();
		List<Korisnik> korisnici = null;
		
		
		
	public Admin_Prikaz() throws IOException  {
		
		
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
		dug3.setForeground(new Color(0, 0, 0));
		dug3.addMouseListener(new Klik_Admin_Registracija());
		
		
		JPanel polje4 = new JPanel();
		polje4.setPreferredSize(new Dimension(180, 30));
		polje4.setBackground(col);
		JButton dug4 = new JButton("Prikaz Korisnika");
		dug4.setFont(new Font("Montserrat", Font.ITALIC, 16));
		dug4.setPreferredSize(new Dimension(200, 40));
		dug4.setMinimumSize(new Dimension(300, 150));
		dug4.setBackground(colPolje);
		dug4.setForeground(new Color(255, 255, 255));
		
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
		 
		 JPanel panNaslov = new JPanel();
		 panNaslov.setBackground(new Color(255, 255, 255));
		 
		 JLabel lblNaslov = new JLabel("Prikaz Korisnika");
	     lblNaslov.setFont(new Font("Montserrat", Font.ITALIC, 28));
	     lblNaslov.setPreferredSize(new Dimension(300,30));
	     panNaslov.add(Box.createHorizontalStrut(120)); 
	     panNaslov.add(lblNaslov);
	     
	     
		 
		 JPanel komponente = new JPanel();
		 BoxLayout boxKomp=new BoxLayout(komponente, BoxLayout.X_AXIS);
		 komponente.setLayout(boxKomp);
		 komponente.setBackground(new Color(255,255,255));
		 dugIme.setBackground(colPolje);
		 dugIme.addMouseListener(new PrikazKorisnikaIme());
		 dugIme.setPreferredSize(new Dimension(100,30));
		 
		 dugPrezime.setBackground(colPolje);
		 dugPrezime.addMouseListener(new PrikazKorisnikaPrezime());
		 dugPrezime.setPreferredSize(new Dimension(100,30));
		 
		 dugTip.setBackground(colPolje);
		 dugTip.addMouseListener(new PrikazKorisnikaTip());
		 dugTip.setPreferredSize(new Dimension(100,30));
		 
		 komponente.add(dugIme);
		 komponente.add(Box.createHorizontalStrut(10));
		 komponente.add(dugPrezime);
		 komponente.add(Box.createHorizontalStrut(10));
		 komponente.add(dugTip);
		 
		 JPanel panelTabela = new JPanel();
		 panelTabela.setBackground(new Color(255, 255, 255));
		 
		 dtm.addColumn("Ime");
		 dtm.addColumn("Prezime");
		 dtm.addColumn("Tip Korisnika");
		 
		 
		try {
			korisnici = conn.Korisnici();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 for(int i = 0; i < korisnici.size(); i++) {
			 Korisnik k = korisnici.get(i);
			 dtm.addRow(new Object[] {k.getIme(), k.getPrezime(), k.getTip()});
		 }
		 
		 JTable tabelaKor = new JTable(dtm);
		 tabelaKor.setFont(new Font("Montserrat", Font.ITALIC, 14));
		 tabelaKor.setBackground(col);
		 
		 
		 JScrollPane tabelMain = new JScrollPane(tabelaKor);
		 tabelMain.setPreferredSize(new Dimension(550, 100));
		 panelTabela.add(tabelMain);
		 
		 glavniProzor.add(panNaslov);
		 glavniProzor.add(Box.createVerticalStrut(30));
		 glavniProzor.add(komponente);
		 glavniProzor.add(Box.createVerticalStrut(5));
		 glavniProzor.add(panelTabela);
		 
		 prozor.add(glavniProzor);
		 add(prozor, BorderLayout.CENTER);
		 
	}
	
	public class PrikazKorisnikaIme implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int broj = 0;
			 if(broj != 0) {
				 for(int i = 0; i <= korisnici.size(); i++) {
					 korisnici.remove(i);
					 dtm.removeRow(i); 		 
				 }
			 }
			 else {
				 broj = 1;
			 }
			 
			try {
				korisnici = conn.KorisniciIme();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < dtm.getRowCount(); i++) {
				 for(int j = 0; j < dtm.getColumnCount(); j++) {
					 Korisnik k = korisnici.get(i);
					 if(j == 0) {
						 dtm.setValueAt(k.getIme(), i, j);
					}
					 else if(j == 1) {
						 dtm.setValueAt(k.getPrezime(), i, j);
					}
					 else {
						 dtm.setValueAt(k.getTip(), i, j);
					}
				

				 }
					 
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

	public class PrikazKorisnikaPrezime implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int broj = 0;
			 if(broj != 0) {
				 for(int i = 0; i <= korisnici.size(); i++) {
					 korisnici.remove(i);
					 dtm.removeRow(i); 		 
				 }
			 }
			 else {
				 broj = 1;
			 }
			 
			try {
				korisnici = conn.KorisniciPrezime();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < dtm.getRowCount(); i++) {
				 for(int j = 0; j < dtm.getColumnCount(); j++) {
					 Korisnik k = korisnici.get(i);
					 if(j == 0) {
						 dtm.setValueAt(k.getIme(), i, j);
					}
					 else if(j == 1) {
						 dtm.setValueAt(k.getPrezime(), i, j);
					}
					 else {
						 dtm.setValueAt(k.getTip(), i, j);
					}
				

				 }
					 
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
	
	public class PrikazKorisnikaTip implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int broj = 0;
			 if(broj != 0) {
				 for(int i = 0; i <= korisnici.size(); i++) {
					 korisnici.remove(i);
					 dtm.removeRow(i); 		 
				 }
			 }
			 else {
				 broj = 1;
			 }
			 
			try {
				korisnici = conn.KorisniciTip();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < dtm.getRowCount(); i++) {
				 for(int j = 0; j < dtm.getColumnCount(); j++) {
					 Korisnik k = korisnici.get(i);
					 if(j == 0) {
						 dtm.setValueAt(k.getIme(), i, j);
					}
					 else if(j == 1) {
						 dtm.setValueAt(k.getPrezime(), i, j);
					}
					 else {
						 dtm.setValueAt(k.getTip(), i, j);
					}
				

				 }
					 
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
	
	public class Klik_Admin_Registracija implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Admin_Registracija reg;
			try {
				reg = new Admin_Registracija();
				reg.setVisible(true);
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
