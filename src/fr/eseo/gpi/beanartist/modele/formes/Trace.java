package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Trace extends Forme{
	
	/*
	 * Attributs
	 */
	private List<Point> points  = new ArrayList<Point>(); 
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public Trace(Point position1, Point position2){
		this.ajouterPoint(position1);
		this.ajouterPoint(position2);
	}

	public Trace(Point position1){
		this.ajouterPoint(position1);
	}
	
	/*
	 * Methode particuliere qui calcule la position, 
	 * hauteur et largeur de la forme a chaque appel
	 */
	public void calcul(){
		
		double xMin = Double.MAX_VALUE;
		double yMin = Double.MAX_VALUE;
		double xMax = Double.MIN_VALUE;
		double yMax = Double.MIN_VALUE;
		
		for (Point p : this.points){
			
			xMin = Math.min(xMin, p.getX());
			yMin = Math.min(yMin, p.getY());
			xMax = Math.max(xMax, p.getX());
			yMax = Math.max(yMax, p.getY());
		}
		
		super.setLargeur(xMax - xMin);
		super.setHauteur(yMax - yMin);
		super.setPosition(new Point(xMin, yMin));
		
	}

	/*
	 * Getter
	 */
	public List<Point> getPoints(){
		return this.points;
	}
	
	/*
	 * Setters
	 */
	public void setX(double x){
		this.deplacerVers(x, super.getY());
	}
	
	public void setY(double y){
		this.deplacerVers(super.getX(), y);
	}

	public void setPosition(Point position){
		this.setX(position.getX());
		this.setY(position.getY());
	}
	
	public void setLargeur(double largeur){
		
		if(this.getPoints() != null){
			
			double memoLargeur = this.getLargeur();
			double coefficient = largeur/memoLargeur;
		
			for (Point p : this.points)
				p.deplacerVers(getX() + (p.getX() - getX()) *
						coefficient, p.getY());
		}
		
		super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur){
		
		if(this.getPoints() != null){
			double memoHauteur = this.getHauteur();
			double coefficient = hauteur/memoHauteur;
		
			for (Point p : this.points)
				p.deplacerVers(p.getX(), getY() + (p.getY() 
						- getY()) * coefficient);
			}
		
		super.setHauteur(hauteur);
	}
	
	/*
	 * Methode propres a la classe
	 */
	public void ajouterPoint(Point position){
		this.points.add(position);
		this.calcul();
	}
	
	public void deplacerDe(double dX, double dY){
		for(Point p : this.points)
			p.deplacerDe(dX, dY);
	}
	
	public void deplacerVers(double nX, double nY){
		/*
		 * Difference entre la valeur rentree et les coordonnees de 
		 * la position du trace
		 * nX - super.getX() = 0 pour le point egal a la position
		 */
		for(Point p : this.points)
			p.deplacerDe(nX - super.getX(), nY - super.getY());
	}
	
	/*
	 * Methodes abstraites
	 */
	public boolean contient(Point position) {
		boolean contient = false;
		for (int i = 0; i < this.points.size() - 1; i++){
			Point p1 = this.points.get(i);
			Point p2 = this.points.get(i+1);
			Ligne ligne = new Ligne(p1, p2.getX() - p1.getX(), 
					p2.getY() - p1.getY());
			if (ligne.contient(position))
				contient=true;
		}
		return contient;
	}

	
	public boolean contient(double x, double y) {
		return this.contient(new Point(x, y));
	}

	
	public double aire() {
		return 0;
	}

	
	public double perimetre() {
		double perim = 0;
		
		for(int i = 0; i < this.points.size() - 1; i++){
			Ligne ligne = new Ligne(points.get(i));
			ligne.setP2(points.get(i + 1));
			perim += ligne.perimetre();
		}
		
		return perim;
	}
	
	/*
	 * Methode affichage
	 */
	public String toString(){
		DecimalFormat df= new DecimalFormat("#####.##");
		return "[" + getClass().getSimpleName() + "] " + 
				"pos : " + super.getPosition() +
				" dim : " + df.format(super.getLargeur()) +
				" x " + df.format(super.getHauteur()) +
				" longueur : " + df.format(this.perimetre()) +
				" nbSegments : " + df.format(this.points.size() - 1);
	}
	
}