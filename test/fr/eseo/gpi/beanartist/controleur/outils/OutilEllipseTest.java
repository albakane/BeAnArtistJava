package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilEllipseTest {
	
	public static void main(String[] args){
		
		FenetreBeAnArtist.getInstance().setVisible(true);
		
		OutilEllipse outilEllipse = new OutilEllipse(FenetreBeAnArtist.getInstance().getPanneauDessin());
		
		outilEllipse.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
	}

}
