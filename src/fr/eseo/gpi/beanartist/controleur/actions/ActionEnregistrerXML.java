package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;
import fr.eseo.gpi.beanartist.xml.EnregistreurXML;

public class ActionEnregistrerXML extends AbstractAction{
	
	public static final String NOM_ACTION = "ENREGISTRER DESSIN XML";
	public static final String DEFINITION_ACTION = "Enregistre le dessin au format XML";

	public ActionEnregistrerXML(){
		super(ActionEnregistrer.NOM_ACTION);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EnregistreurXML enregistreur = new EnregistreurXML();
		
		String nameFile = JOptionPane.showInputDialog("Nom du fichier .xml :");
		
		try {
			enregistreur.enregistreDessin(nameFile + ".xml", 
					FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

}
