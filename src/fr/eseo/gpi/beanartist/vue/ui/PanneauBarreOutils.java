package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.eseo.gpi.beanartist.controleur.actions.ActionChoisirCouleurLigne;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEffacer;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEnregistrer;
import fr.eseo.gpi.beanartist.controleur.actions.ActionForme;
import fr.eseo.gpi.beanartist.controleur.actions.ActionOuvrir;
import fr.eseo.gpi.beanartist.controleur.actions.ActionRemplir;
import fr.eseo.gpi.beanartist.controleur.actions.ActionSelectionner;
import fr.eseo.gpi.beanartist.controleur.bouton.BoutonAction;
import fr.eseo.gpi.beanartist.controleur.bouton.BoutonToggleAction;
import fr.eseo.gpi.beanartist.controleur.bouton.Slider;

public class PanneauBarreOutils extends JPanel{
	
	/*
	 * Attributs
	 */
	private FenetreBeAnArtist fenetreBeAnArtist;
	
	/*
	 * Constructeur
	 */
	public PanneauBarreOutils(){
	    // Définition de sa couleur de fond
	    this.setBackground(new Color(52, 73, 94));
	    
	    // Definition de ses dimensions
	    this.setPreferredSize(new Dimension(300, 900));
	   	    
	    this.initComponents();
	}
	
	/*
	 * Getter et setter
	 */
	public FenetreBeAnArtist getFentreBeAnArtist(){
		return this.fenetreBeAnArtist;
	}
	
	public void setFenetreBeAnArtist(FenetreBeAnArtist fenetre){
		this.fenetreBeAnArtist = fenetre;
	}
	
	private void initComponents(){
		// Instanciation de l'actionEffacer ainsi que du bouton lié
		ActionEffacer actionEffacer = new ActionEffacer();
		BoutonAction boutonEffacer = new BoutonAction(ActionEffacer.NOM_ACTION, ActionEffacer.DEFINITION_ACTION);
		
		// Liaison entre l'action et le bouton
		boutonEffacer.addActionListener(actionEffacer);
		
		// /!\ EXTENSION /!\
		//boutonEffacer.setToolTipText("Efface toutes les formes");
		
		// Affichage des boutons dans le panneau
		GridLayout gl = new GridLayout(15,1);
		this.setLayout(gl);
		gl.setVgap(5);
		this.add(boutonEffacer);
		
		// De meme pour les boutons forme
		ActionForme actionRectangle = new ActionForme();
		ActionForme actionEllipse = new ActionForme();
		ActionForme actionCarre = new ActionForme();
		ActionForme actionCercle = new ActionForme();
		ActionForme actionLigne = new ActionForme();
		ActionForme actionTrace = new ActionForme();
		
		// Creation d'un ButtonGroup
		ButtonGroup groupeBouton = new ButtonGroup();
		
		BoutonToggleAction boutonRectangle = new BoutonToggleAction(ActionForme.NOM_ACTION_RECTANGLE,
				ActionForme.DEFINITION_ACTION_RECTANGLE);
		BoutonToggleAction boutonEllipse = new BoutonToggleAction(ActionForme.NOM_ACTION_ELLIPSE,
				ActionForme.DEFINITION_ACTION_ELLIPSE);
		BoutonToggleAction boutonCarre = new BoutonToggleAction(ActionForme.NOM_ACTION_CARRE,
				ActionForme.DEFINITION_ACTION_CARRE);
		BoutonToggleAction boutonCercle = new BoutonToggleAction(ActionForme.NOM_ACTION_CERCLE,
				ActionForme.DEFINITION_ACTION_CERCLE);
		BoutonToggleAction boutonLigne = new BoutonToggleAction(ActionForme.NOM_ACTION_LIGNE,
				ActionForme.DEFINITION_ACTION_LIGNE);
		BoutonToggleAction boutonTrace = new BoutonToggleAction(ActionForme.NOM_ACTION_TRACE,
				ActionForme.DEFINITION_ACTION_TRACE);
		
		// Liaison action bouton
		boutonRectangle.addActionListener(actionRectangle);
		boutonEllipse.addActionListener(actionEllipse);
		boutonCarre.addActionListener(actionCarre);
		boutonCercle.addActionListener(actionCercle);
		boutonLigne.addActionListener(actionLigne);
		boutonTrace.addActionListener(actionTrace);
		
		// Ajout des boutons dans le groupe de boutons
		groupeBouton.add(boutonRectangle);
		groupeBouton.add(boutonCarre);
		groupeBouton.add(boutonLigne);
		groupeBouton.add(boutonCercle);
		groupeBouton.add(boutonEllipse);
		groupeBouton.add(boutonTrace);
		
		this.add(boutonRectangle);
		this.add(boutonEllipse);
		this.add(boutonCarre);
		this.add(boutonCercle);
		this.add(boutonLigne);
		this.add(boutonTrace);
		
		// Outil selection
		ActionSelectionner actionSelection = new ActionSelectionner();
		BoutonToggleAction boutonSelection = new BoutonToggleAction(ActionSelectionner.NOM_ACTION,
				ActionSelectionner.DEFINITION_ACTION_SELECTIONNER);
		boutonSelection.addActionListener(actionSelection);
		groupeBouton.add(boutonSelection);
		this.add(boutonSelection);
		
		// Outil choix couleur
		ActionChoisirCouleurLigne actionCouleur = new ActionChoisirCouleurLigne();
		BoutonAction boutonCouleur = new BoutonAction(ActionChoisirCouleurLigne.NOM_ACTION,
				ActionChoisirCouleurLigne.DEFINITION_ACTION);
		boutonCouleur.addActionListener(actionCouleur);
		this.add(boutonCouleur);	
		
		// Enregistrement du dessin
		ActionEnregistrer actionEnregistrer = new ActionEnregistrer();
		JButton boutonEnregistrer = new BoutonAction(ActionEnregistrer.NOM_ACTION, ActionEnregistrer.DEFINITION_ACTION);
		boutonEnregistrer.addActionListener(actionEnregistrer);
		this.add(boutonEnregistrer);
		
		// Ouvrir un ancien dessin
		ActionOuvrir actionOuvrir = new ActionOuvrir();
		JButton boutonOuvrir = new BoutonAction(ActionOuvrir.NOM_ACTION, ActionOuvrir.DEFINITION_ACTION);
		boutonOuvrir.addActionListener(actionOuvrir);
		this.add(boutonOuvrir);
		
		ActionRemplir actionRemplir = new ActionRemplir();
		JButton boutonRemplir = new BoutonAction(ActionRemplir.NOM_ACTION, ActionRemplir.DEFINITION_ACTION);
		boutonRemplir.addActionListener(actionRemplir);
		this.add(boutonRemplir);
		
		Slider sliderEpaisseur = new Slider(0, 20);
		this.add(sliderEpaisseur);
		
		
	}

}