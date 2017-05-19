package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionRemplir extends AbstractAction {
	
	/*
	 * Attribut
	 */
	public static final String NOM_ACTION = "REMPLIR";
	public static final String DEFINITION_ACTION = "Dessiner des figures pleines";
	
	/*
	 * Constructeur
	 */
	public ActionRemplir(){
		super(ActionRemplir.NOM_ACTION);
	}

	public void actionPerformed(ActionEvent e) {
		
		FenetreBeAnArtist.getInstance().getPanneauDessin().setRemplissage(true);
		
		boolean rempli = FenetreBeAnArtist.getInstance().getPanneauDessin().isRempli();
		
		if(rempli)
			FenetreBeAnArtist.getInstance().getPanneauDessin().getJLabelRempli().setText("Remplissage : oui");
		else
			FenetreBeAnArtist.getInstance().getPanneauDessin().getJLabelRempli().setText("Remplissage : non");
	}
}
