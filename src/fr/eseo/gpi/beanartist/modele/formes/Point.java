package fr.eseo.gpi.beanartist.modele.formes;

import java.io.Serializable;

public class Point implements Serializable {
	
	/*
	 * Attributs
	 */
	private double x, y;
	private static final long serialVersionUID = 1;
	
	/*
	 * Constructeurs
	 */
	public Point(){
		this.setX(0); this.setY(0);
	}
	
	public Point(double x, double y){
		this.setX(x); this.setY(y);
	}
	
	/*
	 * Setters et getters
	 */
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	/*
	 * Methodes propres à la classe
	 */
	public void deplacerDe(double dX, double dY){
		this.setX(this.x + dX); this.setY(this.y + dY);
	}
	
	public void deplacerVers(double nX, double nY){
		this.setX(nX); this.setY(nY);
	}
	
	/*
	 * Methode affichage
	 */
	public String toString(){
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
		return "(" + df.format(this.getX()) + " , " + 
					 df.format(this.getY()) + ")";
	}

}
