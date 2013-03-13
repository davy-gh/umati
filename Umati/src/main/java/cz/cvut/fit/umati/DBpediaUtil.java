package cz.cvut.fit.umati;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Resource;

public class DBpediaUtil {
	private final static String queryBegin = "PREFIX  owl:  <http://www.w3.org/2002/07/owl#>\n" + "PREFIX  rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n\n";

	/**
	 * 
	 */
	public DBpediaUtil() {
//		List<Resource> m = getAllClasses();
//
//		for (Resource resource : m) {
//			System.out.println("Name: " + resource.getLocalName() + " URI: " + resource.getURI());
//		}
//
//		List<Resource> n = getAllProperties("http://dbpedia.org/ontology/WrittenWork");
//
//		for (Resource resource : n) {
//			System.out.println("Name: " + resource.getLocalName() + " URI: " + resource.getURI());
//		}
	}

	public static List<Resource> getAllClasses() {
//		String allClassesQuery = "select ?type where { ?type a owl:Class }";
		List<Resource> output = new ArrayList<Resource>();
//
//		Query query = QueryFactory.create(queryBegin + allClassesQuery);
//		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://live.dbpedia.org/sparql", query);
//
//		ResultSet results = qexec.execSelect();
//		// ResultSetFormatter.out(System.out, results, query);
//
//		while (results.hasNext()) {
//			QuerySolution querySolution = results.next();
//			Iterator<String> varNamesIterator = querySolution.varNames();
//
//			while (varNamesIterator.hasNext()) {
//				String key = varNamesIterator.next();
//				output.add(querySolution.getResource(key));
//			}
//		}
//
//		qexec.close();

		return output;
	}

	/**
	 * 
	 * @param keyword
	 * @return
	 */
	public static List<Resource> getAllProperties(String uri) {
		String allPropertiesQuery = "select distinct ?property where {" + "?property <http://www.w3.org/2000/01/rdf-schema#domain>" + "<" + uri + "> . }";
		List<Resource> output = new ArrayList<Resource>();

		Query query = QueryFactory.create(queryBegin + allPropertiesQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://live.dbpedia.org/sparql", query);

		ResultSet results = qexec.execSelect();
		// ResultSetFormatter.out(System.out, results, query);

		while (results.hasNext()) {
			QuerySolution querySolution = results.next();
			Iterator<String> varNamesIterator = querySolution.varNames();

			while (varNamesIterator.hasNext()) {
				String key = varNamesIterator.next();
				output.add(querySolution.getResource(key));
			}
		}

		qexec.close();

		return output;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new DBpediaUtil();
	}
}
