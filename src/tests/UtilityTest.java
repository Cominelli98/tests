package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.unibs.ingesw.utility.Utility;

class UtilityTest {

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testReadLimitedInt() {
		
		System.out.println("Test lettura interi limitati sup e inf");
		var min = Utility.readInt();
		var max = Utility.readInt();
		assertTrue(Utility.readLimitedInt(min, max) <= max 
					|| Utility.readLimitedInt(min, max) >= min);
	}
	
	@Test
	public void testReadLowLimitInt() {
		
		System.out.println("Test lettura interi limitati inf");
		var min = Utility.readInt();
		assertTrue(Utility.readLowLimitInt(min) >= min);
	}
	@Test
	public void testReadString() {
		
		System.out.println("Test lettura Stringhe");
		var s = "hello";
		assertTrue(Utility.readString().equals(s));
	}

}
