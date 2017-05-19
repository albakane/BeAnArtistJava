package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.formes.VueTrace;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilTrace extends OutilForme{
	/*
	 * Attributs
	 */
	private Trace trace;
	
	/*
	 * Constructeur
	 */
	public OutilTrace(PanneauDessin panneau) {
		super(panneau);
	}
	
	/*
	 * Methodes lien forme - souris
	 */
	
	// Ecrire une methode vide revient a la définir comme vide
	public void mouseClicked(MouseEvent event) {}
	
	public void mousePressed(MouseEvent event) {
		this.trace = new Trace(new Point(event.getX(), event.getY()));
	}

	public void mouseDragged(MouseEvent event){
		this.trace.ajouterPoint(new Point(event.getX(), event.getY()));
		super.mouseDragged(event);
	}
	
	public void mouseReleased(MouseEvent event){
		super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
		super.getPanneauDessin().repaint();
	}

	
	protected VueForme creerVueForme() {
		
		this.trace.setCouleurLigne(super.getPanneauDessin().getCouleurLigneCourante());
		
		// /!\ EXTENSION /!\
		this.trace.setRemplissage(super.getPanneauDessin().isRempli());
		this.trace.setEpaisseur(super.getPanneauDessin().getEpaisseur());
		
		VueTrace vueTrace = new VueTrace(this.trace);
		
		return vueTrace;	
	}
}

