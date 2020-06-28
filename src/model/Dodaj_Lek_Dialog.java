package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Dodaj_Lek_Dialog extends JDialog{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -916797270740446672L;

	public Dodaj_Lek_Dialog(){

		setBackground(new Color(255,255,255));
		setSize(300,100);
		setTitle("Poruka");
		
		
		JPanel prozorD = new JPanel();
		prozorD.setBackground(new Color(29, 189, 78));
		BoxLayout box=new BoxLayout(prozorD, BoxLayout.Y_AXIS);
		prozorD.setLayout(box);
		
		JPanel panPoruka = new JPanel();
		panPoruka.setBackground(new Color(29, 189, 78));
		JLabel poruka = new JLabel();
		poruka.setText("Uspesno ste dodali lek u bazu podataka");
		poruka.setFont(new Font("Montserrat", Font.ITALIC, 14));
		
		
		
		
		panPoruka.add(poruka);
		prozorD.add(panPoruka);
		
		add(prozorD);
		
		
		
		
	}
	
	

}
