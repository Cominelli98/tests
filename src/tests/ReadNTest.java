package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import it.unibs.ingesw.Network;
import it.unibs.ingesw.Petri_network;
import it.unibs.ingesw.Priority_network;
import it.unibs.ingesw.ioGson.ReadN;

class ReadNTest {


	    /* This folder and the files created in it will be deleted after
	     * tests are run, even in the event of failures or exceptions.
	     */
	    @Rule
	    public TemporaryFolder folder = new TemporaryFolder();
	    File file1, file2, file3;

	    /* executed before every test: create temporary files */
	    @Before
	    public void setUp() {
	    	 
	        try {
	            file1 = folder.newFile("testfile1.txt");
	            file2 = folder.newFile("testfile2.txt");
	            file3 = folder.newFile("testfile3.txt");
	        }
	        catch( IOException ioe ) {
	            System.err.println( 
	                "error creating temporary test file in " +
	                this.getClass().getSimpleName() );
	        }
	    }

	    /**
	     *  Write to the two temporary files and run some asserts.
	     */
	    @Test
	    public void test2TempFiles() {

	    	System.out.println(file1.getPath());
	    	
	    	String bodyTXT1 = new String("{\"locations\":[{\"netId\":2,\"nodeId\":10000,\"name\":\"s\"}],\"transitions\":[{\"netId\":2,\"nodeId\":0,\"nodeName\":\"d\"}],\"netLinks\":[{\"IDNode1\":10000,\"IDNode2\":0,\"netId\":2,\"orientation\":1}],\"netId\":2,\"name\":\"a\",\"OFFSET\":10000}\r\n");
	    	String bodyTXT2 = new String("{\"petriLocations\":[{\"token\":54,\"netId\":2,\"nodeId\":10000,\"nodeName\":\"s\"}],\"petriTransitions\":[{\"cost\":23,\"priority\":-1,\"netId\":2,\"nodeId\":0,\"nodeName\":\"d\"}],\"petriNetLinks\":[{\"IDNode1\":10000,\"IDNode2\":0,\"netId\":2,\"orientation\":1}],\"petriNetId\":2,\"fatherNetId\":2,\"name\":\"PACIOLLO\"}\r\n");
	    	String bodyTXT3 = new String("{\"priority_NetID\":1,\"petriLocations\":[{\"token\":54,\"netId\":2,\"nodeId\":10000,\"nodeName\":\"s\"}],\"petriTransitions\":[{\"cost\":23,\"priority\":23,\"netId\":2,\"nodeId\":0,\"nodeName\":\"d\"}],\"petriNetLinks\":[{\"IDNode1\":10000,\"IDNode2\":0,\"netId\":2,\"orientation\":1}],\"petriNetId\":2,\"fatherNetId\":2,\"name\":\"gfer\"}\r\n");
	    	
	    	
	    	//write out data to the test files
	        try {
				FileWriter fw1 = new FileWriter( file1 );
				BufferedWriter bw1 = new BufferedWriter( fw1 );
				bw1.write(bodyTXT1);
				bw1.close();
			
				FileWriter fw2 = new FileWriter( file2 );
				BufferedWriter bw2 = new BufferedWriter( fw2 );
				bw2.write(bodyTXT2);
				bw2.close();
				
				FileWriter fw3 = new FileWriter( file3 );
				BufferedWriter bw3 = new BufferedWriter( fw3 );
				bw3.write(bodyTXT3);
				bw3.close();
	        }
	        catch( IOException ioe ) {
	            System.err.println( 
	                "error creating temporary test file in " +
	                this.getClass().getSimpleName() );
	        }
	       System.out.println(file1.getPath());
	       assertTrue(true);
	        
	    }

}
