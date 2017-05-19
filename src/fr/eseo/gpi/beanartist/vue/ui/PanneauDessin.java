package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;

public class PanneauDessin extends JPanel{
	
	/*
	 * Attributs
	 */
	public static final int LARGEUR_PAR_DEFAUT = 1200;
	public static final int HAUTEUR_PAR_DEFAUT = 900;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(189, 195, 199);
	public static final Color COULEUR_LIGNE_PAR_DEFAUT = new Color(51,51,51);
	public static final boolean REMPLISSAGE_PAR_DEFAUT = false;
	
	private List<VueForme> vueFormes = new ArrayList<VueForme>();
	private Outil outilCourant;
	private Color couleurLigneCourante;
	private boolean remplissage;
	private int epaisseur;
	
	private JLabel jLabelInfo;
	private JLabel jLabelNombreVues;
	private JLabel jLabelRempli;
	private JPanel panColor;
	
	/*
	 * Constructeur
	 */
	public PanneauDessin(int largeur, int hauteur, Color fond){
		
	    // Définition de sa couleur de fond
	    this.setBackground(fond);
	    
	    // Definition de ses dimensions
	    this.setPreferredSize(new Dimension(largeur, hauteur));
	    
	    // Definition des attributs a l'etat initial
	    this.couleurLigneCourante = PanneauDessin.COULEUR_LIGNE_PAR_DEFAUT;
	    this.remplissage = false;
	    this.epaisseur = 0;
	    
	    // /!\ EXTENSION /!\
	    this.jLabelInfo = new JLabel("");
	    this.jLabelNombreVues = new JLabel("Nombre de formes dessinées : ");
	    this.jLabelRempli = new JLabel("Remplissage : non");
	    
	    // Pour observer la couleur courante
	    panColor = new JPanel();
	    panColor.setBackground(this.getCouleurLigneCourante());
	    
	    this.add(jLabelInfo);
	    this.add(jLabelNombreVues);
	    this.add(panColor);
	    this.add(jLabelRempli);
	}
	
	/*
	 * Getters et Setters
	 */
	public List<VueForme> getVueFormes(){
		return this.vueFormes;
	}
	
	public Outil getOutilCourant() {
		return outilCourant;
	}

	public void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}

	public Color getCouleurLigneCourante() {
		return couleurLigneCourante;
	}

	public void setCouleurLigneCourante(Color couleurLigneCourante) {
		this.couleurLigneCourante = couleurLigneCourante;
	}

	public boolean isRempli() {
		return remplissage;
	}

	public void setRemplissage(boolean remplissage) {
		if(remplissage)
			this.remplissage = !this.isRempli();
		else
			this.remplissage = this.isRempli();
	}
	
	public JLabel getJLabelInfo(){
		return this.jLabelInfo;
	}
	
	public void setJLabelInfo(JLabel jlabel){
		this.jLabelInfo = jlabel;
	}
	
	public JLabel getjLabelNombreVues() {
		return jLabelNombreVues;
	}

	public void setjLabelNombreVues(JLabel jLabelNombreVues) {
		this.jLabelNombreVues = jLabelNombreVues;
	}
	
	public void setPanColor(Color couleurCourante){
		this.panColor.setBackground(couleurCourante);
	}

	public JLabel getJLabelRempli(){
		return this.jLabelRempli;
	}
	
	/*
	 * Methodes propres a PanneauDessin()
	 */
	public void ajouterVueForme(VueForme vueForme){
		this.vueFormes.add(vueForme);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		// Modification de g en Graphics2D : 
		Graphics2D g2D = (Graphics2D)g.create();
		
		// Modification de l'epaisseur du trait
		/*BasicStroke line = new BasicStroke(2.0f);
		g2D.setStroke(line);*/
		
		for(VueForme v : this.vueFormes){
			v.affiche(g2D);
		}
		
		g2D.dispose();
	}

	public int getEpaisseur() {
		return epaisseur;
	}

	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}

}
