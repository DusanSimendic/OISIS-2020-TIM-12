package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dodaj_Kor_Dialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -61319461199602247L;

	public Dodaj_Kor_Dialog(){

		setBackground(new Color(255,255,255));
		setSize(300,100);
		setMinimumSize(new Dimension(300,100));
		setTitle("Poruka");
		
		
		JPanel prozorD = new JPanel();
		prozorD.setBackground(new Color(255, 255, 255));
		BoxLayout box=new BoxLayout(prozorD, BoxLayout.Y_AXIS);
		prozorD.setLayout(box);
		
		JPanel panPoruka = new JPanel();
		panPoruka.setSize(250,50);
		panPoruka.setBackground(new Color(255, 255, 255));
		JLabel poruka = new JLabel();
		poruka.setText("Uspesno ste dodali novog korisnika u bazu podataka");
		poruka.setFont(new Font("Montserrat", Font.ITALIC, 14));

		panPoruka.add(poruka);
		prozorD.add(panPoruka);
		
		add(prozorD);
		
		
		
		
	}
}
