package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionEnregistrer extends AbstractAction {

	/*
	 * Attributs
	 */
	public static final String NOM_ACTION = "ENREGISTRER";
	public static final String DEFINITION_ACTION = "Enregistre le dessin en cours dans un fichier .ser";
	
	/*
	 * Constructeur
	 */
	public ActionEnregistrer(){
		super(ActionEnregistrer.NOM_ACTION);
	}
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		
		// Ouverture d'une fenetre pour le nom de fichier
		String nameFile = JOptionPane.showInputDialog("Nom du fichier .ser :");
		
		// Ouverture d'un flux sur un fichier
		ObjectOutputStream oos;
		
		try {
			FileOutputStream file = new FileOutputStream(nameFile + ".ser");
			oos = new ObjectOutputStream(file);
			
			oos.writeObject(FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes());
			oos.close();
			
			JOptionPane pan = new JOptionPane();
			pan.showMessageDialog(null, "Fichier enregistré avec succès", 
					"Information", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane pan = new JOptionPane();
			pan.showMessageDialog(null, "Erreur lors de l'enregistrement", 
					"Information", JOptionPane.ERROR_MESSAGE);
		} 
		
		
	}
	
	

}
