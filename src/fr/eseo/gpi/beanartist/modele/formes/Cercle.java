package fr.eseo.gpi.beanartist.modele.formes;

public class Cercle extends Ellipse{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Constructeurs
	 */
	public Cercle(){
		super(Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Point position){
		super(position, Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille){
		super(taille, taille);
	}
	
	public Cercle(double x, double y, double taille){
		super(x, y, taille, taille);
	}
	
	public Cercle(Point position, double taille){
		super(position, taille, taille);
	}
	
	/*
	 * Setters
	 */
	public void setLargeur(double largeur){
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	public void setHauteur(double hauteur){
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
	
	/*
	 * Methode propre a Cercle()
	 */
	public double perimetre(){
		return Math.PI * super.getHauteur();
	}

}
