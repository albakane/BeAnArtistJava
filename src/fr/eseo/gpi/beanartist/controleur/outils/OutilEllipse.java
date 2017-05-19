package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Ellipse;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.formes.VueEllipse;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilEllipse extends OutilForme{
	
	/*
	 * Constructeur
	 */
	public OutilEllipse(PanneauDessin panneauDessin){
		super(panneauDessin);
	}
	
	protected VueForme creerVueForme(){
		double xP = Math.min(super.getDebut().getX(), super.getFin().getX());
		double yP = Math.min(super.getDebut().getY(), super.getFin().getY());
		
		double largeur = Math.abs(super.getDebut().getX() - super.getFin().getX());
		double hauteur = Math.abs(super.getDebut().getY() - super.getFin().getY());
		
		Ellipse ellipse = new Ellipse(new Point(xP, yP), largeur, hauteur);
		
		ellipse.setCouleurLigne(super.getPanneauDessin().getCouleurLigneCourante());
		
		// /!\ EXTENSION /!\
		ellipse.setRemplissage(super.getPanneauDessin().isRempli());
		ellipse.setEpaisseur(super.getPanneauDessin().getEpaisseur());
		
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		
		return vueEllipse;
	}

}
