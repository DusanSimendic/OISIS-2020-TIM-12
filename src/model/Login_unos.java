package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_unos extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
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
		 
		 JButton loginDugme = new JButton("PRIJAVI SE");
		 loginDugme.setSize(new Dimension(300, 150));
		 loginDugme.setForeground(new Color(194, 236, 235));
		 loginDugme.setFont(new Font("Montserrat", Font.PLAIN, 11));
		 loginDugme.setBackground(new Color(8, 126, 139));
		 
		 
		 JPanel field=new JPanel();
		 field.setBackground(new Color(255, 255, 255));
		 BoxLayout box=new BoxLayout(field, BoxLayout.Y_AXIS);
		 field.setLayout(box);
		 
		 Dimension dim=new Dimension(200,30);

			
			JPanel panUsername=new JPanel(new FlowLayout(FlowLayout.LEFT));
			panUsername.setBackground(new Color(255, 255, 255));

	        JTextField txtUser=new JTextField();
	        txtUser.setFont(new Font("Montserrat", Font.PLAIN, 11));
	        txtUser.setText("Korisnicko Ime");
	        txtUser.setPreferredSize(dim);

	        panUsername.add(txtUser);
	       
	        JPanel panLozinka=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        panLozinka.setBackground(new Color(255, 255, 255));
	        
	        JTextField txtLozinka=new JTextField();
	        txtLozinka.setFont(new Font("Montserrat", Font.PLAIN, 11));
	        txtLozinka.setText("Lozinka");
	        txtLozinka.setPreferredSize(dim);
	        
	        panLozinka.add(txtLozinka);

	        field.add(panUsername);
	        field.add(panLozinka);
	        field.add(Box.createVerticalStrut(25));
	        
	        field.add(Box.createGlue());
			field.add(loginDugme);
			
			pack();
	        picLabel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,180));
			picLabel.add(field);

		
		 

	}
}
