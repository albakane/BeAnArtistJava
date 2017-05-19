package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.formes.VueRectangle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilRectangle extends OutilForme{
	
	/*
	 * Constructeur
	 */
	public OutilRectangle(PanneauDessin panneauDessin){
		super(panneauDessin);
	}
	
	protected VueForme creerVueForme(){
		double xP = Math.min(super.getDebut().getX(), super.getFin().getX());
		double yP = Math.min(super.getDebut().getY(), super.getFin().getY());
		
		double largeur = Math.abs(super.getDebut().getX() - super.getFin().getX());
		double hauteur = Math.abs(super.getDebut().getY() - super.getFin().getY());
		
		Rectangle rectangle = new Rectangle(new Point(xP, yP), largeur, hauteur);
		
		// Appliquer les modifs avant d'afficher la vue
		rectangle.setCouleurLigne(this.getPanneauDessin().getCouleurLigneCourante());
		
		// /!\ EXTENSION /!\
		rectangle.setRemplissage(this.getPanneauDessin().isRempli());
		rectangle.setEpaisseur(this.getPanneauDessin().getEpaisseur());
		
		VueRectangle vueRectangle = new VueRectangle(rectangle);
		
		return vueRectangle;
	}

}
