package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;
import fr.eseo.gpi.beanartist.xml.EnregistreurSVG;

public class ActionEnregistrerSVG extends AbstractAction{

	public static final String NOM_ACTION = "ENREGISTRER DESSIN SVG";
	public static final String DEFINITION_ACTION = "Enregistre un dessin au format SVG";
	
	public ActionEnregistrerSVG(){
		super(ActionEnregistrerSVG.NOM_ACTION);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameFile = JOptionPane.showInputDialog("Nom du fichier .svg :");
		
		EnregistreurSVG enregistreur = new EnregistreurSVG();
		try {
			enregistreur.enregistreDessin(nameFile + ".svg", FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}
	
}
