package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Ellipse;

public class VueEllipse extends VueForme {

	private static final long serialVersionUID = 1;
	
	/*
	 * Constructeur
	 */
	public VueEllipse(Ellipse ellipse){
		super(ellipse);
	}
	
	/*
	 * Methode abstraite
	 */
	public void affiche(Graphics2D g2D){
		// /!\ CHOIX COULEUR AVANT DE DESSINER LA FIGURE /!\
		// Sinon la première figure ne sera pas de la bonne couleur
		g2D.setColor(super.getForme().getCouleurLigne());
		
		// MOdification de l'epaisseur
		BasicStroke line = new BasicStroke(super.getForme().getEpaisseur() + .0f);
		g2D.setStroke(line);
		
		if(!super.getForme().isRempli())
			g2D.drawOval((int)super.getForme().getX(), (int)super.getForme().getY(), 
					(int)super.getForme().getLargeur(), (int)super.getForme().getHauteur());
		
		// EXTENSION
		else
			g2D.fillOval((int)super.getForme().getX(), (int)super.getForme().getY(), 
					(int)super.getForme().getLargeur(), (int)super.getForme().getHauteur());
	}
}
