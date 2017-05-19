package fr.eseo.gpi.beanartist.controleur.bouton;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BoutonAction extends JButton {

	private static final long serialVersionUID = 1L;
	
	public BoutonAction(String nomBouton, String tipText){
		
		super(nomBouton);
		super.setToolTipText(tipText);
		super.setForeground(Color.WHITE);

		super.setOpaque(false);
		super.setContentAreaFilled(false);
		super.setBorderPainted(false);
		super.setFocusPainted(false);
		
		super.setHorizontalAlignment(SwingConstants.CENTER);
		super.setHorizontalTextPosition(SwingConstants.CENTER);
		
		super.setIcon(new ImageIcon("data/emeraude.png"));
		super.setRolloverIcon(new ImageIcon());
	}

}
