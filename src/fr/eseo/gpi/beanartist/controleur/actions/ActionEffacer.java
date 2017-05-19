package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionEffacer extends AbstractAction{
	
	/*
	 * Attribut
	 */
	public static final String NOM_ACTION = "EFFACER TOUT";
	public static final String DEFINITION_ACTION = "Efface toutes les figures du dessin";
	
	/*
	 * Constructeur
	 */
	public ActionEffacer(){
		super(ActionEffacer.NOM_ACTION);
	}
	
	/*
	 * Methode propre
	 */
	public void actionPerformed(ActionEvent event){
		FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().clear();
		FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
	}

}
