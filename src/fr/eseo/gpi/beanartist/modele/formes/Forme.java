package fr.eseo.gpi.beanartist.modele.formes;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Forme implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	/*
	 * Attributs
	 */
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	public static final Color COULEUR_LIGNE_PAR_DEFAUT = new Color(51,51,51);
	public static final boolean REMPLISSAGE_PAR_DEFAUT = false;
	
	private double largeur, hauteur;
	private Point position;
	private Color couleurLigne;
	private boolean remplissage;
	private int epaisseur;
	
	/*
	 * Constructeurs
	 */
	public Forme(){
		this(0, 0, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(Point position){
		this(position.getX(), position.getY(), Forme.LARGEUR_PAR_DEFAUT,
				Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(double largeur, double hauteur){
		this(0, 0, largeur, hauteur);
	}
	
	public Forme(Point position, double largeur, double hauteur){
		this(position.getX(), position.getY(), largeur, hauteur);
	}
	
	public Forme(double x, double y, double largeur, double hauteur){
		this.position = new Point(x,y);
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleurLigne = Forme.COULEUR_LIGNE_PAR_DEFAUT;
	}
	
	/*
	 * Setters
	 */
	public void setPosition(Point position){
		this.position = position;
	}
	
	public void setX(double x){
		this.position.setX(x);
	}
	
	public void setY(double y){
		this.position.setY(y);
	}
	
	public void setLargeur(double largeur){
		this.largeur = largeur;
	}
	
	public void setHauteur(double hauteur){
		this.hauteur = hauteur;
	}
	
	/*
	 * Mise en static du setCouleur pour appeler la couleur
	 * dans la classe ActionChoisirCouleur
	 * ----------------------------------------------------
	 *A VERIFIER
	 */
	public void setCouleurLigne(Color couleur){
		this.couleurLigne = couleur;
	}
	
	/*
	 * Getters
	 */
	public Point getPosition(){
		return this.position;
	}
	
	public double getX(){
		return this.position.getX();
	}
	
	public double getY(){
		return this.position.getY(); 
	}
	
	public double getLargeur(){
		return this.largeur;
	}
	
	public double getHauteur(){
		return this.hauteur;
	}
	
	public double getCadreMinX(){
		return this.getX();
	}
	
	public double getCadreMinY(){
		return this.getY();
	}
	
	public double getCadreMaxX(){
		return this.getX() + this.largeur;
	}
	
	public double getCadreMaxY(){
		return this.getY() + this.hauteur;
	}
	
	public Color getCouleurLigne(){
		return this.couleurLigne;
	}
	
	/*
	 * Methodes de deplacement
	 */
	public void deplacerDe(double dX, double dY){
		this.position.deplacerDe(dX, dY);
	}
	
	public void deplacerVers(double nX, double nY){
		this.position.deplacerVers(nX, nY);
	}
	
	/*
	 * Methode affichage
	 * [Rectangle] pos (10,10) dim 25 x 15 périmètre : 80 aire : 375
	 */
	public String toString(){
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
		
		return "[" + getClass().getSimpleName() + "] pos (" + df.format(this.getX()) + 
				" , " + df.format(this.getY()) + ") dim " + df.format(this.getLargeur()) + 
				" x " + df.format(this.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + 
				" aire : " + df.format(this.aire());
	}
	
//	private void readObject(ObjectInputStream ois) throws IOException,
//	ClassNotFoundException{
//		
//		this.largeur = ois.readInt(); this.hauteur = ois.readInt();
//		this.position = (Point) ois.readObject();
//		this.couleurLigne = (Color) ois.readObject();
//	}
//	
//	private void writeObject(ObjectOutputStream oos) throws IOException{
//		oos.writeDouble(this.largeur);
//		oos.writeDouble(this.hauteur);
//		oos.writeObject((Object) this.position);
//		oos.writeObject((Object) this.couleurLigne);
//	}
	
	/*
	 * Methodes abstraites
	 */
	public abstract double perimetre();
	
	public abstract double aire();
	
	public abstract boolean contient(Point position);
	
	public abstract boolean contient(double x, double y);

	// /!\ EXTENSION /!\
	
	public boolean isRempli() {
		return remplissage;
	}

	public void setRemplissage(boolean remplissage) {
		this.remplissage = remplissage;
	}

	public int getEpaisseur() {
		return epaisseur;
	}

	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}
}
