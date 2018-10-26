package garages;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GarageTest  {
	private Garage g1, g2;
	private Voiture v1;
		
	@Before
	public void setUp() throws Exception {
		v1 = new Voiture("123 XX 456");
		g1 = new Garage("ISIS Castres");
		g2 = new Garage("Université Champollion Albi");
	}
	
	@Test
	public void testInitialisationVoiture() {
		// Au début, la voiture n'est pas dans un garage
		assertFalse(v1.estDansUnGarage());		
		assertTrue(v1.garagesVisites().isEmpty());
	}
	
	@Test
	public void testEntreeGarage() throws Exception {
		// On fait entrer la voiture au garage g1
		v1.entreAuGarage(g1);
		// Elle doit être dans un garage
		assertTrue(v1.estDansUnGarage());
		// g1 fait partie des garages visités par la voiture
		assertTrue(v1.garagesVisites().contains(g1));	
	}
	
	@Test
	public void testSortieGarage() throws Exception {
		v1.entreAuGarage(g1);
		v1.sortDuGarage();
		// Elle n'est plus dans un garage
		assertFalse(v1.estDansUnGarage());
		// g1 fait partie des garages visités par la voiture
		assertTrue(v1.garagesVisites().contains(g1));	
	}
	
	@Test
	public void testDoubleSortie() throws Exception {
		v1.entreAuGarage(g1);
		v1.sortDuGarage(); // Ici il ne doit pas y avoir d'exception
		try {
			v1.sortDuGarage(); // Que doit-il se passer ?
			// Si on arrive ici, il n'y a pas eu d'exception, échec
			fail();
		} catch (Exception e) {
			// Si on arrive ici, il y a eu une exception, c'est ce qui est attendu
		}
	}
	
	@Test
	public void testDoubleEntree() throws Exception {
		v1.entreAuGarage(g1);
		try {
			v1.entreAuGarage(g2); // Que doit-il se passer ?
			// Si on arrive ici, il n'y a pas eu d'exception, échec
			fail();
		} catch (Exception e) {
			// Si on arrive ici, il y a eu une exception, c'est ce qui est attendu
		}
	}

}
