package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;
import fr.eseo.gpi.beanartist.xml.LecteurXML;

public class ActionLecteurXML extends AbstractAction{
	
	public static final String NOM_ACTION = "LECTEUR XML";
	public static final String DEFINITION_ACTION = "Ouvre un dessin sauvegardé";
	
	public ActionLecteurXML(){
		super(ActionLecteurXML.NOM_ACTION);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LecteurXML lecteur = new LecteurXML();
		
		String nameFile = JOptionPane.showInputDialog("Nom du fichier .xml :");

		FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().clear();
		
		try {
			for(VueForme vueForme : lecteur.lisDessin(nameFile + ".xml")){
				FenetreBeAnArtist.getInstance().getPanneauDessin().ajouterVueForme(vueForme);
			}
			
			FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
