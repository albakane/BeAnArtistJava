package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilCarreTest {
	
	public static void main(String[] args){
		
		FenetreBeAnArtist.getInstance().setVisible(true);
		
		OutilCarre outilCarre = new OutilCarre(FenetreBeAnArtist.getInstance().getPanneauDessin());
		
		outilCarre.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
	}

}
