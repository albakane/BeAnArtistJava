package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionChoisirCouleurLigne extends AbstractAction{
	
	/*
	 * Attributs
	 */
	public static final String NOM_ACTION = "CHOISIR COULEUR";
	public static final String DEFINITION_ACTION = "Choisir une couleur pour les figures suivantes";
	
	/*
	 * Constructeur
	 */
	public ActionChoisirCouleurLigne(){
		super(ActionChoisirCouleurLigne.NOM_ACTION);
	}

	public void actionPerformed(ActionEvent e){
		
		Color newColor = JColorChooser.showDialog(
				FenetreBeAnArtist.getInstance().getPanneauDessin(),
				ActionChoisirCouleurLigne.NOM_ACTION, 
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
		
		FenetreBeAnArtist.getInstance().getPanneauDessin().setCouleurLigneCourante(newColor);
		FenetreBeAnArtist.getInstance().getPanneauDessin().setPanColor(newColor);
		FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
	}

}
