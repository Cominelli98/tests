package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import it.unibs.ingesw.Network;
import it.unibs.ingesw.Petri_network;
import it.unibs.ingesw.Priority_network;

class ReadNTest {

	Integer x;
	String s;
	Network net;
	Petri_network pnet;
	Priority_network pnetp;
	
	
	@BeforeEach
	void setUp() {
		
		x = 1;
		s = "hello";
		net = new Network("NET");
		pnet = new Petri_network(net, "PNET");
		pnetp = new Priority_network(pnet, "PNETP");
	}
	
	@Test
	void fileSelectionTest() {
		
//		assertThrows(IllegalArgumentException, ReadN.)
	}

}
