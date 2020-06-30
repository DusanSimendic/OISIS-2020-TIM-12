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

import model.Lekar_Lekovi;
import model.Lekar_Kreiranje_Recepta;
import model.Login_unos;
import model.Lekar_Lekovi.Pretraga;
import model.Lekar_Lekovi.PrikazLekaCena;
import model.Lekar_Lekovi.PrikazLekaIme;
import model.Lekar_Lekovi.PrikazLekaProizvodjac;
import utils.Lek;
import utils.Recept;



public class Lekar_Recepti extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2210213495944272032L;
	
		Color col = new Color(41, 113, 232);
		Color colPolje = new Color(86, 143, 237);
		
		Konekcija_Baza conn = new Konekcija_Baza();
		
		JTextField pretraga = new JTextField();
		
		JButton dugSifra = new JButton("Po Sifri");
		JButton dugLekar = new JButton("Po IDLekaru");
		JButton dugDatum = new JButton("Po Datumu");
		
		DefaultTableModel dtmRecept = new DefaultTableModel();
		List<Recept> recept = null;
		String pret;
		
	public Lekar_Recepti() throws IOException  {
		
		
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
		 header.setBackground(col);
		 header.setPreferredSize(new Dimension(800, 80));
		 
		 BoxLayout box=new BoxLayout(header, BoxLayout.X_AXIS);
		 header.setLayout(box);
		 
		 BufferedImage slika = ImageIO.read(new File("externi_resursi/Lekar.jpg"));
		 JLabel apoteka = new JLabel(new ImageIcon(slika));
		 apoteka.setPreferredSize(new Dimension(150, 50));
		 
		 JLabel ime = new JLabel("Lekar");
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
		 polje1.setPreferredSize(new Dimension(200, 40));
		 polje1.setBackground(col);
		 JButton dug1 = new JButton("Lekovi");
		 dug1.setFont(new Font("Montserrat", Font.ITALIC, 30));
			dug1.setPreferredSize(new Dimension(200, 40));
			dug1.setMinimumSize(new Dimension(300, 150));
			dug1.setBackground(colPolje);
			dug1.setForeground(new Color(0, 0, 0));
			dug1.addMouseListener(new Klik_Lekar_Lekovi());
			
		JPanel polje2 = new JPanel();
		polje2.setPreferredSize(new Dimension(200, 40));
		polje2.setBackground(col);
		JButton dug2 = new JButton("Recepti");
		dug2.setFont(new Font("Montserrat", Font.ITALIC, 30));
		dug2.setPreferredSize(new Dimension(200, 40));
		dug2.setMinimumSize(new Dimension(300, 150));
		dug2.setBackground(colPolje);
		dug2.setForeground(new Color(255, 255, 255));
		
		
		JPanel polje3 = new JPanel();
		polje3.setPreferredSize(new Dimension(200, 40));
		polje3.setBackground(col);
		JButton dug3 = new JButton("Kreriranje Recepta");
		dug3.setFont(new Font("Montserrat", Font.ITALIC, 30));
		dug3.setPreferredSize(new Dimension(200, 40));
		dug3.setMinimumSize(new Dimension(300, 150));
		dug3.setBackground(colPolje);
		dug3.setForeground(new Color(0, 0, 0));
		dug3.addMouseListener(new Klik_Lekar_Kreiranje());
		
		
		JPanel polje4 = new JPanel();
		polje4.setPreferredSize(new Dimension(200, 40));
		polje4.setBackground(col);
		JButton dug4 = new JButton("Odjava");
		dug4.setFont(new Font("Montserrat", Font.ITALIC, 30));
		dug4.setPreferredSize(new Dimension(200, 40));
		dug4.setMinimumSize(new Dimension(300, 150));
		dug4.setBackground(colPolje);
		dug4.setForeground(new Color(0, 0, 0));
		dug4.addMouseListener(new Klik_Odjava());
		
		 
		 
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
		 
		 JLabel lblNaslov = new JLabel("Prikaz Lekova");
	     lblNaslov.setFont(new Font("Montserrat", Font.ITALIC, 28));
	     lblNaslov.setPreferredSize(new Dimension(300,30));
	     panNaslov.add(Box.createHorizontalStrut(120)); 
	     panNaslov.add(lblNaslov);
	     
	     JPanel panPretraga = new JPanel();
	     panPretraga.setBackground(new Color(255,255,255));
	     
	     pretraga.setPreferredSize(new Dimension(300, 30));
	     pretraga.setBackground(new Color(255,255,255));
	     pretraga.setFont(new Font("Montserrat", Font.ITALIC, 20));
	     
	     BufferedImage pretrazi = ImageIO.read(new File("externi_resursi/icon.png"));
		 JLabel pretLupa = new JLabel(new ImageIcon(pretrazi));
		 pretLupa.setPreferredSize(new Dimension(50, 50));
		 pretLupa.addMouseListener(new PretragaRec());
	     panPretraga.add(pretraga);
	     panPretraga.add(pretLupa, new FlowLayout(FlowLayout.RIGHT));
		 
		 JPanel komponente = new JPanel();
		 BoxLayout boxKomp=new BoxLayout(komponente, BoxLayout.X_AXIS);
		 komponente.setLayout(boxKomp);
		 komponente.setBackground(new Color(255,255,255));
		 dugSifra.setBackground(colPolje);
		 dugSifra.addMouseListener(new PrikazSifra());
		 dugSifra.setPreferredSize(new Dimension(100,30));
		 dugSifra.setFont(new Font("Montserrat", Font.ITALIC, 18));
		 
		 dugLekar.setBackground(colPolje);
		 dugLekar.addMouseListener(new PrikazSifra());
		 dugLekar.setPreferredSize(new Dimension(100,30));
		 dugLekar.setFont(new Font("Montserrat", Font.ITALIC, 18));
		 
		 dugDatum.setBackground(colPolje);
		 dugDatum.addMouseListener(new PrikazVreme());
		 dugDatum.setPreferredSize(new Dimension(100,30));
		 dugDatum.setFont(new Font("Montserrat", Font.ITALIC, 18));
		 
		 komponente.add(dugSifra);
		 komponente.add(Box.createHorizontalStrut(10));
		 komponente.add(dugLekar);
		 komponente.add(Box.createHorizontalStrut(10));;
		 komponente.add(dugDatum);
		 komponente.add(Box.createHorizontalStrut(10));
		 
		 JPanel panelTabela = new JPanel();
		 panelTabela.setBackground(new Color(255, 255, 255));
		 
		 dtmRecept.addColumn("Sifra");
		 dtmRecept.addColumn("Ime Leka");
		 dtmRecept.addColumn("Prototip");
		 dtmRecept.addColumn("Recept");
		 dtmRecept.addColumn("Cena");
		 
		 
		try {
			recept = conn.Recepti();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 for(int i = 0; i < recept.size(); i++) {
			 Recept l = recept.get(i);
			 
			 dtmRecept.addRow(new Object[] {l.getSifraRecepta(), l.getIDLekara(), l.getJMBG(), l.getDatumIzadvanja(), l.getRecept()});
		 }
		 JTable tabelaKor = new JTable(dtmRecept);
		 tabelaKor.setFont(new Font("Montserrat", Font.ITALIC, 14));
		 tabelaKor.setBackground(col);
		 
		 
		 
		 
		 JScrollPane tabelMain = new JScrollPane(tabelaKor);
		 tabelMain.setPreferredSize(new Dimension(550, 150));
		 panelTabela.add(tabelMain);
		 
		 glavniProzor.add(panNaslov);
		 glavniProzor.add(Box.createVerticalStrut(30));
		 glavniProzor.add(panPretraga);
		 glavniProzor.add(Box.createVerticalStrut(20));
		 glavniProzor.add(komponente);
		 glavniProzor.add(Box.createVerticalStrut(5));
		 glavniProzor.add(panelTabela);
		 
		 prozor.add(glavniProzor);
		 add(prozor, BorderLayout.CENTER);
		 
		 
		 
	}
	
	public class PrikazSifra implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int broj = 0;
			 if(broj != 0) {
				 for(int i = 0; i <= recept.size(); i++) {
					 recept.remove(i);
					 dtmRecept.removeRow(i); 		 
				 }
			 }
			 else {
				 broj = 1;
			 }
			 
			try {
				recept = conn.ReceptiSifra();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < dtmRecept.getRowCount(); i++) {
				 for(int j = 0; j < dtmRecept.getColumnCount(); j++) {
					 Recept l = recept.get(i);
					 if(j == 0) {
						 dtmRecept.setValueAt(l.getSifraRecepta(), i, j);
					}
					 else if(j == 1) {
						 dtmRecept.setValueAt(l.getIDLekara(), i, j);
					}
					 else if(j == 2) {
						 dtmRecept.setValueAt(l.getJMBG(), i, j);
					}
					 else if(j == 3) {
						 dtmRecept.setValueAt(l.getDatumIzadvanja(), i, j);
					}
					 else {
						 dtmRecept.setValueAt(l.getRecept(), i, j);
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

	public class PrikazKorisnik implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int broj = 0;
			 if(broj != 0) {
				 for(int i = 0; i <= recept.size(); i++) {
					 recept.remove(i);
					 dtmRecept.removeRow(i); 		 
				 }
			 }
			 else {
				 broj = 1;
			 }
			 
			try {
				recept = conn.ReceptiID();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < dtmRecept.getRowCount(); i++) {
				 for(int j = 0; j < dtmRecept.getColumnCount(); j++) {
					 Recept l = recept.get(i);
					 if(j == 0) {
						 dtmRecept.setValueAt(l.getSifraRecepta(), i, j);
					}
					 else if(j == 1) {
						 dtmRecept.setValueAt(l.getIDLekara(), i, j);
					}
					 else if(j == 2) {
						 dtmRecept.setValueAt(l.getJMBG(), i, j);
					}
					 else if(j == 3) {
						 dtmRecept.setValueAt(l.getDatumIzadvanja(), i, j);
					}
					 else {
						 dtmRecept.setValueAt(l.getRecept(), i, j);
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
	
	public class PrikazVreme implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int broj = 0;
			 if(broj != 0) {
				 for(int i = 0; i <= recept.size(); i++) {
					 recept.remove(i);
					 dtmRecept.removeRow(i); 		 
				 }
			 }
			 else {
				 broj = 1;
			 }
			 
			try {
				recept = conn.ReceptiDatum();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < dtmRecept.getRowCount(); i++) {
				 for(int j = 0; j < dtmRecept.getColumnCount(); j++) {
					 Recept l = recept.get(i);
					 if(j == 0) {
						 dtmRecept.setValueAt(l.getSifraRecepta(), i, j);
					}
					 else if(j == 1) {
						 dtmRecept.setValueAt(l.getIDLekara(), i, j);
					}
					 else if(j == 2) {
						 dtmRecept.setValueAt(l.getJMBG(), i, j);
					}
					 else if(j == 3) {
						 dtmRecept.setValueAt(l.getDatumIzadvanja(), i, j);
					}
					 else {
						 dtmRecept.setValueAt(l.getRecept(), i, j);
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
	
	public class PretragaRec implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			int broj = 0;
			 if(broj == 0) {
				 int rowCount = dtmRecept.getRowCount();
				 for(int i = 0; i < rowCount; i++) {
					 dtmRecept.removeRow(0); 		 
				 }
				 recept.clear();
				 broj = 1;
			 }
			 int jml = Integer.parseInt(pretraga.getText());
			try {
				recept = conn.ReceptiPret(jml);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 for(int i = 0; i < recept.size(); i++) {
					 Recept l = recept.get(i);
					 dtmRecept.addRow(new Object[] {l.getSifraRecepta(), l.getIDLekara(), l.getJMBG(), l.getDatumIzadvanja(), l.getRecept()});	 
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
	
	public class Klik_Lekar_Kreiranje implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Lekar_Kreiranje_Recepta lkr;
			try {
				lkr = new Lekar_Kreiranje_Recepta();
				lkr.setVisible(true);
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
	
	public class Klik_Lekar_Lekovi implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Lekar_Lekovi ll;
			try {
				ll = new Lekar_Lekovi();
				ll.setVisible(true);
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
