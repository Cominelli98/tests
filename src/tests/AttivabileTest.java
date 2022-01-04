package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeAll;

import it.unibs.ingesw.*;

import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AttivabileTest {
	
	
	Network net = new Network("Net");
	Petri_network pnet;
	Simulatore simulatore;
	
	@BeforeAll
	public void setUp() {

		net.addTransition("tran1");
		net.addTransition("tran2");
		net.addTransition("tran3");
		
		net.addLocation("loc1");
		net.addLocation("loc2");
		
		Link l1 = new Link(net.getLocation(0).getId(), net.getTransition(0).getId(), net.getId(), 1);
		Link l2 = new Link(net.getTransition(0).getId(), net.getLocation(1).getId(), net.getId(), 1);
		Link l3 = new Link(net.getLocation(1).getId(), net.getTransition(1).getId(), net.getId(), 1);
		Link l4 = new Link(net.getTransition(1).getId(), net.getLocation(0).getId(), net.getId(), 1);
		net.addLink(l1);
		net.addLink(l2);
		net.addLink(l3);
		net.addLink(l4);
		
		pnet = new Petri_network(net, "PNet");
		simulatore = new Simulatore(pnet);
	}
	/**
	 * Test che controlla se il primo if presente nel metodo è esatto 
	 */
	@Test
	public void checkFirstConditionTest() {
		
		//Cammino indipendente: 1-2-3
		assertFalse("La transizione non è destinazione di nessun link", simulatore.AttivabilitaTest(pnet.getTransition(2)));
	}
	
	/**
	 * Test che controlla all'interno del ciclo for, ispezionando le if condition interne
	 */
	@Test
	public void checkIfForWorkRightTest() {
		
		//Cammino indipendente: 1-2-4-5-6-7-8-3
		assertFalse("Errore ciclo for -if annidato-", simulatore.AttivabilitaTest(pnet.getTransition(0)));
		
		//Cammino indipendente: 1-2-4-5-6-7-8-9-..., 1-2-4-5-6-9-...
		pnet.addLocationToken(pnet.getLocationID(1), 2);
		assertTrue("Errore ciclo for", simulatore.AttivabilitaTest(pnet.getTransition(1)));
	}

}
