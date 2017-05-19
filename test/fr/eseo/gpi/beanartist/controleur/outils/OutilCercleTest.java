package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilCercleTest {
	
	public static void main(String[] args){
		
		FenetreBeAnArtist.getInstance().setVisible(true);
		
		OutilCercle outilCercle = new OutilCercle(FenetreBeAnArtist.getInstance().getPanneauDessin());
		
		outilCercle.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
	}

}
