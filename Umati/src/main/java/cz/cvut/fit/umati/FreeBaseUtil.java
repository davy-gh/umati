package cz.cvut.fit.umati;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class FreeBaseUtil {

	public FreeBaseUtil() {
		query("Person");
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> query(String queryWord) {
		// Output data
		Map<String, Object> result = null;

		// Jersey client
		ClientConfig cc = new DefaultClientConfig();
		cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		Client c = Client.create(cc);

		// Web Resource
		WebResource r = c.resource("https://www.googleapis.com/freebase/v1/");

		// Parameters
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("query", queryWord);
		// queryParams.add("start", "10");
		// queryParams.add("limit", "10");
		queryParams.add("indent", "true");
		queryParams.add("type", "/type/type");

		// Go
		ClientResponse response = r.path("search").queryParams(queryParams).accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);

		// read JSON return Map
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try {
			result = mapper.readValue(response.getEntity(String.class), Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		new FreeBaseUtil();
	}
}
