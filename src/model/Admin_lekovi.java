package model;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;






public class Admin_lekovi extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin_lekovi() throws IOException {
		
		setTitle("BorderLayout Manager");
		 setSize(800,490);
		 setLocationRelativeTo(null);
		 setMaximumSize(Prozor());
		 setMinimumSize(Prozor_min());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 setVisible(true);
		 setLayout(new BorderLayout());
		 
		 BufferedImage myPicture = ImageIO.read(new File("externi_resursi/login.jpg"));
		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		 add(picLabel,BorderLayout.WEST);

        
  }

	private Dimension Prozor() {
		Dimension dimenzija = new Dimension(810,495);
		return dimenzija;
	}
	private Dimension Prozor_min() {
		Dimension dimenzija = new Dimension(600,400);
		return dimenzija;
	}

	
}
