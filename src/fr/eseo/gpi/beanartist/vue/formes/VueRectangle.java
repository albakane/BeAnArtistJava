package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Rectangle;

public class VueRectangle extends VueForme{
	
	private static final long serialVersionUID = 1;
	
	/*
	 * Constructeur
	 */
	public VueRectangle(Rectangle rectangle){
		super(rectangle);
	}
	
	/*
	 * Methode abstraite de VueForme
	 */
	public void affiche(Graphics2D g2D){
		// /!\ CHOIX COULEUR AVANT DE DESSINER LA FIGURE /!\
		// Sinon la première figure ne sera pas de la bonne couleur
		g2D.setColor(super.getForme().getCouleurLigne());

		// Modification epaissaur
		BasicStroke line = new BasicStroke(super.getForme().getEpaisseur() + .0f);
		g2D.setStroke(line);
		
		if(!super.getForme().isRempli())
			g2D.drawRect((int)super.getForme().getX(), (int)super.getForme().getY(), 
					(int)super.getForme().getLargeur(), (int)super.getForme().getHauteur());
		
		// EXTENSION
		else
			g2D.fillRect((int)super.getForme().getX(), (int)super.getForme().getY(), 
					(int)super.getForme().getLargeur(), (int)super.getForme().getHauteur());
	}

	
}
