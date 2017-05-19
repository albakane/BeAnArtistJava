package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.*;
import fr.eseo.gpi.beanartist.vue.formes.*;
import fr.eseo.gpi.beanartist.vue.ui.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Outil implements MouseListener, MouseMotionListener{
	
	/*
	 * Attributs
	 */
	private PanneauDessin panneauDessin;
	private Point debut;
	private Point fin;

	/*
	 * Constructeur
	 */
	public Outil(PanneauDessin panneauDessin){
		this.panneauDessin = panneauDessin;
		this.associer(this.getPanneauDessin());
	}
	
	/*
	 * Getters et Setters
	 */
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	public void setPanneauDessin(PanneauDessin panneauDessin){
		this.panneauDessin = panneauDessin;
	}
	
	public Point getDebut(){
		return this.debut;
	}
	
	public Point getFin(){
		return this.fin;
	}
	
	public void setDebut(Point point){
		this.debut = point;
	}
	
	public void setFin(Point point){
		this.fin = point;
	}
	
	/*
	 * Methodes propres a la classe
	 */
	public void associer(PanneauDessin panneauDessin){
		// Supprime le lien entre l'outil et le panneau
		this.liberer();
		
		// Redefini le lien entre l'outil et le panneau
		this.panneauDessin.setOutilCourant(this);
		this.panneauDessin.addMouseListener(this);
		this.panneauDessin.addMouseMotionListener(this);
	}
	
	private void liberer(){
		if(this.panneauDessin.getOutilCourant() != null){
			this.panneauDessin.removeMouseListener(this.panneauDessin.getOutilCourant());
			this.panneauDessin.removeMouseMotionListener(this.panneauDessin.getOutilCourant());
		}
		this.panneauDessin.setOutilCourant(null);
	}
	
	public void mousePressed(MouseEvent event){
		this.debut = new Point(event.getX(), event.getY());
	}
	
	public void mouseReleased(MouseEvent event){
		this.fin = new Point(event.getX(), event.getY());
	}
	
	public void mouseClicked(MouseEvent event){
		
	}
	
	public void mouseDragged(MouseEvent event){
		// A definir dans OutilForme()
	}
	
	public void mouseMoved(MouseEvent event){
		// A definir
	}
	
	public void mouseEntered(MouseEvent event){
		// A definir
	}
	
	public void mouseExited(MouseEvent event){
		// A definir
	}

}
