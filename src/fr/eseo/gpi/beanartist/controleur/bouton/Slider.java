package fr.eseo.gpi.beanartist.controleur.bouton;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class Slider extends JSlider {
	
	private static final long serialVersionUID = 1;
	private int epaisseur;
	
	public Slider(int minimum, int maximum){
		
		super(minimum, maximum);
		
		super.setBackground(new Color(52, 73, 94));
		this.setName("COUCOU");
		super.setValue(0);
		super.setPaintTrack(true);
		super.setPaintTicks(true);
		super.setForeground(Color.WHITE);
		this.setMinorTickSpacing(10);
	    this.setMajorTickSpacing(20);
	    
	    this.setToolTipText("Change l'epaisseur du trait");
		
		this.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent event){
				int valeur = ((JSlider)event.getSource()).getValue();
				FenetreBeAnArtist.getInstance().getPanneauDessin().setEpaisseur(valeur);
			}
		});
	}

	public int getEpaisseur() {
		return epaisseur;
	}

}
