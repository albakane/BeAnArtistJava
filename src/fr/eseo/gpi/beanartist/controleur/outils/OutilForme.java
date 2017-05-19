package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.*;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public abstract class OutilForme extends Outil {
	
	/*
	 * Constructeur
	 */
	public OutilForme(PanneauDessin panneauDessin){
		super(panneauDessin);
	}
	
	public void mouseDragged(MouseEvent event){
		/*
		 * AJOUTER EN EXTENSION
		 * 
		 * Permet de : 
		 * - tracer les formes en direct
		 * - afficher les informations de la derniere figure cree
		 * - afficher le nombre de figures crees
		 */
		
		if(super.getPanneauDessin().getVueFormes().size() > 0)
			super.getPanneauDessin().getVueFormes().remove(super.getPanneauDessin().getVueFormes().size() - 1);
		
		super.setFin(new Point(event.getX(), event.getY()));
		super.getPanneauDessin().ajouterVueForme(this.creerVueForme());

		// /!\ EXTENSION /!\
		this.getPanneauDessin().getJLabelInfo().setText(this.creerVueForme().getForme().toString());
		this.getPanneauDessin().repaint();
		
		// /!\ EXTENSION /!\
		int nombreVues = this.getPanneauDessin().getVueFormes().size();
		this.getPanneauDessin().getjLabelNombreVues().setText("Forme(s) dessinnée(s) : " + Integer.toString(nombreVues));
		
		super.getPanneauDessin().repaint();
	}
	
	public void mouseReleased(MouseEvent event){
		super.mouseReleased(event);
		super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
		super.getPanneauDessin().repaint();
	}
	
	public void mouseClicked(MouseEvent event){
		if(event.getClickCount() == 2){
			// Definition des points debut et fin
			super.setDebut(new Point(event.getX(), event.getY()));
			super.setFin(new Point(this.getDebut().getX() + Forme.LARGEUR_PAR_DEFAUT,
					this.getDebut().getY() + Forme.HAUTEUR_PAR_DEFAUT));
			
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	protected abstract VueForme creerVueForme();
}
