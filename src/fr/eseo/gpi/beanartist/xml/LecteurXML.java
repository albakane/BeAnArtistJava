package fr.eseo.gpi.beanartist.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.eseo.gpi.beanartist.modele.formes.Carre;
import fr.eseo.gpi.beanartist.modele.formes.Cercle;
import fr.eseo.gpi.beanartist.modele.formes.Ellipse;
import fr.eseo.gpi.beanartist.modele.formes.Ligne;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.formes.VueCarre;
import fr.eseo.gpi.beanartist.vue.formes.VueCercle;
import fr.eseo.gpi.beanartist.vue.formes.VueEllipse;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.formes.VueLigne;
import fr.eseo.gpi.beanartist.vue.formes.VueRectangle;
import fr.eseo.gpi.beanartist.vue.formes.VueTrace;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

/**
 * Un lecteur XML est un processeur DOM responsable du chargement d'un dessin au
 * format XML défini par l'application.
 * 
 * Il utilise les méthodes héritées de la classe ProcesseurDOM pour charger le
 * fichier XML dans un document DOM, ainsi que les méthodes de lecture des
 * entiers.
 * 
 * Les méthodes lisDessin et creeXxxx devront être complétées. Des méthodes
 * utilitaires pourront venir compléter celles définies par la classe
 * ProcesseurDOM ; elles devront dans ce cas être OBLIGATOIREMENT définies en
 * "private" à la fin de la classe LecteurXML.
 * 
 */
public class LecteurXML extends ProcesseurDOM {

	/**
	 * Lance le test de chargement (méthode teste) avec le fichier XML nommé
	 * "S30-Dessin-in.xml".
	 * 
	 * Vous aurez pris soin de le copier prélablablement dans le ficher
	 * "S30-Dessin-in.xml".
	 * 
	 * Ce test MANUEL doit OBLIGATOIREMENT passer avant de commencer la gestion
	 * de l'enregistrement en XML (classe EnregistreurXML).
	 */
	public static void main(String[] args) throws FileNotFoundException {
		teste("S30-Dessin-in.xml");
	}

