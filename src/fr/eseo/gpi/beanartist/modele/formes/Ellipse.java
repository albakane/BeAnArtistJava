package fr.eseo.gpi.beanartist.modele.formes;

public class Ellipse extends Forme{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public Ellipse(){
		super();
	}
	
	public Ellipse(Point position){
		super(position);
	}
	
	public Ellipse(double largeur, double hauteur){
		if(largeur < 0 || hauteur < 0)
			throw new IllegalArgumentException("valeur negative");
		else {
			super.setHauteur(hauteur);
			super.setLargeur(largeur);
			super.setPosition(new Point());
		}
	}
	
	public Ellipse(double x, double y, double largeur, double hauteur){
		if(largeur < 0 || hauteur < 0)
			throw new IllegalArgumentException("valeur negative");
		else {
			super.setHauteur(hauteur);
			super.setLargeur(largeur);
			super.setPosition(new Point(x,y));
		}
	}
	
	public Ellipse(Point position, double largeur, double hauteur){
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
		double a = super.getLargeur()/2;
		double b = super.getHauteur()/2;
		double h = Math.pow((a - b)/(a + b), 2);
		double module = 1 + (3*h)/(10 + Math.sqrt(4 - 3 * h));
		
		return Math.PI * (a + b) * module;
	}
	
	public double aire(){
		double a = super.getLargeur()/2;
		double b = super.getHauteur()/2;
		
		return Math.PI * a * b;
	}
	
	
	public boolean contient(Point position){
		double a = this.getLargeur()/2;
		double b = this.getHauteur()/2;
		
		double cx = this.getX() + a;
		double cy = this.getY() + b;
		
		double resultat = Math.pow((position.getX() - cx)/a, 2) + 
				Math.pow((position.getY() - cy)/b, 2);
		
		return resultat <= 1;
	}
	
	public boolean contient(double x, double y){
		double a = getLargeur()/2; 
		double b = getHauteur()/2;
		
		double cx = getX() + a; 
		double cy = getY() + b;
		
		double resultat = Math.pow((x - cx)/a, 2) + Math.pow((y - cy)/b, 2);
		
		return resultat <= 1;
	}

}
