package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testSetLargeur() {
		Rectangle rectangle = new Rectangle();
		rectangle.setLargeur(135);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 135);
	}

	@Test
	public void testSetHauteur() {
		Rectangle rectangle = new Rectangle();
		rectangle.setHauteur(135);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 135);
	}

	@Test
	public void testPerimetre() {
		Rectangle rectangle = new Rectangle(100, 200);
		assertTrue("Perimetre correct", rectangle.perimetre() == 600);
	}

	@Test
	public void testAire() {
		Rectangle rectangle = new Rectangle(100, 200);
		assertTrue("Aire correcte", rectangle.aire() == 20000);
	}

	@Test
	public void testContientPoint() {
		Rectangle rectangle = new Rectangle();
		Point point = new Point(50, 50);
		assertTrue("Le rectangle contient bien le point", rectangle.contient(point)
				== true);
	}

	@Test
	public void testContientDoubleDouble() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Le rectangle contient bien les coordonnees", 
				rectangle.contient(50, 50));
	}

	@Test
	public void testRectangle() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Largeur correcte", rectangle.getLargeur() == 100);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 150);
		assertTrue("Position correcte", rectangle.getPosition().toString() == 
				new Point().toString());
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testRectanglePoint() {
		Rectangle rectangle = new Rectangle(new Point(50, 50));
		assertTrue("Largeur correcte", rectangle.getLargeur() == 100);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 150);
		assertTrue("Position correcte", rectangle.getPosition() == new Point(50, 50));
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testRectangleDoubleDouble() {
		Rectangle rectangle = new Rectangle(250, 300);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 250);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 300);
		assertTrue("Position correcte", rectangle.getPosition() == new Point());
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testRectangleDoubleDoubleDoubleDouble() {
		Rectangle rectangle = new Rectangle(50, 50, 200, 300);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 200);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 300);
		assertTrue("Position correcte", rectangle.getPosition() == new Point(50, 50));
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testRectanglePointDoubleDouble() {
		Rectangle rectangle = new Rectangle(new Point(50, 50), 200, 400);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 200);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 400);
		assertTrue("Position correcte", rectangle.getPosition() == new Point(50, 50));
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testForme() {
		Forme rectangle = new Rectangle();
		assertTrue("Largeur correcte", rectangle.getLargeur() == 100);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 150);
		assertTrue("Position correcte", rectangle.getPosition() == new Point());
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testFormePoint() {
		Forme rectangle = new Rectangle(new Point(50, 50));
		assertTrue("Largeur correcte", rectangle.getLargeur() == 100);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 150);
		assertTrue("Position correcte", rectangle.getPosition() == new Point(50, 50));
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testFormeDoubleDouble() {
		Forme rectangle = new Rectangle(100, 100);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 100);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 100);
		assertTrue("Position correcte", rectangle.getPosition() == new Point());
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testFormePointDoubleDouble() {
		Forme rectangle = new Rectangle(new Point(50, 50), 250, 300);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 250);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 300);
		assertTrue("Position correcte", rectangle.getPosition() == new Point(50, 50));
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testFormeDoubleDoubleDoubleDouble() {
		Forme rectangle = new Rectangle(50, 50, 245, 547);
		assertTrue("Largeur correcte", rectangle.getLargeur() == 245);
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 547);
		assertTrue("Position correcte", rectangle.getPosition() == new Point(50, 50));
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() ==
				Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testSetPosition() {
		Rectangle rectangle = new Rectangle();
		rectangle.setPosition(new Point(56, 567));
		assertTrue("Position correcte", rectangle.getPosition() == new Point(56, 567));
	}

	@Test
	public void testSetX() {
		Rectangle rectangle = new Rectangle();
		rectangle.setX(34);
		assertTrue("abscisse correcte", rectangle.getX() == 34);
	}

	@Test
	public void testSetY() {
		Rectangle rectangle = new Rectangle();
		rectangle.setY(45);
		assertTrue("ordonnee correcte", rectangle.getY() == 45);
	}

	@Test
	public void testSetCouleur() {
		Rectangle rectangle = new Rectangle();
		rectangle.setCouleurLigne(Color.BLUE);
		assertTrue("Couleur correcte", rectangle.getCouleurLigne() == Color.BLUE);
	}

	@Test
	public void testGetPosition() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Position correcte", rectangle.getPosition() == new Point());
	}

	@Test
	public void testGetX() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Abscisse correcte", rectangle.getX() == 0);
	}

	@Test
	public void testGetY() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Ordonnee correcte", rectangle.getY() == 0);
	}

	@Test
	public void testGetLargeur() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Largeur correcte", rectangle.getLargeur() == 100);
	}

	@Test
	public void testGetHauteur() {
		Rectangle rectangle = new Rectangle();
		assertTrue("Hauteur correcte", rectangle.getHauteur() == 150);
	}

	@Test
	public void testGetCadreMinX() {
		Rectangle rectangle = new Rectangle(new Point(50, 100));
		assertTrue(rectangle.getCadreMinX() == 50);
	}

	@Test
	public void testGetCadreMinY() {
		Rectangle rectangle = new Rectangle(new Point(46, 89));
		assertTrue(rectangle.getCadreMinY() == 89);
	}

	@Test
	public void testGetCadreMaxX() {
		Rectangle rectangle = new Rectangle(new Point(25, 60));
		assertTrue(rectangle.getCadreMaxX() == 125);
	}

	@Test
	public void testGetCadreMaxY() {
		Rectangle rectangle = new Rectangle(new Point(50, 125));
		assertTrue(rectangle.getCadreMaxY() == 275);
	}

	@Test
	public void testGetCouleur() {
		Rectangle rectangle = new Rectangle();
		assertTrue(rectangle.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testDeplacerDe() {
		Rectangle rectangle = new Rectangle();
		rectangle.deplacerDe(50, 50);
		assertTrue(rectangle.getCadreMinX() == 50);
		assertTrue(rectangle.getCadreMinY() == 50);
		assertTrue(rectangle.getCadreMaxX() == 150);
		assertTrue(rectangle.getCadreMaxY() == 200);
	}

	@Test
	public void testDeplacerVers() {
		Rectangle rectangle = new Rectangle();
		rectangle.deplacerVers(100, 200);
		assertTrue(rectangle.getCadreMinX() == 100);
		assertTrue(rectangle.getCadreMinY() == 200);
		assertTrue(rectangle.getCadreMaxX() == 200);
		assertTrue(rectangle.getCadreMaxY() == 350);
	}

	@Test
	public void testToString() {
		Rectangle rectangle = new Rectangle(20, 45, 135, 320);
		String affichage = "[Rectangle] pos (20 , 45) dim 135 x 320 périmètre : 910 aire : 43200";
		assertTrue(rectangle.toString() == affichage);
	}
	
	@Test
	public void testPoint() {
		Point position = new Point();
		assertTrue(position == new Point());
	}

}
