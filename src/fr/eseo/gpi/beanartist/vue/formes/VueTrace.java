package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Trace;

public class VueTrace extends VueForme{
	
	private static final long serialVersionUID = 1;
	
	/*
	 * Attributs
	 */
	private List<Point> listePoints = new ArrayList<Point>();
	
	/*
	 * Constructeur
	 */
	public VueTrace(Trace trace){
		super(trace);
		this.listePoints = trace.getPoints();
	}
	
	/*
	 * Methode affichage
	 */
	public void affiche(Graphics2D g2D){
		for(int i = 1; i < this.listePoints.size(); i++){
			
			// Création d'une ligne entre deux points successifs
			int xA = (int)this.listePoints.get(i - 1).getX();
			int yA = (int)this.listePoints.get(i - 1).getY();
			
			int xB = (int)this.listePoints.get(i).getX();
			int yB = (int)this.listePoints.get(i).getY();
			
			g2D.setColor(super.getForme().getCouleurLigne());
			
			BasicStroke line = new BasicStroke(super.getForme().getEpaisseur() + .0f);
			g2D.setStroke(line);
			
			g2D.drawLine(xA, yA, xB, yB);
		}
	}

}
