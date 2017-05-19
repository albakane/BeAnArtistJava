package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.Graphics2D;
import java.io.Serializable;

import fr.eseo.gpi.beanartist.modele.formes.Forme;

public abstract class VueForme implements Serializable{
	
	/*
	 * Attributs
	 */
	protected final Forme forme;
	private static final long serialVersionUID = 1;
	
	/*
	 * Constructeur
	 */
	public VueForme(Forme forme){
		this.forme = forme;
	}
	
	/*
	 * Getter
	 */
	public Forme getForme(){
		return this.forme;
	}

	/*
	 * Methode abstraite affichage de la forme
	 */
	public abstract void affiche(Graphics2D g2D);
}
