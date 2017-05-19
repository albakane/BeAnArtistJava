package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Carre;
import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.formes.VueCarre;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilCarre extends OutilForme{
	
	/*
	 * Constructeur
	 */
	public OutilCarre(PanneauDessin panneauDessin){
		super(panneauDessin);
	}
	
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
		double max = Math.max(Math.abs(super.getFin().getX() - super.getDebut().getX()), 
				Math.abs(super.getFin().getY() - super.getDebut().getY()));
		
		Carre carre;
		
		double dx = super.getDebut().getX();
		double dy = super.getDebut().getY();
		double fx = super.getFin().getX();
		double fy = super.getFin().getY();
		
		if(dx > fx && dy > fy)
			carre = new Carre(dx - max, dy - max, max);
		else if(dx > fx && dy < fy)
			carre = new Carre(dx - max, dy, max);
		else if(dx < fx && dy > fy)
			carre = new Carre(dx, dy - max, max);
		else
			carre = new Carre(dx, dy, max);
			
		carre.setCouleurLigne(super.getPanneauDessin().getCouleurLigneCourante());
		
		// /!\ EXTENSION /!\
		carre.setRemplissage(super.getPanneauDessin().isRempli());
		carre.setEpaisseur(super.getPanneauDessin().getEpaisseur());
		
		VueCarre vueCarre = new VueCarre(carre);
		
		return vueCarre;
	}

}
