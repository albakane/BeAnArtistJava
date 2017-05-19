package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.gpi.beanartist.controleur.outils.*;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionForme extends AbstractAction{
	
	/*
	 * Attributs
	 */
	public static final String NOM_ACTION_RECTANGLE = "RECTANGLE";
	public static final String NOM_ACTION_ELLIPSE = "ELLIPSE";
	public static final String NOM_ACTION_CARRE = "CARRE";
	public static final String NOM_ACTION_CERCLE = "CERCLE";
	public static final String NOM_ACTION_LIGNE = "LIGNE";	
	public static final String NOM_ACTION_TRACE = "TRACE";
	
	public static final String DEFINITION_ACTION_RECTANGLE = "Dessine un rectangle";
	public static final String DEFINITION_ACTION_ELLIPSE = "Dessine une ellipse";
	public static final String DEFINITION_ACTION_CARRE = "Dessine un carre";
	public static final String DEFINITION_ACTION_CERCLE = "Dessine un cercle";
	public static final String DEFINITION_ACTION_LIGNE = "Dessine une ligne";
	public static final String DEFINITION_ACTION_TRACE = "Dessine une forme a main levee";
		
	/*
	 * Constructeur
	 */
	public ActionForme(){
		super("ActionForme");
	}

	/*
	 * Methode de la classe abstraite
	 */
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()){
		case ActionForme.NOM_ACTION_RECTANGLE:
			OutilRectangle outilRectangle = new OutilRectangle(
					FenetreBeAnArtist.getInstance().getPanneauDessin());
			outilRectangle.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
			break;
		case ActionForme.NOM_ACTION_ELLIPSE:
			OutilEllipse outilEllipse = new OutilEllipse(
					FenetreBeAnArtist.getInstance().getPanneauDessin());
			outilEllipse.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
			break;
		case ActionForme.NOM_ACTION_CARRE:
			OutilCarre outilCarre = new OutilCarre(
					FenetreBeAnArtist.getInstance().getPanneauDessin());
			outilCarre.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
			break;
		case ActionForme.NOM_ACTION_CERCLE:
			OutilCercle outilCercle = new OutilCercle(
					FenetreBeAnArtist.getInstance().getPanneauDessin());
			outilCercle.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
			break;
		case ActionForme.NOM_ACTION_LIGNE:
			OutilLigne outilLigne = new OutilLigne(
					FenetreBeAnArtist.getInstance().getPanneauDessin());
			outilLigne.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
			break;
		case ActionForme.NOM_ACTION_TRACE:
			OutilTrace outilTrace = new OutilTrace(
					FenetreBeAnArtist.getInstance().getPanneauDessin());
			outilTrace.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
			break;
		default:
		} 
	}

}
