package fr.eseo.gpi.beanartist.modele.formes;

public class Carre extends Rectangle{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Constructeurs
	 */
	public Carre(){
		super(Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(Point position){
		super(position, Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(double taille){
		super(taille, taille);
	}
	
	public Carre(double x, double y, double taille){
		super(x, y, taille, taille);
	}
	
	public Carre(Point position, double taille){
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

}
