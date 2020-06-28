package model;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	
	JButton loginDugme = new JButton("PRIJAVI SE");

	public Login() throws IOException {
		
		 setTitle("Apoteka 12");
		 setSize(800,490);
		 setLocationRelativeTo(null);
		 setMaximumSize(new Dimension(810,495));
		 setMinimumSize(new Dimension(700,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 setVisible(true);
		 
		 BufferedImage myPicture = ImageIO.read(new File("externi_resursi/login.jpg"));
		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		 add(picLabel);
		 
		 JPanel glavni = new JPanel();
		 glavni.setSize(new Dimension(350,200));
		 glavni.setOpaque(false);
		 
		 loginDugme.setPreferredSize(new Dimension(200, 50));
		 loginDugme.setForeground(new Color(194, 236, 235));
		 loginDugme.setFont(new Font("Montserrat", Font.PLAIN, 20));
		 loginDugme.setBackground(new Color(8, 126, 139));
		 loginDugme.addMouseListener(new Klik_Prijava());
		 
		 glavni.add(loginDugme, BorderLayout.CENTER);
		 picLabel.setLayout(new FlowLayout(FlowLayout.RIGHT, 80, 200));
		 picLabel.add(glavni);
		 
    
  }
	
	public class Klik_Prijava implements MouseListener {

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