	/**
	 * Teste le chargement du fichier XML. Le contenu du fichier est ensuite
	 * affiché dans la fenêtre de l'application (classe FenetreBeAnArtist).
	 * @param nomFichier le fichier d'entrée à lire
	 * @throws FileNotFoundException si le fichier n'existe pas
	 */
	public static void teste(String nomFichier) throws FileNotFoundException {
		LecteurXML lecteur = new LecteurXML();
		final List<VueForme> dessin = lecteur.lisDessin(nomFichier);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreBeAnArtist fenetre = FenetreBeAnArtist.getInstance();
				for (VueForme vueForme : dessin) {
					fenetre.getPanneauDessin().ajouterVueForme(vueForme);
				}
				FenetreBeAnArtist.getInstance().setVisible(true);
				FenetreBeAnArtist.getInstance().pack();
			}
			
		});
	}

	/**
	 * Charge le fichier XML donné dans un document DOM puis renvoie
	 * l'intégralité du dessin sous la forme d'une liste de vues représentant
	 * les formes stockées dans le fichier.
	 * 
	 * @param nomFichier le nom du fichier XML
	 * @return l'intégralité du dessin sous la forme d'une liste de vues
	 * @throws FileNotFoundException si le fichier n'est pas trouvé ou
	 *             accessible
	 */
	public List<VueForme> lisDessin(String nomFichier) throws FileNotFoundException {
		List<VueForme> dessin = new ArrayList<>();
		super.chargeDocument(nomFichier);
		Element racine = getDocument().getDocumentElement();
		// Pour chaque noeud fils de l'élément racine du document,
		// si le noeud est un élément DOM, convertir cet élément en une vue sur
		// la forme que l'élément représente en utilisant la méthode
		// creeVueForme, puis ajouter cette vue au dessin.
		NodeList nodeChild = racine.getChildNodes();
		for(int i = 0; i < racine.getChildNodes().getLength(); i++){
			Node formeXML = nodeChild.item(i);
			if(formeXML.getNodeType() == Node.ELEMENT_NODE){
				Element elementForme = (Element)formeXML;
				FenetreBeAnArtist.getInstance().getPanneauDessin().ajouterVueForme(this.creeVueForme(elementForme));
				dessin.add(this.creeVueForme(elementForme));
				
			}
		}
		
		return dessin;
	}

	/**
	 * Crée une forme et sa vue associée réprésentées par l'élément DOM donné,
	 * puis renvoie cette vue. Cette méthode invoque les méthodes cree<Forme>
	 * définies pour chacune des <Forme> considérée.
	 * @param element l'élément représentant la vue et sa forme
	 * @return la vue stockée dans l'élément considéré
	 */
	public VueForme creeVueForme(Element element) {
		VueForme vue = null;
		String nom = element.getNodeName();
		
		String couleur = element.getAttribute("couleur");
		int[] rgb = super.lisMotifs(couleur, " ");
		
		if (nom.equals("Rectangle")) {
			Rectangle forme = creeRectangle(element);
			Color couleurLigne = new Color(rgb[0], rgb[1], rgb[2]);
			forme.setCouleurLigne(couleurLigne);
			vue = new VueRectangle(forme);
		} else if (nom.equals("Carre")) {
			Carre forme = creeCarre(element);
			Color couleurLigne = new Color(rgb[0], rgb[1], rgb[2]);
			forme.setCouleurLigne(couleurLigne);
			vue = new VueCarre(forme);
		} else if (nom.equals("Ellipse")) {
			Ellipse forme = creeEllipse(element);
			Color couleurLigne = new Color(rgb[0], rgb[1], rgb[2]);
			forme.setCouleurLigne(couleurLigne);
			vue = new VueEllipse(forme);
		} else if (nom.equals("Cercle")) {
			Cercle forme = creeCercle(element);
			Color couleurLigne = new Color(rgb[0], rgb[1], rgb[2]);
			forme.setCouleurLigne(couleurLigne);
			vue = new VueCercle(forme);
		} else if (nom.equals("Ligne")) {
			Ligne forme = creeLigne(element);
			Color couleurLigne = new Color(rgb[0], rgb[1], rgb[2]);
			forme.setCouleurLigne(couleurLigne);
			vue = new VueLigne(forme);
		} else if (nom.equals("Trace")) {
			Trace forme = creeTrace(element);
			Color couleurLigne = new Color(rgb[0], rgb[1], rgb[2]);
			forme.setCouleurLigne(couleurLigne);
			vue = new VueTrace(forme);
		}
		// à compléter ici
		return vue;
	}

	/**
	 * Renvoie un nouveau rectangle représenté par l'élément DOM donné.
	 * @param element l'élément représentant le rectangle
	 * @return le rectangle stocké dans l'élément considéré
	 */
	public Rectangle creeRectangle(Element element) {

		double x = super.lisAttribut(element, "x");
		double y = super.lisAttribut(element, "y");
		double largeur = super.lisAttribut(element, "largeur");
		double hauteur = super.lisAttribut(element, "hauteur");

		Rectangle rectangle = new Rectangle(x, y, largeur, hauteur);
		
		return rectangle;
	}

	/**
	 * Renvoie un nouveau carré représenté par l'élément DOM donné.
	 * @param element l'élément représentant le carré
	 * @return le carré stocké dans l'élément considéré
	 */
	public Carre creeCarre(Element element) {
		
		double x = super.lisAttribut(element, "x");
		double y = super.lisAttribut(element, "y");
		double largeur = super.lisAttribut(element, "largeur");
		
		Carre carre = new Carre(x, y, largeur);
		
		return carre;
	}

	/**
	 * Renvoie une nouvelle ellipse représentée par l'élément DOM donné.
	 * @param element l'élément représentant l'ellipse
	 * @return l'ellipse stockée dans l'élément considéré
	 */
	public Ellipse creeEllipse(Element element) {
		
		double x = super.lisAttribut(element, "x");
		double y = super.lisAttribut(element, "y");
		double largeur = super.lisAttribut(element, "largeur");
		double hauteur = super.lisAttribut(element, "hauteur");
		
		Ellipse ellipse = new Ellipse(x, y, largeur, hauteur);
		
		return ellipse;
	}

	/**
	 * Renvoie un nouveau cercle représenté par l'élément DOM donné.
	 * @param element l'élément représentant le cercle
	 * @return le cercle stocké dans l'élément considéré
	 */
	public Cercle creeCercle(Element element) {
		
		double x = super.lisAttribut(element, "x");
		double y = super.lisAttribut(element, "y");
		double largeur = super.lisAttribut(element, "largeur");
		
		Cercle cercle = new Cercle(x, y, largeur);
			
		return cercle;
	}

	/**
	 * Renvoie la nouvelle ligne représentée par l'élément DOM donné.
	 * @param element l'élément représentant la ligne
	 * @return la ligne stockée dans l'élément considéré
	 */
	public Ligne creeLigne(Element element) {
		
		double x = super.lisAttribut(element, "x");
		double y = super.lisAttribut(element, "y");
		double largeur = super.lisAttribut(element, "largeur");
		double hauteur = super.lisAttribut(element, "hauteur");
		
		Ligne ligne = new Ligne(x, y, largeur, hauteur);
		
		return ligne;
	}

	/**
	 * Renvoie un nouveau tracé représenté par l'élément DOM donné.
	 * @param element l'élément représentant le tracé
	 * @return le tracé stocké dans l'élément considéré
	 */
	public Trace creeTrace(Element element) {
		// création de la liste des points du tracé
		List<Point> points = new ArrayList<>();
		// création des lignes formant le tracé
		NodeList nodeChild = element.getChildNodes();
		for(int i = 0; i < nodeChild.getLength(); i++){
			Node node = nodeChild.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE)
				points.add(new Point(super.lisAttribut((Element)node, "x"), 
						super.lisAttribut((Element)node, "y")));
		}

		Trace trace = new Trace(points.get(0), points.get(1));
		
		for(Point p : points)
			trace.ajouterPoint(p);
		
		return trace;
	}

}
