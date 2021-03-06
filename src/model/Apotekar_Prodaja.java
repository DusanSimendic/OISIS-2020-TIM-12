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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import model.Apotekar_Lekovi;
import model.Apotekar_Dodavanje;
import model.Apotekar_Izmena;
import model.Login_unos;
import model.Apotekar_Dodavanje.Klik_Lekovi4;
import model.Apotekar_Lekovi.Pretraga;
import model.Apotekar_Lekovi.PrikazLekaCena;
import model.Apotekar_Lekovi.PrikazLekaIme;
import model.Apotekar_Lekovi.PrikazLekaProizvodjac;
import utils.Lek;



public class Apotekar_Prodaja extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4012559381993734927L;
	
	
	
		Color col = new Color(29, 189, 78);
		Color colPolje = new Color(29, 170, 78);
		
		Konekcija_Baza conn = new Konekcija_Baza();
		
		JTextField pretraga = new JTextField();
		
		JButton dugIme = new JButton("Po Imenu");
		JButton dugProzivodjac = new JButton("Po Proizvodjac");
		JButton dugCena = new JButton("Po Ceni");
		
		DefaultTableModel dtmLek = new DefaultTableModel();
		List<Lek> lek = null;
		String pret;
		int suma;
		
		String jml;
		
	public Apotekar_Prodaja() throws IOException  {
		
		
		
		
		 setTitle("Apoteka 12");
		 setSize(800,490);
		 setLocationRelativeTo(null);
		 setMaximumSize(new Dimension(810,495));
		 setMinimumSize(new Dimension(800,490));
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
		 header.add(Box.createHorizontalStrut(320));
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
		 dug1.setFont(new Font("Montserrat", Font.ITALIC, 20));
			dug1.setPreferredSize(new Dimension(200, 40));
			dug1.setMinimumSize(new Dimension(300, 150));
			dug1.setBackground(colPolje);
			dug1.setForeground(new Color(0, 0, 0));
			dug1.addMouseListener(new Klik_Lekovi1());
			
		JPanel polje2 = new JPanel();
		polje2.setPreferredSize(new Dimension(200, 40));
		polje2.setBackground(col);
		JButton dug2 = new JButton("Prodaja Lekova");
		dug2.setFont(new Font("Montserrat", Font.ITALIC, 20));
		dug2.setPreferredSize(new Dimension(200, 40));
		dug2.setMinimumSize(new Dimension(300, 150));
		dug2.setBackground(colPolje);
		dug2.setForeground(new Color(255, 255, 255));
		
		JPanel polje3 = new JPanel();
		polje3.setPreferredSize(new Dimension(200, 40));
		polje3.setBackground(col);
		JButton dug3 = new JButton("Dodavanje Lekova");
		dug3.setFont(new Font("Montserrat", Font.ITALIC, 20));
		dug3.setPreferredSize(new Dimension(200, 40));
		dug3.setMinimumSize(new Dimension(300, 150));
		dug3.setBackground(colPolje);
		dug3.setForeground(new Color(0, 0, 0));
		dug3.addMouseListener(new Klik_Lekovi2());
		
		
		JPanel polje4 = new JPanel();
		polje4.setPreferredSize(new Dimension(200, 40));
		polje4.setBackground(col);
		JButton dug4 = new JButton("Izmena Lekova");
		dug4.setFont(new Font("Montserrat", Font.ITALIC, 20));
		dug4.setPreferredSize(new Dimension(200, 40));
		dug4.setMinimumSize(new Dimension(300, 150));
		dug4.setBackground(colPolje);
		dug4.setForeground(new Color(0, 0, 0));
		dug4.addMouseListener(new Klik_Lekovi3());
		
		
		JPanel polje5 = new JPanel();
		polje5.setPreferredSize(new Dimension(200, 40));
		polje5.setBackground(col);
		JButton dug5 = new JButton("Odjava");
		dug5.setFont(new Font("Montserrat", Font.ITALIC, 20));
		dug5.setPreferredSize(new Dimension(200, 40));
		dug5.setMinimumSize(new Dimension(300, 150));
		dug5.setBackground(colPolje);
		dug5.setForeground(new Color(0, 0, 0));
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
		 
		 JPanel panNaslov = new JPanel();
		 panNaslov.setBackground(new Color(255, 255, 255));
		 
		 JLabel lblNaslov = new JLabel("Korpa");
	     lblNaslov.setFont(new Font("Montserrat", Font.ITALIC, 28));
	     lblNaslov.setPreferredSize(new Dimension(300,30));
	     panNaslov.add(Box.createHorizontalStrut(120)); 
	     panNaslov.add(lblNaslov);
	     
	     JPanel panPretraga = new JPanel();
	     panPretraga.setBackground(new Color(255,255,255));
	     
	     pretraga.setPreferredSize(new Dimension(300, 30));
	     pretraga.setBackground(new Color(255,255,255));
	     
	     BufferedImage pretrazi = ImageIO.read(new File("externi_resursi/icon.png"));
		 JLabel pretLupa = new JLabel(new ImageIcon(pretrazi));
		 pretLupa.setPreferredSize(new Dimension(50, 50));
		 pretLupa.addMouseListener(new Korpa());
		 
		 pretraga.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     panPretraga.add(pretraga);
	     panPretraga.add(pretLupa, new FlowLayout(FlowLayout.RIGHT));
		 
		 JPanel panelTabela = new JPanel();
		 panelTabela.setBackground(new Color(255, 255, 255));
		 
		 dtmLek.addColumn("Sifra");
		 dtmLek.addColumn("Ime Leka");
		 dtmLek.addColumn("Prototip");
		 dtmLek.addColumn("Recept");
		 dtmLek.addColumn("Cena");
		 
		 
		
		 
		 
		 JTable tabelaKor = new JTable(dtmLek);
		 tabelaKor.setFont(new Font("Montserrat", Font.ITALIC, 14));
		 tabelaKor.setBackground(col);
		 
		 JScrollPane tabelMain = new JScrollPane(tabelaKor);
		 tabelMain.setPreferredSize(new Dimension(550, 100));
		 panelTabela.add(tabelMain);
		 
		 JPanel panSuma = new JPanel();
		 panelTabela.setBackground(new Color(255, 255, 255));	 
		 JLabel sumaL = new JLabel();
		 String jml1 = jml;
		 sumaL.setText(jml1);
		 
		 panSuma.add(sumaL, new FlowLayout(FlowLayout.RIGHT));

		 
		 glavniProzor.add(panNaslov);
		 glavniProzor.add(Box.createVerticalStrut(5));
		 glavniProzor.add(panPretraga);
		 glavniProzor.add(Box.createVerticalStrut(5));
		 glavniProzor.add(panelTabela);
		 glavniProzor.add(Box.createVerticalStrut(5));
		 glavniProzor.add(panSuma);
		 
		 
		 prozor.add(glavniProzor);
		 add(prozor, BorderLayout.CENTER);

	}
	
	public class Korpa implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		
			 pret = pretraga.getText();
			try {
				lek = conn.PretragaIme(pret);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < lek.size(); i++) {
					 Lek l = lek.get(i);
					 dtmLek.addRow(new Object[] {l.getSifraLeka(), l.getImeLeka(), l.getProizvodjac(), l.getRecept(), l.getCena()});
					 suma = suma + l.getCena();
					 jml= String.valueOf(suma);
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
	
	public class Klik_Lekovi2 implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Apotekar_Dodavanje ad;
			try {
				ad = new Apotekar_Dodavanje();
				ad.setVisible(true);
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
