package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JToggleButton;

import fr.eseo.gpi.beanartist.controleur.outils.OutilSelection;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionSelectionner extends AbstractAction{
	
	/*
	 * Attributs
	 */
	public static final String NOM_ACTION = "SELECTIONNER";
	public static final String DEFINITION_ACTION_SELECTIONNER = "Selectionne une forme "
			+ "deja dessinee";
	
	public ActionSelectionner(){
		super(ActionSelectionner.NOM_ACTION);
	}

	public void actionPerformed(ActionEvent event) {
		OutilSelection outilSelection = new OutilSelection(FenetreBeAnArtist.getInstance().getPanneauDessin());
		outilSelection.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
	}

}