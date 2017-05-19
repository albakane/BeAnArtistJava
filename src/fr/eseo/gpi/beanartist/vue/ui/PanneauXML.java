package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.eseo.gpi.beanartist.controleur.actions.ActionEnregistrer;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEnregistrerSVG;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEnregistrerXML;
import fr.eseo.gpi.beanartist.controleur.actions.ActionLecteurXML;
import fr.eseo.gpi.beanartist.controleur.bouton.BoutonAction;

public class PanneauXML extends JPanel{
	
	public PanneauXML(){
		this.setPreferredSize(new Dimension(1500, 30));
		this.setBackground(new Color(52, 73, 94));
		this.initComponents();
	}

	private void initComponents(){
		// Association des actions XML aux boutons
		GridLayout gl = new GridLayout(1, 6);
		this.setLayout(gl);
		gl.setHgap(5);
		
		BoutonAction boutonLecteurXML = new BoutonAction(ActionLecteurXML.NOM_ACTION,
				ActionLecteurXML.DEFINITION_ACTION);
		boutonLecteurXML.addActionListener(new ActionLecteurXML());
		
		BoutonAction boutonEnregistrerXML = new BoutonAction(ActionEnregistrerXML.NOM_ACTION,
				ActionEnregistrerXML.DEFINITION_ACTION);
		boutonEnregistrerXML.addActionListener(new ActionEnregistrerXML());
		
		BoutonAction boutonEnregistrerSVG = new BoutonAction(ActionEnregistrerSVG.NOM_ACTION,
				ActionEnregistrerSVG.DEFINITION_ACTION);
		boutonEnregistrerSVG.addActionListener(new ActionEnregistrerSVG());
		
		JPanel pane1 = new JPanel();
		pane1.setBackground(new Color(52, 73, 94));
		JPanel pane2 = new JPanel();
		pane2.setBackground(new Color(52, 73, 94));
		JPanel pane3 = new JPanel();
		pane3.setBackground(new Color(52, 73, 94));
		
		this.add(boutonLecteurXML);
		this.add(boutonEnregistrerXML);
		this.add(boutonEnregistrerSVG);
		this.add(pane1);
		this.add(pane2);
		this.add(pane3);
	}
}
