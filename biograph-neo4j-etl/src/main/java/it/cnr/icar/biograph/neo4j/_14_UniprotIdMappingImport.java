package it.cnr.icar.biograph.neo4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import it.cnr.icar.biograph.neo4j.Relations.RelationTypes;

public class _14_UniprotIdMappingImport {

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
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String homeDir = System.getProperty("user.home");
		File dbPath = new File(homeDir + DB_PATH);
		
		GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(dbPath);
		registerShutdownHook( graphDb );

		String fileName = homeDir + "/biodb/uniprot/HUMAN_9606_idmapping_selected.tab";
		String line;
		int entryCounter = 0;
		int edgeCounter = 0;
        long startTime = System.currentTimeMillis();

	    BufferedReader reader = new BufferedReader(new FileReader(fileName));

        System.out.print("\nImporting proteins id mappings from " + fileName + " ");
        
        Label GO = DynamicLabel.label( "Go" );
        Label GENE = DynamicLabel.label( "Gene" );
        Label GENE_NAME = DynamicLabel.label( "GeneName" );
        Label PROTEIN = DynamicLabel.label( "Protein" );
        Label PROTEIN_NAME = DynamicLabel.label( "ProteinName" );
        
        // skip first line
        reader.readLine();
        
        try ( Transaction tx = graphDb.beginTx() ) {
	        while ((line = reader.readLine()) != null) {        	
	        	String datavalue[] = line.split("\t");
	        	
	        	//String uniprotAcc = datavalue[0];
	        	String uniprotID = datavalue[1];
	        	String geneId = datavalue[2];
	        	String refseq = datavalue[3];
	        	/*
	        	String gi = datavalue[4];
	        	String pdb = datavalue[5];
	        	*/
	        	String go = datavalue[6];
	        	/*
	        	String uniref100 = datavalue[7];
	        	String uniref90 = datavalue[8];
	        	String uniref50 = datavalue[9];
	        	String uniparc = datavalue[10];
	        	String pir = datavalue[11];
	        	String ncbiTax = datavalue[12];
	        	*/
	        	if (datavalue.length < 14)
	        		continue;
	        	//String mim = datavalue[13];
	        	String unigeneId = datavalue[14];
	        	//String pubmed = datavalue[15];
	        	if (datavalue.length < 17)
	        		continue;
	        	//String embl = datavalue[16];
	        	//String embl_cds = datavalue[17];
	        	if (datavalue.length < 19)
	        		continue;
	        	//String ensembl = datavalue[18];
	        	//String ensembl_trs = datavalue[19];
	        	String ensembl_pro = datavalue[20];
	        	//String addPubmed = datavalue[21];

	        	if (!uniprotID.equals("")) {
	        		Node protein = null;
	        		
	        		ResourceIterator<Node> it = graphDb.findNodes(PROTEIN, "name", uniprotID);
	        		if (it.hasNext())
	        			protein = it.next();
	        		
	        		if (protein != null) {
	        			if (!refseq.equals("")) {
	        				if (refseq.contains(";")) {
	            				String refseqId[] = refseq.split("; ");
	            				for (int i=0; i<refseqId.length; i++) {
	            					Node vref = graphDb.createNode( PROTEIN_NAME );
	            					vref.setProperty("name", refseqId[i]);
	            					vref.createRelationshipTo(protein, RelationTypes.REFERS_TO);

	            					entryCounter++;
	    	            			edgeCounter++;
	            				}        					
	        				} else {
	        					Node vref = graphDb.createNode( PROTEIN_NAME );
	        					vref.setProperty("name", refseq);
	        					vref.createRelationshipTo(protein, RelationTypes.REFERS_TO);

	        					entryCounter++;
	        					edgeCounter++;
	        				}
	        			}
	        			
	        			if (!ensembl_pro.equals("")) {
	        				if (ensembl_pro.contains(";")) {
	            				String ensembleId[] = ensembl_pro.split("; ");
	            				for (int i=0; i<ensembleId.length; i++) {
	            					Node ensembl = graphDb.createNode( PROTEIN_NAME );
	            					ensembl.setProperty("name", ensembleId[i]);
	            					ensembl.createRelationshipTo(protein, RelationTypes.REFERS_TO);

	    	            			entryCounter++;
	    	            			edgeCounter++;
	            				}        					
	        				} else {
	        					Node ensembl = graphDb.createNode( PROTEIN_NAME );
	        					ensembl.setProperty("name", ensembl_pro);
	        					ensembl.createRelationshipTo(protein, RelationTypes.REFERS_TO);

	        					entryCounter++;
	        					edgeCounter++;
	        				}
	        			}
	        			
	        			if (!geneId.equals("")) {
	        				Node gene = null;
	                		
	                		ResourceIterator<Node> git = graphDb.findNodes(GENE, "geneId", geneId);
	                		if (git.hasNext())
	                			gene = git.next();
	                		
	                		if (gene != null) {
	                			if (!gene.getRelationships(Direction.OUTGOING, RelationTypes.CODING).iterator().hasNext()) {
	                				gene.createRelationshipTo(protein, RelationTypes.CODING);
	                				edgeCounter++;
	                			}
	                			
	                			if (!unigeneId.equals("")) {
	                				Node unigene = graphDb.createNode( GENE_NAME );
	                				unigene.setProperty("symbol", unigeneId);
	                				unigene.createRelationshipTo(gene, RelationTypes.SYNONYM_OF);
	                				entryCounter++;
	        	        			edgeCounter++;
	                			}
	                		}
	        			}
	        			
	        			if (!go.equals("")) {
	        				if (go.contains(";")) {
	            				String goId[] = go.split("; ");
	            				for (int i=0; i<goId.length; i++) {
	            					Node g = null;
	            		        	it = graphDb.findNodes(GO, "goId", goId[i]);
	            		        	if (it.hasNext())
	            		        		g = it.next();
	            		        	if (g != null) {
	            		        		g.createRelationshipTo(protein, RelationTypes.ANNOTATES);
	            		        		edgeCounter++;
	            		        	}
	            				}               					
	        				} else {
	        					Node g = null;
	        		        	it = graphDb.findNodes(GO, "goId", go);
	        		        	if (it.hasNext())
	        		        		g = it.next();
	        		        	if (g != null) {
	        		        		g.createRelationshipTo(protein, RelationTypes.ANNOTATES);
	        		        		edgeCounter++;
	        		        	}
	        				}
	        			}
	        		}
	        		
	                if (entryCounter % 1000 == 0) {
	                	System.out.print("."); System.out.flush();
	                }
	            }
	        }
	        tx.success();
		}
        
        long stopTime = (System.currentTimeMillis()-startTime)/1000;
        System.out.println("\n\nCreated " + entryCounter + " vertices and "+ edgeCounter + " edges in " + timeConversion(stopTime));

        reader.close();

		graphDb.shutdown();
	}
	
}
