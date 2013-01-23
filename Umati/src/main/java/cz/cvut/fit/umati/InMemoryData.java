package cz.cvut.fit.umati;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import cz.cvut.fit.umati.model.User;
import cz.cvut.fit.umati.model.WebApi;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("singleton")
public class InMemoryData {
	private final Set<User> userSet;
	
	private final Set<WebApi> webApiSet;
	
	/*
	 * Constructor
	 */
	public InMemoryData() {
		// Init userSet 
		userSet = new HashSet<User>();
				
		// TODO: Init and fill up Web Apis
		webApiSet = new HashSet<WebApi>();
		
		try {
			WebApi webApi1 = new WebApi();
			webApi1.setName("Twitter API");
			webApi1.setDescription("Microblogging service");
			webApi1.setCategory("Social");
			webApi1.setDocUrl(new URI("https://dev.twitter.com/docs"));
			webApi1.setApiUrl(new URI("http://twitter.com/statuses/"));
			webApiSet.add(webApi1);
			
			WebApi webApi2 = new WebApi();
			webApi2.setName("Flickr API");
			webApi2.setDescription("Photo sharing service");
			webApi2.setCategory("Photos");
			webApi2.setDocUrl(new URI("http://www.flickr.com/services/api/"));
			webApi2.setApiUrl(new URI("http://api.flickr.com/services/rest/"));
			webApiSet.add(webApi2);

			WebApi webApi3 = new WebApi();
			webApi3.setName("Amazon eCommerce API");
			webApi3.setDescription("Online retailer");
			webApi3.setCategory("Shopping");
			webApi3.setDocUrl(new URI("https://affiliate-program.amazon.com/gp/advertising/api/detail/main.html"));
			webApi3.setApiUrl(new URI("http://webservices.amazon.com/"));
			webApiSet.add(webApi3);

			WebApi webApi4 = new WebApi();
			webApi4.setName("Facebook API");
			webApi4.setDescription("Social networking service");
			webApi4.setCategory("Social");
			webApi4.setDocUrl(new URI("http://developers.facebook.com/"));
			webApi4.setApiUrl(new URI("http://api.facebook.com/restserver.php"));
			webApiSet.add(webApi4);

			WebApi webApi5 = new WebApi();
			webApi5.setName("Twilio API");
			webApi5.setDescription("Telephony service");
			webApi5.setCategory("Telephony");
			webApi5.setDocUrl(new URI("http://www.twilio.com"));
			webApi5.setApiUrl(new URI("https://api.twilio.com/2008-08-01/"));
			webApiSet.add(webApi5);

			WebApi webApi6 = new WebApi();
			webApi6.setName("Last.fm API");
			webApi6.setDescription("Online radio service");
			webApi6.setCategory("Music");
			webApi6.setDocUrl(new URI("http://www.last.fm/api"));
			webApi6.setApiUrl(new URI("http://ws.audioscrobbler.com/2.0/"));
			webApiSet.add(webApi6);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Getters & Setters
	 */
	public Set<User> getUserSet() {
		return userSet;
	}

	public Set<WebApi> getWebApiGroupSet() {
		return webApiSet;
	}
}
