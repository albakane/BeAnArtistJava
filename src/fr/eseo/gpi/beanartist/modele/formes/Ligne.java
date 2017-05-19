package fr.eseo.gpi.beanartist.modele.formes;

public class Ligne extends Forme {

	/*
	 * Attributs
	 */
	public static final double EPSILON = 0.99;
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public Ligne(){
		this(0, 0, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Ligne(Point position){
		this(position.getX(), position.getY(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Ligne(double largeur, double hauteur){
		this(0, 0, largeur, hauteur);
	}
	
	public Ligne(Point position, double largeur, double hauteur){
		this(position.getX(), position.getY(), largeur, hauteur);
	}
	
	public Ligne(double x, double y, double largeur, double hauteur){
		super(x, y, largeur, hauteur);
	}
	
	/*
	 * Setters et getters
	 */
	public Point getP1(){
		return super.getPosition();
	}
	
	public Point getP2(){
		Point p2 = new Point(this.getP1().getX() + super.getLargeur(),
				this.getP1().getY() + super.getHauteur());
		return p2;
	}
	
	public void setP1(Point p1){
		super.setLargeur(this.getP2().getX() - p1.getX());
		super.setHauteur(this.getP2().getY() - p1.getY());
		
		super.setPosition(p1);
	}
	
	public void setP2(Point p2){
		super.setLargeur(p2.getX() - this.getP1().getX());
		super.setHauteur(p2.getY() - this.getP1().getY());
	}
	
	public double getCadreMinX(){
		return Math.min(this.getP1().getX(), this.getP2().getX());
	}
	
	public double getCadreMinY(){
		return Math.min(this.getP1().getY(), this.getP2().getY());
	}
	
	public double getCadreMaxX(){
		return Math.max(this.getP1().getX(), this.getP2().getX());
	}
	
	public double getCadreMaxY(){
		return Math.max(this.getP1().getY(), this.getP2().getY());
	}
	
	/*
	 * Methodes abstraites
	 */
	public double aire(){
		return 0;
	}
	
	public double perimetre(){
		return Math.sqrt(Math.pow(this.getP2().getX() - this.getP1().getX(), 2) + 
				Math.pow(this.getP2().getY() - this.getP1().getY(), 2));
	}
	
	public boolean contient(Point position){
		Ligne P1P = new Ligne(this.getP1(), position.getX() - this.getP1().getX(),
				position.getY() - this.getP1().getY());
		Ligne P2P = new Ligne(this.getP2(), position.getX() - this.getP2().getX(),
				position.getY() - this.getP2().getY());
		return P1P.perimetre() + P2P.perimetre() - this.perimetre() <= Ligne.EPSILON;
	}
	
	public boolean contient(double x, double y){
		Ligne P1P = new Ligne(this.getP1(), x - this.getP1().getX(),
				y - this.getP1().getY());
		Ligne P2P = new Ligne(this.getP2(), x - this.getP2().getX(),
				y - this.getP2().getY());
		return P1P.perimetre() + P2P.perimetre() - this.perimetre() <= Ligne.EPSILON;
	}
	
	/*
	 * Methode affichage
	 * [Ligne] p1 : (10 , 10) p2 : (5 , 30) longueur : 25
	 */
	public String toString(){
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
		
		return "[" + getClass().getSimpleName() + "] p1 : (" + 
		df.format(this.getP1().getX()) + " , " + 
		df.format(this.getP1().getY()) + ") p2 : (" + 
		df.format(this.getP2().getX()) + " , " + 
		df.format(this.getP2().getY()) + ") longueur : " + 
		df.format(this.perimetre());
	}
	
}
