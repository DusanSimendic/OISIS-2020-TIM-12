package model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dodaj_Lek_Greska extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5749507357729295710L;
	
	public Dodaj_Lek_Greska() {
		
		setBackground(new Color(255,255,255));
		setSize(300,100);
		setTitle("Poruka");
		
		
		JPanel prozorD = new JPanel();
		prozorD.setBackground(new Color(255, 255, 255));
		BoxLayout box=new BoxLayout(prozorD, BoxLayout.Y_AXIS);
		prozorD.setLayout(box);
		
		JPanel panPoruka = new JPanel();
		panPoruka.setSize(250,50);
		panPoruka.setBackground(new Color(255, 255, 255));
		JLabel poruka = new JLabel();
		poruka.setText("GREŠKA!!!");
		poruka.setFont(new Font("Montserrat", Font.ITALIC, 14));
		
		JPanel panPoruka1 = new JPanel();
		panPoruka1.setSize(250,50);
		panPoruka1.setBackground(new Color(255, 255, 255));
		JLabel poruka1 = new JLabel();
		poruka1.setText("Unos nije pravilan proverite podatke ponovo");
		poruka1.setFont(new Font("Montserrat", Font.ITALIC, 14));
		
		
		
		panPoruka1.add(poruka1);
		panPoruka.add(poruka);
		prozorD.add(panPoruka);
		prozorD.add(panPoruka1);
		
		add(prozorD);
	}

}
