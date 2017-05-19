package fr.eseo.gpi.beanartist.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.eseo.gpi.beanartist.modele.formes.Carre;
import fr.eseo.gpi.beanartist.modele.formes.Cercle;
import fr.eseo.gpi.beanartist.modele.formes.Ellipse;
import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Ligne;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;

/**
 * Un enregistreur XML est un processeur DOM responsable de l'enregistrement
 * d'un dessin au format XML défini par l'application.
 * 
 * Il utilise les méthodes héritées de la classe ProcesseurDOM pour créer un
 * document DOM et l'enregistrer dans un fichier XML, ainsi que les méthodes
 * d'écriture des entiers.
 * 
 * Les méthodes enregistreDessin et creeElementXxxx devront être complétées. Des
 * méthodes utilitaires pourront venir compléter celles définies par la classe
 * ProcesseurDOM ; elles devront dans ce cas être OBLIGATOIREMENT définies en
 * "private" à la fin de la classe EnregistreurXML.
 *
 */
public class EnregistreurXML extends ProcesseurDOM {

	/**
	 * Lance le test d'enristrement (méthode teste) avec le fichier XML d'entrée
	 * nommé "S30-Dessin-in.xml" et le fichier XML de sortie nommé
	 * "S30-Dessin-out.xml".
	 * 
	 * Ce test MANUEL doit OBLIGATOIREMENT passer avant de commencer la gestion
	 * de l'enregistrement en SVG (classe EnregistreurSVG). Il est INDISPENSABLE
	 * de vérifier la conformité entre les fichiers d'entrée et de sortie. Il
	 * peut subsister des différentces normales entre ces deux fichiers (par
	 * exemple pour les valeurs par défaut telles que la couleur de remplissage
	 * des vues). De plus, l'affichage du fichier de sortie doit être conforme à
	 * ce qui est attendu.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		teste("S30-Dessin-in.xml", "S30-Dessin-out.xml");
	}

	/**
	 * Teste l'enregistrement du dessin dans un fichier XML. Le fichier XML
	 * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie.
	 * Le fichier de sortie est ensuite chargé et visualisé par l'application.
	 * 
	 * @param nomFichierEntrée le nom du fichier XML d'entrée lu
	 * @param nomFichierSortie le nom du fichier XML de sortie écrit puis
	 *            affiché
	 * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
	 *             valide
	 */
	public static void teste(String nomFichierEntrée, String nomFichierSortie) throws FileNotFoundException {
		LecteurXML lecteur = new LecteurXML();
		final List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
		EnregistreurXML enregistreur = new EnregistreurXML();
		enregistreur.enregistreDessin(nomFichierSortie, dessin);
		LecteurXML.teste(nomFichierSortie);
	}

	/**
	 * Enregistre le dessin donné dans un fichier.
	 * @param nomFichier le nom du fichier de sauvegarde
	 * @param dessin le dessin formé de la liste des vues des formes
	 * @throws FileNotFoundException si le nom du fichier n'est pas valide
	 */
	public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws FileNotFoundException {
		creeDocumentXML("dessin");
		Element racine = getDocument().getDocumentElement();
		// Pour chaque vue du dessin, créer un élément DOM associé et l'ajouter
		// dans l'élément racine du document.
		// à compléter
		for(int i = 0; i < dessin.size(); i++){
			if(dessin.get(i) != null){
				Forme forme = dessin.get(i).getForme();
				racine.appendChild(this.creeElementForme(forme));
			}
		}
		
		enregistreDocument(nomFichier);
	}

	/**
	 * Crée un élément DOM représentant la forme donnée et retourne cet élément.
	 * Cette méthode invoque les méthodes creeElement<Forme> en fonction du type
	 * de la forme.
	 * @param forme la forme
	 * @return l'élément DOM représentant la forme
	 */
	public Element creeElementForme(Forme forme) {
		Element element;
		String nom = forme.getClass().getSimpleName();
		if (nom.equals("Rectangle")) {
			element = creeElementRectangle((Rectangle) forme);
		} else if (nom.equals("Carre")) {
			element = creeElementCarre((Carre) forme);
		} else if (nom.equals("Ellipse")) {
			element = creeElementEllipse((Ellipse) forme);
		} else if (nom.equals("Cercle")) {
			element = creeElementCercle((Cercle) forme);
		} else if (nom.equals("Ligne")) {
			element = creeElementLigne((Ligne) forme);
		} else if (nom.equals("Trace")) {
			element = creeElementTrace((Trace) forme);
		} else {
			throw new Error("Forme non gérée");
		}
		Color couleur = forme.getCouleurLigne();
		element.setAttribute("couleur", couleur.getRed() + " " + couleur.getGreen()
		+ " " + couleur.getBlue());
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le rectangle donné.
	 * @param forme le rectangle
	 * @return élément DOM représentant le rectangle
	 */
	public Element creeElementRectangle(Rectangle forme) {
		Element element = super.getDocument().createElement("Rectangle");
		
		super.ecrisAttribut(element, "x", forme.getX());
		super.ecrisAttribut(element, "y", forme.getY());
		super.ecrisAttribut(element, "largeur", forme.getLargeur());
		super.ecrisAttribut(element, "hauteur", forme.getHauteur());
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le carré donné.
	 * @param forme le carré
	 * @return élément DOM représentant le carré
	 */
	public Element creeElementCarre(Rectangle forme) {
		Element element = super.getDocument().createElement("Carre");
		
		super.ecrisAttribut(element, "x", forme.getX());
		super.ecrisAttribut(element, "y", forme.getY());
		super.ecrisAttribut(element, "largeur", forme.getLargeur());
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant l'ellipse donnée.
	 * @param forme l'ellipse
	 * @return élément DOM représentant l'ellipse
	 */
	public Element creeElementEllipse(Ellipse forme) {
		Element element = super.getDocument().createElement("Ellipse");
		
		super.ecrisAttribut(element, "x", forme.getX());
		super.ecrisAttribut(element, "y", forme.getY());
		super.ecrisAttribut(element, "largeur", forme.getLargeur());
		super.ecrisAttribut(element, "hauteur", forme.getHauteur());
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le cercle donné.
	 * @param forme le cercle
	 * @return élément DOM représentant le cercle
	 */
	public Element creeElementCercle(Cercle forme) {
		Element element = super.getDocument().createElement("Cercle");
		
		super.ecrisAttribut(element, "x", forme.getX());
		super.ecrisAttribut(element, "y", forme.getY());
		super.ecrisAttribut(element, "largeur", forme.getLargeur());
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant la ligne donnée.
	 * @param forme la ligne
	 * @return élément DOM représentant la ligne
	 */
	public Element creeElementLigne(Ligne forme) {
		Element element = super.getDocument().createElement("Ligne");
		
		super.ecrisAttribut(element, "x", forme.getX());
		super.ecrisAttribut(element, "y", forme.getY());
		super.ecrisAttribut(element, "largeur", forme.getLargeur());
		super.ecrisAttribut(element, "hauteur", forme.getHauteur());
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le tracé donné.
	 * @param forme le tracé
	 * @return élément DOM représentant le tracé
	 */
	public Element creeElementTrace(Trace forme) {
		Element element = super.getDocument().createElement("Trace");
		
		for(int i = 0; i < forme.getPoints().size(); i++){
			Element point = super.getDocument().createElement("Point");
			super.ecrisAttribut(point, "x", forme.getPoints().get(i).getX());
			super.ecrisAttribut(point, "y", forme.getPoints().get(i).getY());
			element.appendChild(point);
		}
		
		return element;
	}

}
