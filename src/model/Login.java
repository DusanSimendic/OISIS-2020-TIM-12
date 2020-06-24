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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() throws IOException {
		
		 setTitle("Apoteka 12");
		 setSize(800,490);
		 setLocationRelativeTo(null);
		 setMaximumSize(new Dimension(810,495));
		 setMinimumSize(new Dimension(700,400));
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
		 picLabel.setLayout(new FlowLayout(FlowLayout.RIGHT,120,200));
		 picLabel.add(loginDugme);
    
  }
}
