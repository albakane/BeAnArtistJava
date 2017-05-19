package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilSelection extends Outil{
	
	/*
	 * Attributs
	 */
	private Forme formeSelectionnee;
	
	/*
	 * Constructueur
	 */
	public OutilSelection(PanneauDessin panneau){
		super(panneau);
	}
	
	/*
	 * Methode utilisee pour la souris
	 */
	public void mouseClicked(MouseEvent event){
		Point position = new Point(event.getX(), event.getY());
		
		// Boucle while pour récuperer la derniere forme cree
		int i = super.getPanneauDessin().getVueFormes().size() - 1;
		boolean contient = false;
		
		while(i >= 0 && contient == false){
			if(super.getPanneauDessin().getVueFormes().get(i).getForme().contient(position)){
				this.formeSelectionnee = super.getPanneauDessin().getVueFormes().get(i).getForme();
				
				// /!\ EXTENSION /!\
				this.formeSelectionnee.setCouleurLigne(FenetreBeAnArtist.getInstance().getPanneauDessin().getCouleurLigneCourante());
				this.formeSelectionnee.setEpaisseur(FenetreBeAnArtist.getInstance().getPanneauDessin().getEpaisseur());
				this.formeSelectionnee.setRemplissage(FenetreBeAnArtist.getInstance().getPanneauDessin().isRempli());
				
				FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
				contient = true;
			} else
				i--;
		}
		
	}
	
	public void mouseEntered(MouseEvent event){
		
	}

}
