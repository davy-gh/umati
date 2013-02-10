package cz.cvut.fit.umati;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.vaadin.data.util.BeanItemContainer;

import cz.cvut.fit.umati.model.WebApi;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("singleton")
public class InMemoryWebApiData extends BeanItemContainer<WebApi> {
	private static final long serialVersionUID = 1L;

	/*
	 * Constructor
	 */
	@Autowired
	public InMemoryWebApiData(@Value("cz.cvut.fit.umati.model.WebApi") Class<? super WebApi> type) throws IllegalArgumentException {
		super(type);

		try {
			WebApi webApi1 = new WebApi();
			webApi1.setName("Twitter API");
			webApi1.setDescription("Microblogging service");
			webApi1.setCategory("Social");
			webApi1.setDocUrl(new URI("https://dev.twitter.com/docs"));
			webApi1.setApiUrl(new URI("http://twitter.com/statuses/"));
			addBean(webApi1);
			
			WebApi webApi2 = new WebApi();
			webApi2.setName("Flickr API");
			webApi2.setDescription("Photo sharing service");
			webApi2.setCategory("Photos");
			webApi2.setDocUrl(new URI("http://www.flickr.com/services/api/"));
			webApi2.setApiUrl(new URI("http://api.flickr.com/services/rest/"));
			addBean(webApi2);

			WebApi webApi3 = new WebApi();
			webApi3.setName("Amazon eCommerce API");
			webApi3.setDescription("Online retailer");
			webApi3.setCategory("Shopping");
			webApi3.setDocUrl(new URI("https://affiliate-program.amazon.com/gp/advertising/api/detail/main.html"));
			webApi3.setApiUrl(new URI("http://webservices.amazon.com/"));
			addBean(webApi3);

			WebApi webApi4 = new WebApi();
			webApi4.setName("Facebook API");
			webApi4.setDescription("Social networking service");
			webApi4.setCategory("Social");
			webApi4.setDocUrl(new URI("http://developers.facebook.com/"));
			webApi4.setApiUrl(new URI("http://api.facebook.com/restserver.php"));
			addBean(webApi4);

			WebApi webApi5 = new WebApi();
			webApi5.setName("Twilio API");
			webApi5.setDescription("Telephony service");
			webApi5.setCategory("Telephony");
			webApi5.setDocUrl(new URI("http://www.twilio.com"));
			webApi5.setApiUrl(new URI("https://api.twilio.com/2008-08-01/"));
			addBean(webApi5);

			WebApi webApi6 = new WebApi();
			webApi6.setName("Last.fm API");
			webApi6.setDescription("Online radio service");
			webApi6.setCategory("Music");
			webApi6.setDocUrl(new URI("http://www.last.fm/api"));
			webApi6.setApiUrl(new URI("http://ws.audioscrobbler.com/2.0/"));
			addBean(webApi6);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void fireUpdate() {
		fireItemSetChange();
	}
}
