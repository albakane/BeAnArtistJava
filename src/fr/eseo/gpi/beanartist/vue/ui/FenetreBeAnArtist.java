package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.BorderLayout;
import utile.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eseo.gpi.beanartist.controleur.outils.*;
import fr.eseo.gpi.beanartist.modele.formes.*;
import fr.eseo.gpi.beanartist.vue.formes.*;

public class FenetreBeAnArtist extends JFrame{
	
	/*
	 * Attributs
	 */
	public static final String TITRE_PAR_DEFAUT = "Be An Artist";
	private static FenetreBeAnArtist instance;
	private PanneauDessin panneauDessin;
	private PanneauBarreOutils panneauBarreOutils;
	private PanneauXML panneauXML;
	
	/*
	 * Constructeur privé
	 */
	private FenetreBeAnArtist(){
		super();
		// Creation de la fenetre de l'application
		this.setTitle(TITRE_PAR_DEFAUT);
		
		// Dimension de la fenetre
		this.setSize(1500, 900);
		
		// Positionnement de la fenetre au milieu de l'ecran
		this.setLocationRelativeTo(null);
		
		// Definition du layout
		this.setLayout(new BorderLayout());
		
		// Dimensionnement des panneaux
		this.panneauDessin = 
				new PanneauDessin(PanneauDessin.LARGEUR_PAR_DEFAUT,
						PanneauDessin.HAUTEUR_PAR_DEFAUT,
						PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
		this.panneauBarreOutils = new PanneauBarreOutils();
		this.panneauXML = new PanneauXML();
		
		// Ajout des panneaux dans la fenetre
		this.add(panneauDessin);
		this.add(panneauBarreOutils);
		this.add(panneauXML);
		
		// Redimensionner les panneaux
		this.add(this.panneauDessin, BorderLayout.WEST);
		this.add(this.panneauBarreOutils, BorderLayout.EAST);
		this.add(this.panneauXML, BorderLayout.NORTH);
		
		this.pack();
		
		// Fermeture du programme lors de la fermeture de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Getters des panneaux contenus dans le fenetre
	 */
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	public PanneauBarreOutils getPanneauBarreOutils(){
		return this.panneauBarreOutils;
	}
	
	/*
	 * Getter instance
	 */
	public static FenetreBeAnArtist getInstance(){	
		if(FenetreBeAnArtist.instance == null)
			FenetreBeAnArtist.instance = new FenetreBeAnArtist();
		return FenetreBeAnArtist.instance;
	}

	
}
