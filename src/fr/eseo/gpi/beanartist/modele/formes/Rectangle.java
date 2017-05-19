package fr.eseo.gpi.beanartist.modele.formes;

public class Rectangle extends Forme{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public Rectangle(){
		super();
	}
	
	public Rectangle(Point position){
		super(position);
	}
	
	public Rectangle(double largeur, double hauteur){
		if(largeur < 0 || hauteur < 0)
			throw new IllegalArgumentException("valeur negative");
		else {
			super.setPosition(new Point());
			super.setHauteur(hauteur);
			super.setLargeur(largeur);
		}
	}
	
	public Rectangle(double x, double y, double largeur, double hauteur){
		if(largeur < 0 || hauteur < 0)
			throw new IllegalArgumentException("valeur negative");
		else {
			super.setHauteur(hauteur);
			super.setLargeur(largeur);
			super.setPosition(new Point(x,y));
		}
	}
	
	public Rectangle(Point position, double largeur, double hauteur){
		if(largeur < 0 || hauteur < 0)
			throw new IllegalArgumentException("valeur negative");
		else {
			super.setHauteur(hauteur);
			super.setLargeur(largeur);
			super.setPosition(position);
		}
	}
	
	/*
	 * Getters et Setters
	 */
	public void setLargeur(double largeur){
		if(largeur < 0)
			throw new IllegalArgumentException("largeur < 0");
		else 
			super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur){
		if(hauteur < 0)
			throw new IllegalArgumentException("hauteur < 0");
		else
			super.setHauteur(hauteur);
	}
	
	/*
	 * Methodes abstraites
	 */
	public double perimetre(){
		return 2 * (super.getLargeur() + super.getHauteur());
	}
	
	public double aire(){
		return super.getLargeur() * super.getHauteur();
	}
	
	public boolean contient(Point position){
		return super.getCadreMinX() < position.getX() &&
				position.getX() < super.getCadreMaxX() &&
				super.getCadreMinY() < position.getY() &&
				position.getY() < super.getCadreMaxY();
	}
	
	public boolean contient(double x, double y){
		return super.getCadreMinX() < x &&
				x < super.getCadreMaxX() &&
				super.getCadreMinY() < y &&
				y < super.getCadreMaxY();
	}

}
