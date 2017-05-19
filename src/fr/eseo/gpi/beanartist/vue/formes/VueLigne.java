package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Ligne;

public class VueLigne extends VueForme{

	private static final long serialVersionUID = 1;
	
	/*
	 * Constructeur
	 */
	public VueLigne(Ligne ligne){
		super(ligne);
	}
	
	/*
	 * Methode abstraite
	 */
	public void affiche(Graphics2D g2D){
		g2D.setColor(super.getForme().getCouleurLigne());
		
		BasicStroke line = new BasicStroke(super.getForme().getEpaisseur() + .0f);
		g2D.setStroke(line);
		
		Ligne ligne = new Ligne(super.getForme().getPosition(),
				super.getForme().getLargeur(), super.getForme().getHauteur());
		g2D.drawLine((int)ligne.getP1().getX(), (int)ligne.getP1().getY(), 
				(int)ligne.getP2().getX(), (int)ligne.getP2().getY());
	}
}