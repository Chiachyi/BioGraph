package it.cnr.icar.biograph.neo4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import it.cnr.icar.biograph.neo4j.Relations.RelationTypes;

public class _03_Gene2GoImport {

	private static void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    // Registers a shutdown hook for the Neo4j instance so that it
	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
	    // running application).
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	            graphDb.shutdown();
	        }
	    } );
	}
	
	private static String timeConversion(long seconds) {

	    final int MINUTES_IN_AN_HOUR = 60;
	    final int SECONDS_IN_A_MINUTE = 60;

	    long minutes = seconds / SECONDS_IN_A_MINUTE;
	    seconds -= minutes * SECONDS_IN_A_MINUTE;

	    long hours = minutes / MINUTES_IN_AN_HOUR;
	    minutes -= hours * MINUTES_IN_AN_HOUR;

	    return hours + " hours " + minutes + " minutes " + seconds + " seconds";
	}
	
	static String DB_PATH = "/biograph.db";
	
	public static void main(String[] args) throws IOException {
		String homeDir = System.getProperty("user.home");
		File dbPath = new File(homeDir + DB_PATH);
		
		GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(dbPath);
		registerShutdownHook( graphDb );

		String fileName = homeDir + "/biodb/gene2go";
		String line;
		int edgeCounter = 0;
        long startTime = System.currentTimeMillis();
        
	    BufferedReader reader = new BufferedReader(new FileReader(fileName));

        System.out.print("\nImporting gene-go associations from " + fileName + " ");
        
        // skip first line
        reader.readLine();
        
        Label GENE = DynamicLabel.label( "Gene" );
        Label GO = DynamicLabel.label( "Go" );
        
        try ( Transaction tx = graphDb.beginTx() ) {
	        while ((line = reader.readLine()) != null) {
	        	String datavalue[] = line.split("\t");
	        	
	        	String taxId = datavalue[0];
	        	if (!taxId.equals("9606"))
	        		continue;
	
	        	String geneId = datavalue[1];
	        	String goId = datavalue[2];
	        	String evidence = datavalue[3];
	        	String qualifier = datavalue[4];
	        	//String goTerm = datavalue[5];
	        	//String pubmedIds = datavalue[6];
	        	String category = datavalue[7];
	
	        	Node gene = null;
	        	Node go = null;
	
	        	ResourceIterator<Node> it = graphDb.findNodes( GENE, "geneId", geneId );
	        	
	        	if (it.hasNext()) {
	        		gene = it.next();
	        		
	        		it = graphDb.findNodes( GO, "goId", goId );
	        		if (it.hasNext())
	        			go = it.next();
	        	}
	        	
	        	if ((gene != null) && (go != null)) {
	            	edgeCounter++;
	            	
	            	Relationship association = go.createRelationshipTo(gene, RelationTypes.ANNOTATES);
	            	association.setProperty("evidence", evidence);
	            	association.setProperty("qualifier", qualifier);
	            	association.setProperty("category", category);
	        	}
	        	
	            if (edgeCounter % 5000 == 0) {
	            	System.out.print("."); System.out.flush();
	            }
	        }
	        tx.success();
        }
        
        long stopTime = (System.currentTimeMillis()-startTime)/1000;
        System.out.println("\n\nCreated " + edgeCounter + " edges in " + timeConversion(stopTime));
        
        reader.close();
        
        graphDb.shutdown();
	}
}
