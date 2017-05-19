package fr.eseo.gpi.beanartist.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSSerializer;

/**
 * Un processeur DOM permet de créer, charger et enregistrer des documents XML
 * en utilisant le standard DOM et son implémentation dans l'API Java. Il permet
 * également de manipuler les valeurs entières stockés dans des attributs ou/et
 * des éléments simples (feuilles de l'arbres DOM).
 * 
 * Cette classe ne doit PAS être modifiée.
 */
public abstract class ProcesseurDOM {

	/**
	 * L'implémentation de DOM Core.
	 */
	private DOMImplementation dom;

	/**
	 * L'implémentation de DOM Load & Save.
	 */
	private DOMImplementationLS domLS;

	/**
	 * Le document nouvellement créé, chargé ou/et enregistré.
	 */
	private Document document;

	/**
	 * Construit les instances représentant les implémentations de DOM Core et
	 * DOM Load & Save
	 */
	protected ProcesseurDOM() {
		try {
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			dom = registry.getDOMImplementation("XML 1.0");
			domLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (ClassCastException e) {
		}
	}

	/**
	 * Renvoie le document créé, chargé ou/et enregistré par l'une des méthodes
	 * associées.
	 * @return Le document créé, chargé ou/et enregistré.
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * Crée un nouveau document XML dont le nom de l'élément racine est donné.
	 * @param nomElementRacine le nom de l'élément racine
	 */
	public void creeDocumentXML(String nomElementRacine) {
		document = dom.createDocument(null, nomElementRacine, null);
	}

	/**
	 * Crée un nouveau document SVG.
	 */
	public void creeDocumentSVG() {
		document = dom.createDocument("http://www.w3.org/2000/svg", "svg", null);
	}

	/**
	 * Charge un nouveau document XML dont le nom du fichier est donné.
	 * @param nomFichier le nom du fichier XML (peut inclure le chemin complet)
	 * @throws FileNotFoundException si le fichier n'est pas trouvé ou
	 *             accessible
	 */
	public void chargeDocument(String nomFichier) throws FileNotFoundException {
		LSParser parser = domLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
		LSInput input = domLS.createLSInput();
		input.setByteStream(new FileInputStream(nomFichier));
		document = parser.parse(input);
	}

	/**
	 * Enregistre le document précédemment créé ou chargé dans le fichier donné.
	 * @param nomFichier le nom du fichier de sauvegarde
	 * @throws FileNotFoundException si le fichier ne peut être sauvegardé
	 *             (accès au répertoire non autorisé par exemple)
	 */
	public void enregistreDocument(String nomFichier) throws FileNotFoundException {
		LSSerializer writer = domLS.createLSSerializer();
		writer.getDomConfig().setParameter("xml-declaration", true);
		writer.getDomConfig().setParameter("format-pretty-print", true);
		LSOutput output = domLS.createLSOutput();
		output.setByteStream(new FileOutputStream(nomFichier));
		writer.write(document, output);
	}

	/**
	 * Renvoie le nombre réel (double) stocké dans l'attribut donné.
	 * @param élément l'élément contenant l'attribut considéré
	 * @param nomAttribut le nom de l'attribut
	 * @return le nombre réel stocké dans l'attribut
	 * @throws NumberFormatException si la valeur stockée n'est pas un nombre
	 *             réel
	 */
	public double lisAttribut(Element element, String nomAttribut) {
		return Double.valueOf(element.getAttribute(nomAttribut));
	}

	/**
	 * Ecris le nombre réel (double) dans un attribut.
	 * @param element l'élément contenant l'attribut considéré
	 * @param nomAttribut le nom de l'attribut
	 * @param valeurAttribut le nombre réel à stocker dans l'attribut
	 */
	public void ecrisAttribut(Element element, String nomAttribut, double valeurAttribut) {
		element.setAttribute(nomAttribut, String.valueOf(valeurAttribut));
	}

	/**
	 * Renvoie le nombre réel (double) stocké dans l'élément simple donné. Soit
	 * l'élément e suivant : <a> <b>1.23</b> <c>4.56</c> </a>. L'invocation de
	 * lisElementSimple(e, "b") renvoie le double 1.23.
	 * @param elementParent l'élément parent de l'élément simple considéré
	 * @param nomElementFils le nom de l'élément simple
	 * @return le nombre réel stocké dans l'élément simple
	 * @throws NumberFormatException si la valeur stockée n'est pas un nombre
	 *             réel
	 */
	public double lisElementSimple(Element elementParent, String nomElementFils) {
		Node premier = elementParent.getElementsByTagName(nomElementFils).item(0);
		String valeur = premier.getChildNodes().item(0).getNodeValue();
		return Double.valueOf(valeur);
	}

	/**
	 * Ecris le nombre réel (double) donné dans un élément simple. Soit
	 * l'élément e suivant : <a/> L'invocation de ecrisElementSimple(e, "b",
	 * 1.23) modifie e comme suit : <a> <b>1.23</b> </a> .
	 * @param elementParent l'élément parent de l'élément simple considéré
	 * @param nomElementSimple le nom de l'élément simple
	 * @param valeurElementSimple le nombre réel à stocker dans l'élément simple
	 */
	public void ecrisElementSimple(Element elementParent, String nomElementSimple, double valeurElementSimple) {
		Text texte = getDocument().createTextNode(String.valueOf(valeurElementSimple));
		Element element = getDocument().createElement(nomElementSimple);
		element.appendChild(texte);
		elementParent.appendChild(element);
	}

	/**
	 * Décompose une chaîne de caractères constituée d'entiers séparés par un ou
	 * plusieur séparateurs en un tableau d'entiers. Soit c la chaîne "1,2 3,4
	 * 5,6". L'invocation de lisMotifs(c, " ,") renvoie le tableau
	 * {1,2,3,4,5,6}.
	 * @param chaîne La chaîne à décomposer
	 * @param séparateurs Les caractères possibles servant de séparateurs
	 * @return le tableau des entiers stockés dans la chaîne
	 * @throws NumberFormatException si l'une des valeurs stockées entre les
	 *             séparateurs n'est pas un entier
	 */
	// TODO return double[] ?
	public int[] lisMotifs(String chaine, String separateurs) {
		StringTokenizer tokenizer = new StringTokenizer(chaine, separateurs);
		int[] motifs = new int[tokenizer.countTokens()];
		for (int i = 0; i < motifs.length; i++) {
			motifs[i] = Integer.valueOf(tokenizer.nextToken());
		}
		return motifs;
	}
}
