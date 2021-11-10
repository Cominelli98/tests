package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import it.unibs.ingesw.Network;
import it.unibs.ingesw.utility.Utility;

class UtilityTest {

	@Test
	void testReadLimitedInt() {
		
		System.out.println("Test lettura interi limitati sup e inf");
		System.out.println("inserisci il min: ");
		var min = Utility.readInt();
		System.out.println("inserisci il max: ");
		var max = Utility.readInt();
		assertTrue(Utility.readLimitedInt(min, max) <= max 
					|| Utility.readLimitedInt(min, max) >= min);
	}
	
	@Test
	void testReadLowLimitInt() {
		
		System.out.println("Test lettura interi limitati inf");
		System.out.println("inserisci il min: ");
		var min = Utility.readInt();
		assertTrue(Utility.readLowLimitInt(min) >= min);
	}
	
	@Test
	public void testReadString() {
		
		System.out.println("Test lettura Stringhe");
		var s = "hello";
		System.out.println("say hello: ");
		assertTrue(Utility.readString().equals(s));
	}
	
	@Test
	void nameCheckTest() {
		
		System.out.println("Test nameCheck");
		String toTest = "Banana Split";
		Network net1 = new Network("Banana Split");
		net1.addLocation("loc1-0");
		net1.addTransition("tran1");
		
		assertTrue(Utility.nameCheck(net1, toTest));
		assertFalse(Utility.nameCheck(net1.getLastLocation(), toTest));
		assertFalse(Utility.nameCheck(net1.getLastTransition(), toTest));
	}
	
	@Test
	void getMaxTest() {
		
		
		Integer[] c = {1, 5, 10, 50, 20, 30, 98, 100, 2, 30};
		ArrayList<Integer> ali = new ArrayList<>();
		for (int i = 0; i < c.length; i++) {
			ali.add(c[i]);
		}
		
		assertEquals(Utility.getMax(ali), 100);
		assertNotEquals(Utility.getMax(ali), 1);
	}

}
