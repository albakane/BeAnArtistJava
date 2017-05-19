package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Cercle;
import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.formes.VueCercle;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilCercle extends OutilForme{

	/*
	 * Constructeur
	 */
	public OutilCercle(PanneauDessin panneauDessin){
		super(panneauDessin);
	}
	
	// Reecriture de la methode mouseClicked pour modifier la largeur par defaut
	public void mouseClicked(MouseEvent event){
		if(event.getClickCount() == 2){
			// Definition des point debut et fin
			super.setDebut(new Point(event.getX(), event.getY()));
			super.setFin(new Point(this.getDebut().getX() + Forme.LARGEUR_PAR_DEFAUT,
					this.getDebut().getY() + Forme.LARGEUR_PAR_DEFAUT));
			
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	/*
	 * Methode recuperee sur Thomas EHLING
	 */
	protected VueForme creerVueForme(){
		
		Cercle cercle;
		
		double dx = super.getDebut().getX();
		double dy = super.getDebut().getY();
		double fx = super.getFin().getX();
		double fy = super.getFin().getY();
		
		double max = Math.max(Math.abs(fx - dx), Math.abs(fy - dy));
		
		if(dx > fx && dy > fy)
			cercle = new Cercle(dx - max, dy - max, max);
		else if(dx > fx && dy < fy)
			cercle = new Cercle(dx - max, dy, max);
		else if(dx < fx && dy > fy)
			cercle = new Cercle(dx, dy - max, max);
		else
			cercle = new Cercle(dx, dy, max);
		
		cercle.setCouleurLigne(super.getPanneauDessin().getCouleurLigneCourante());
		
		// /!\ EXTENSION /!\
		cercle.setRemplissage(super.getPanneauDessin().isRempli());
		cercle.setEpaisseur(super.getPanneauDessin().getEpaisseur());
		
		VueCercle vueCercle = new VueCercle(cercle);
		
		return vueCercle;
	}
}
