package tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import it.unibs.ingesw.*;
import it.unibs.ingesw.ioGson.*;

import static org.junit.Assert.*;

import java.io.*;

public class ReadNTest {

    File file;

    /*
     *  This folder and the files created in it will be deleted after
     * tests are run, even in the event of failures or exceptions.
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        try {
            file = folder.newFile( "testfile.txt" );
        }
        catch( IOException ioe ) {
            System.err.println( 
                "error creating temporary test file in " +
                this.getClass().getSimpleName() );
        }
    }

    /**
     * Scrittura su file , lettura ReadN e testing riempimento oggetti
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    @Test
    public void testReadingReadN() throws FileNotFoundException, IOException {

    	
    	String bodyTXT1 = new String("{\"locations\":[{\"netId\":2,\"nodeId\":10000,\"name\":\"s\"}],\"transitions\":[{\"netId\":2,\"nodeId\":0,\"nodeName\":\"d\"}],\"netLinks\":[{\"IDNode1\":10000,\"IDNode2\":0,\"netId\":2,\"orientation\":1}],\"netId\":2,\"name\":\"a\",\"OFFSET\":10000}\r\n");
    
        //write out data to the test files
        try {
				FileWriter fw1 = new FileWriter(file);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(bodyTXT1);
				bw1.close();
        }
        catch(IOException ioe) {
            System.err.println( 
                "error creating temporary test file in " +
                this.getClass().getSimpleName());
        }
        
        Network net = (Network) ReadN.loadFromSource(Network.class, file.getPath());
        for (Location l : net.getLocations()) {
        	assertAll(
        			() -> assertTrue("Nome location null", l.getName() != null),
        			() -> assertTrue("NetID diverso dal padre", l.getNetID() == net.getId()),
        			() -> assertTrue("ID nodo non accettabile", l.getId() >= 0)
        			);
		}
        for (Transition t : net.getTransitions()) {
        	assertAll(
        			() -> assertTrue("Nome Transition null", t.getName() != null),
        			() -> assertTrue("NetID diverso dal padre", t.getNetID() == net.getId()),
        			() -> assertTrue("ID nodo non accettabile", t.getId() >= 0)
        			);
		}
        for (Link link : net.getLinks()) {
        	assertAll(
        			() -> assertTrue("Origine e destinazione non conformi", link.getOrigin() >= 0 && link.getDestination() >=0),
        			() -> assertTrue("Orientamento non conforme", link.getOrientation() == 1 || link.getOrientation() == -1)
        			);
		}
    }
    
    @Test
    public void throwsTest() {
    	
    	assertThrows(FileNotFoundException.class, () -> ReadN.loadFromSource(Network.class, ""));
    	assertThrows(IOException.class, () -> ReadN.loadFromSource(Network.class, ""));
    	assertThrows(IllegalArgumentException.class,() -> ReadN.readFile(Petri_transition.class));
    }
}
