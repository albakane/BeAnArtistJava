package fr.eseo.gpi.beanartist.controleur.bouton;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class BoutonToggleAction extends JToggleButton {
	
	private static final long serialVersionUID = 1L;

	public BoutonToggleAction(String nomBouton, String tipText){
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
		super.setSelectedIcon(new ImageIcon());
		
	}

}
