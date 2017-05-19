package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilLigneTest {
	
	public static void main(String[] args){
		
		FenetreBeAnArtist.getInstance().setVisible(true);
		
		OutilLigne outilLigne = new OutilLigne(FenetreBeAnArtist.getInstance().getPanneauDessin());
		
		outilLigne.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());

	}
}
