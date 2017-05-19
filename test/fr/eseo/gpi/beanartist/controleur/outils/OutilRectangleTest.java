package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilRectangleTest {
	
	public static void main(String[] args){
		
		FenetreBeAnArtist.getInstance().setVisible(true);
		
		OutilRectangle outilRectangle = new OutilRectangle(FenetreBeAnArtist.getInstance().getPanneauDessin());
		
		outilRectangle.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
	}

}
