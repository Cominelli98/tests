package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import it.unibs.ingesw.Network;
import it.unibs.ingesw.utility.Utility;

class UtilityTest {
	
	@Test
	void nameCheckTest() {
		
		String toTest = "Banana Split";
		Network net1 = new Network("Banana Split");
		net1.addLocation("loc1");
		net1.addTransition("tran1");
		assertAll(
			"Errore comparazione stringhe",
			() -> assertTrue(Utility.nameCheck(net1, toTest)),
			() -> assertFalse(Utility.nameCheck(net1.getLastLocation(), toTest)),
			() -> assertFalse(Utility.nameCheck(net1.getLastTransition(), toTest))
		);
	}
	
	@Test
	void getMaxTest() {
		
		Integer[] c = {-1, -100, 1, 5, 10, 50, 20, 30, 98, 100, 2, 30};
		ArrayList<Integer> numbs = new ArrayList<>();
		for (int i = 0; i < c.length; i++) {
			numbs.add(c[i]);
		}
		assertAll(
			"Errore lettura del massimo inesatta",
			() -> assertEquals(Utility.getMax(numbs), 100),
			() -> assertNotEquals(Utility.getMax(numbs), -100),
			() -> assertNotEquals(Utility.getMax(numbs), 1)
		);
	}

}
