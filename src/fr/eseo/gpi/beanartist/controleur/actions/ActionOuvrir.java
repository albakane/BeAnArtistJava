package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.gpi.beanartist.vue.formes.*;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionOuvrir extends AbstractAction{
	
	/*
	 * Attributs
	 */
	public static final String NOM_ACTION = "OUVRIR";
	public static final String DEFINITION_ACTION = "Ouvre un dessin .ser enregistré auparavant";
	
	/*
	 * Constructeur
	 */
	public ActionOuvrir(){
		super(ActionOuvrir.NOM_ACTION);
	}

	@SuppressWarnings({ "resource", "static-access" })
	public void actionPerformed(ActionEvent e) {
		
		String nameFile = JOptionPane.showInputDialog("Nom fichier .ser à ouvrir : ");
		
		File file = new File(nameFile + ".ser");
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			
			@SuppressWarnings("unchecked")
			List<VueForme> listeVueForme = (List<VueForme>)ois.readObject();
			
			FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().clear();
			
			for(VueForme v : listeVueForme)
				FenetreBeAnArtist.getInstance().getPanneauDessin().ajouterVueForme(v);
			
			FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
			
			JOptionPane pan = new JOptionPane();
			pan.showMessageDialog(null, "Ouverture réussie", 
					"Information", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane pan = new JOptionPane();
			pan.showMessageDialog(null, "Echec de l'ouverture du fichier", 
					"Information", JOptionPane.WARNING_MESSAGE);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			JOptionPane pan = new JOptionPane();
			pan.showMessageDialog(null, "Echec de l'ouverture du fichier", 
					"Information", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
}
