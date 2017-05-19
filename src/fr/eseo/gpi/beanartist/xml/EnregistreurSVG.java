package fr.eseo.gpi.beanartist.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.List;

import org.w3c.dom.Element;

import fr.eseo.gpi.beanartist.modele.formes.Cercle;
import fr.eseo.gpi.beanartist.modele.formes.Ellipse;
import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Ligne;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;

/**
 * Un enregistreur SVG est un processeur DOM responsable de l'enregistrement
 * d'un dessin au format SVG standard.
 * 
 * Il suit exactement les mêmes principes que ceux de l'enregistreur XML (classe
 * EnregistreurXML). Les méthodes enregistreDessin et creeElementXxxx devront
 * être complétées. Des méthodes utilitaires pourront venir compléter celles
 * définies par la classe ProcesseurDOM ; elles devront dans ce cas être
 * OBLIGATOIREMENT définies en "private" à la fin de la classe EnregistreurXML.
 *
 */
public class EnregistreurSVG extends ProcesseurDOM {

	/**
	 * Lance le test d'enregistrement (méthode teste) avec le fichier XML d'entrée
	 * nommé "S30-Dessin-in.xml" et le fichier SVG de sortie nommé
	 * "S30-Dessin-out.svg".
	 * 
	 * Vérifier la conformité du fichier de sortie en l'affichant avec un
	 * navigateur Web et en comparant cet affichage avec celui fourni par la
	 * méthode LecteurXML.main.
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		teste("S30-Dessin-in.xml", "S30-Dessin-out.svg");
	}

	/**
	 * Teste l'enregistrement du dessin dans un fichier SVG. Le fichier XML
	 * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie
	 * au format SVG.
	 * 
	 * @param nomFichierEntrée le nom du fichier XML d'entrée lu
	 * @param nomFichierSortie le nom du fichier SVG de sortie écrit
	 * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
	 *             valide
	 */
	public static void teste(String nomFichierEntrée, String nomFichierSortie) throws FileNotFoundException {
		LecteurXML lecteur = new LecteurXML();
		final List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
		EnregistreurSVG enregistreur = new EnregistreurSVG();
		enregistreur.enregistreDessin(nomFichierSortie, dessin);
	}

	/**
	 * Enregistre le dessin donné dans un fichier SVG.
	 * @param nomFichier le nom du fichier SVG de sauvegarde
	 * @param dessin le dessin formé de la liste des vues des formes
	 * @throws FileNotFoundException si le nom du fichier n'est pas valide
	 */
	public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws FileNotFoundException {
		creeDocumentSVG();
		Element racine = getDocument().getDocumentElement();
		// Pour chaque vue du dessin, créer un élément DOM associé et l'ajouter
		// dans l'élément racine du document.
		for(int i = 0; i < dessin.size(); i++){
			if(dessin.get(i) != null){
				Forme forme = dessin.get(i).getForme();
				racine.appendChild(this.creeElementForme(forme));
			}
		}
		enregistreDocument(nomFichier);
	}

	/**
	 * Crée un élément DOM au format SVG représentant la forme donnée et
	 * retourne cet élément. Cette méthode invoque les méthodes
	 * creeElement<Forme> en fonction du type de la forme.
	 * @param forme la forme
	 * @return l'élément DOM représentant la forme
	 */
	public Element creeElementForme(Forme forme) {
		Element element;
		String nom = forme.getClass().getSimpleName();
		if (nom.equals("Rectangle") || nom.equals("Carre")) {
			element = creeElementRectangle((Rectangle) forme);
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
		String rgb = "rgb(" + couleur.getRed() + "," + couleur.getGreen() + "," + couleur.getBlue() + ")";
		element.setAttribute("stroke", rgb);
		getDocument().getDocumentElement().appendChild(element);
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM au format SVG représentant le rectangle
	 * donné.
	 * @param forme le rectangle
	 * @return élément DOM représentant le rectangle
	 */
	public Element creeElementRectangle(Rectangle forme) {
		Element element = super.getDocument().createElement("rect");
		
		super.ecrisAttribut(element, "x", forme.getX());
		super.ecrisAttribut(element, "y", forme.getY());
		super.ecrisAttribut(element, "width", forme.getLargeur());
		super.ecrisAttribut(element, "height", forme.getHauteur());
		
		return element;
		
	}

	/**
	 * Renvoie un nouvel élément DOM au format SVG représentant l'ellipse
	 * donnée.
	 * @param forme l'ellipse
	 * @return élément DOM représentant l'ellipse
	 */
	public Element creeElementEllipse(Ellipse forme) {
		Element element = super.getDocument().createElement("ellipse");
		
		double dx = forme.getCadreMaxX() - forme.getCadreMinX();
		double cx = forme.getX() + dx/2;
		
		double dy = forme.getCadreMaxY() - forme.getCadreMinY();
		double cy = forme.getY() + dy/2;
		
		super.ecrisAttribut(element, "cx", cx);
		super.ecrisAttribut(element, "cy", cy);
		super.ecrisAttribut(element, "rx", forme.getLargeur()/2);
		super.ecrisAttribut(element, "ry", forme.getHauteur()/2);
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM au format SVG représentant le cercle donné.
	 * @param forme le cercle
	 * @return élément DOM représentant le cercle
	 */
	public Element creeElementCercle(Cercle forme) {
		Element element = super.getDocument().createElement("circle");
		
		double dx = forme.getCadreMaxX() - forme.getCadreMinX();
		double cx = forme.getX() + dx/2;
		
		double dy = forme.getCadreMaxY() - forme.getCadreMinY();
		double cy = forme.getY() + dy/2;
		
		super.ecrisAttribut(element, "cx", cx);
		super.ecrisAttribut(element, "cy", cy);
		super.ecrisAttribut(element, "r", forme.getLargeur()/2);
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM au format SVG représentant la ligne donnée.
	 * @param forme la ligne
	 * @return élément DOM représentant la ligne
	 */
	public Element creeElementLigne(Ligne forme) {
		Element element = super.getDocument().createElement("line");
		Ligne line = (Ligne) forme;
		
		super.ecrisAttribut(element, "x1", line.getP1().getX());
		super.ecrisAttribut(element, "y1", line.getP1().getY());
		super.ecrisAttribut(element, "x2", line.getP2().getX());
		super.ecrisAttribut(element, "y2", line.getP2().getY());
		
		return element;
	}

	/**
	 * Renvoie un nouvel élément DOM au format SVG représentant le tracé donné.
	 * @param forme le tracé
	 * @return élément DOM représentant le tracé
	 */
	public Element creeElementTrace(Trace forme) {
		Element element = super.getDocument().createElement("path");
		
		String d = "M " + forme.getPoints().get(0).toString().replaceAll(" ", "");
		
		for(int i = 1; i < forme.getPoints().size(); i++){
			d = d + " L " + forme.getPoints().get(i).toString().replaceAll(" ", "");
		}
		
		System.out.println(d);
		
		element.setAttribute("d", d);
		
		return element;
	}

}
