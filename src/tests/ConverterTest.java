package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.unibs.ingesw.Link;
import it.unibs.ingesw.Network;
import it.unibs.ingesw.Petri_network;
import it.unibs.ingesw.Petri_transition;

class ConverterTest {

	@Before
	public void setUp() {
		
		Network net1 = new Network("Net");
		net1.addTransition("tran");
		net1.addLocation("loc1");
		net1.addLocation("loc2");
		Link l1 = new Link(net1.getLocation(0).getId(), net1.getLastTransition().getId(), net1.getId(), 1);
		Link l2 = new Link(net1.getLastTransition().getId(), net1.getLocation(1).getId(), net1.getId(), 1);
		net1.addLink(l1);
		net1.addLink(l2);
		
		Petri_network pnet = new Petri_network(net1, "PNet");
//		Petri_transition PTran = new Petri_transition(netId, nodeId, nodeName);
		ArrayList<Petri_transition> trans = new ArrayList<Petri_transition> ();
		
	}
	
	@Test
	public void toPetriTest() {
		
	}

}
