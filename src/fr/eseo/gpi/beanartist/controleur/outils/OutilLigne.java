package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Ligne;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.formes.VueLigne;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilLigne extends OutilForme{

	/*
	 * Constructeur
	 */
	public OutilLigne(PanneauDessin panneauDessin){
		super(panneauDessin);
	}
	
	protected VueForme creerVueForme(){
		Ligne ligne = new Ligne(super.getDebut(), super.getFin().getX() - 
				super.getDebut().getX(), super.getFin().getY() - super.getDebut().getY());
		VueLigne vueLigne = new VueLigne(ligne);
		
		ligne.setCouleurLigne(super.getPanneauDessin().getCouleurLigneCourante());
		
		// /!\ EXTENSION /!\
		ligne.setEpaisseur(super.getPanneauDessin().getEpaisseur());
		
		return vueLigne;
	}
}