package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilTraceTest {
	
	public static void main(String[] args){
		
		FenetreBeAnArtist.getInstance().setVisible(true);
		
		OutilTrace outilTrace = new OutilTrace(FenetreBeAnArtist.getInstance().getPanneauDessin());
		
		outilTrace.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
	}

}
