package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class EllipseTest {

	@Test
	public void testSetLargeur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setLargeur(300);
		assertTrue(ellipse.getLargeur() == 300);
	}

	@Test
	public void testSetHauteur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setHauteur(300);
		assertTrue(ellipse.getHauteur() == 300);
	}

	@Test
	public void testPerimetre() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.perimetre() == 396.6359897312808);
	}

	@Test
	public void testAire() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.aire() == 11780.972450961724);
	}

	@Test
	public void testContientPoint() {
		Ellipse ellipse = new Ellipse();
		Point point = new Point(50, 50);
		assertTrue(ellipse.contient(point));
		point = new Point(100, 150);
		assertFalse(ellipse.contient(point));
	}

	@Test
	public void testContientDoubleDouble() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.contient(50, 50));
		assertFalse(ellipse.contient(150, 10));
	}

	@Test
	public void testEllipse() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getLargeur() == 100);
		assertTrue(ellipse.getHauteur() == 150);
		assertTrue(ellipse.getX() == 0);
		assertTrue(ellipse.getY() == 0);
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testEllipsePoint() {
		Ellipse ellipse = new Ellipse(new Point(50, 50));
		assertTrue(ellipse.getLargeur() == 100);
		assertTrue(ellipse.getHauteur() == 150);
		assertTrue(ellipse.getX() == 50);
		assertTrue(ellipse.getY() == 50);
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testEllipseDoubleDouble() {
		Ellipse ellipse = new Ellipse(200, 400);
		assertTrue(ellipse.getLargeur() == 200);
		assertTrue(ellipse.getHauteur() == 400);
		assertTrue(ellipse.getX() == 0);
		assertTrue(ellipse.getY() == 0);
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testEllipseDoubleDoubleDoubleDouble() {
		Ellipse ellipse = new Ellipse(150, 200, 30, 50);
		assertTrue(ellipse.getLargeur() == 30);
		assertTrue(ellipse.getHauteur() == 50);
		assertTrue(ellipse.getX() == 150);
		assertTrue(ellipse.getY() == 200);
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testEllipsePointDoubleDouble() {
		Ellipse ellipse = new Ellipse(new Point(45, 65), 540, 430);
		assertTrue(ellipse.getLargeur() == 540);
		assertTrue(ellipse.getHauteur() == 430);
		assertTrue(ellipse.getX() == 45);
		assertTrue(ellipse.getY() == 65);
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testForme() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getLargeur() == 100);
		assertTrue(ellipse.getHauteur() == 150);
		assertTrue(ellipse.getX() == 0);
		assertTrue(ellipse.getY() == 0);
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testSetPosition() {
		Ellipse ellipse = new Ellipse();
		ellipse.setPosition(new Point(30, 45));
		assertTrue(ellipse.getX() == 30);
		assertTrue(ellipse.getY() == 45);
	}

	@Test
	public void testSetX() {
		Ellipse ellipse = new Ellipse();
		ellipse.setX(45);
		assertTrue(ellipse.getX() == 45);
	}

	@Test
	public void testSetY() {
		Ellipse ellipse = new Ellipse();
		ellipse.setY(90);
		assertTrue(ellipse.getY() == 90);
	}

	@Test
	public void testSetCouleur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCouleurLigne(Color.BLUE);
		assertTrue(ellipse.getCouleurLigne() == Color.BLUE);
	}

	@Test
	public void testGetX() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getX() == 0);
	}

	@Test
	public void testGetY() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getY() == 0);
	}

	@Test
	public void testGetLargeur() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getLargeur() == 100);
	}

	@Test
	public void testGetHauteur() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getHauteur() == 150);
	}

	@Test
	public void testGetCadre() {
		Ellipse ellipse = new Ellipse(new Point(30, 60));
		assertTrue(ellipse.getCadreMaxX() == 130);
		assertTrue(ellipse.getCadreMaxY() == 210);
		assertTrue(ellipse.getCadreMinX() == 30);
		assertTrue(ellipse.getCadreMinY() == 60);
	}

	@Test
	public void testGetCouleur() {
		Ellipse ellipse = new Ellipse();
		assertTrue(ellipse.getCouleurLigne() == Forme.COULEUR_LIGNE_PAR_DEFAUT);
	}

	@Test
	public void testDeplacerDe() {
		Ellipse ellipse = new Ellipse();
		ellipse.deplacerDe(50, 50);
		assertTrue(ellipse.getCadreMaxX() == 150);
		assertTrue(ellipse.getCadreMaxY() == 200);
		assertTrue(ellipse.getCadreMinX() == 50);
		assertTrue(ellipse.getCadreMinY() == 50);
	}

	@Test
	public void testDeplacerVers() {
		Ellipse ellipse = new Ellipse(new Point(45, 45));
		assertTrue(ellipse.getCadreMaxX() == 145);
		assertTrue(ellipse.getCadreMaxY() == 195);
		assertTrue(ellipse.getCadreMinX() == 45);
		assertTrue(ellipse.getCadreMinY() == 45);
	}

	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(new Point(34, 56), 453, 342);
		assertTrue(ellipse.toString() ==
				"[Ellipse] pos (34 , 56) dim 453 x 342 périmètre : 1254,88 aire : 121678,6");
		
	}

}
