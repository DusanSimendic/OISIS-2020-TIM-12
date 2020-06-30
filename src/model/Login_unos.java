package model;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
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

import application.Konekcija_Baza;
import utils.Korisnik;
import utils.Logovan;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_unos extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376568045310465712L;
	
	JTextField txtUser=new JTextField();
	JTextField txtLozinka=new JTextField();
	JButton loginDugme = new JButton("PRIJAVI SE");
	Logovan log = new Logovan();
	int user;
	
	Konekcija_Baza conn = new Konekcija_Baza();
	
	public Login_unos() throws IOException {
		
		 setTitle("Apoteka 12");
		 setSize(800,490);
		 setLocationRelativeTo(null);
		 setMaximumSize(new Dimension(810,495));
		 setMinimumSize(new Dimension(700,400));
		 setBackground(new Color(255, 255, 255));
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 setVisible(true);
		 setLayout(new BorderLayout());
		 
		 BufferedImage myPicture = ImageIO.read(new File("externi_resursi/login.jpg"));
		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		 add(picLabel,BorderLayout.CENTER);
		 
		 
		 loginDugme.setSize(new Dimension(300, 150));
		 loginDugme.setForeground(new Color(194, 236, 235));
		 loginDugme.setFont(new Font("Montserrat", Font.PLAIN, 11));
		 loginDugme.setBackground(new Color(8, 126, 139));	

		 
		 
		 
		 
		 JPanel field=new JPanel();
		 field.setBackground(new Color(255, 255, 255));
		 BoxLayout box=new BoxLayout(field, BoxLayout.Y_AXIS);
		 field.setLayout(box);
		 field.setOpaque(false);
		 
		 Dimension dim=new Dimension(200,30);

			
			JPanel panUsername=new JPanel(new FlowLayout(FlowLayout.LEFT));
			panUsername.setBackground(new Color(255, 255, 255));
			panUsername.setOpaque(false);

	        
	        txtUser.setFont(new Font("Montserrat", Font.PLAIN, 11));
	        txtUser.setText("Korisnicko Ime");
	        txtUser.setPreferredSize(dim);
	        txtUser.addMouseListener(new TXTUser());

	        panUsername.add(txtUser);
	       
	        JPanel panLozinka=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        panLozinka.setBackground(new Color(255, 255, 255));
	        panLozinka.setOpaque(false);
	        
	       
	        txtLozinka.setFont(new Font("Montserrat", Font.PLAIN, 11));
	        txtLozinka.setText("Lozinka");
	        txtLozinka.setPreferredSize(dim);
	        txtLozinka.addMouseListener(new TXTLozinka());
	        
	        panLozinka.add(txtLozinka);

	        field.add(panUsername);
	        field.add(panLozinka);
	        field.add(Box.createVerticalStrut(25));
	        
	        field.add(Box.createGlue());
			field.add(loginDugme);
			
			
			loginDugme.addActionListener(new Action());
			
			
			pack();
	        picLabel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,180));
			picLabel.add(field);

	}
	
	public class TXTUser implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(txtUser.getText().contentEquals("Korisnicko Ime")) {
				txtUser.setText("");
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
	
	public class TXTLozinka implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(txtLozinka.getText().contentEquals("Lozinka")) {
				txtLozinka.setText("");
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
	
	public class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<Korisnik> korisnici = null;
			try {
				korisnici = conn.Korisnici();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < korisnici.size(); i++) {
				if(korisnici.get(i).getUser().equals(txtUser.getText())){
					if(korisnici.get(i).getPass().equals(txtLozinka.getText())) {
						user = korisnici.get(i).getIDKorisnika();
						
						log.setSifra(user);
						if(korisnici.get(i).getTip().equals("Apotekar")) {
							try {
								
								Apotekar_Lekovi ll = new Apotekar_Lekovi();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							setVisible(false);
						}
						else if(korisnici.get(i).getTip().equals("Lekar")) {
							try {
								Lekar_Lekovi lek = new Lekar_Lekovi();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							setVisible(false);
						}
						else {
							try {
								Admin_Dodavanje_Leka ad = new Admin_Dodavanje_Leka();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							setVisible(false);
						}
					}
				}
			}
		}
		
	}
	
	
	public class Klik_Apotekar implements MouseListener {

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
	
	public class Klik_Lekar implements MouseListener {

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
	
	public class Klik_Admin implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			
			Admin_Dodavanje_Leka ad;
			try {
				ad = new Admin_Dodavanje_Leka();
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
}
