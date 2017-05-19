package fr.eseo.gpi.beanartist;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.vue.ui.*;

public class BeAnArtist {
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
			
				FenetreBeAnArtist.getInstance().setVisible(true);
			
			}
		
		});
	
	}

}
