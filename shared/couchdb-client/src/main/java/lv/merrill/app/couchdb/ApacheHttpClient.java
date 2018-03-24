package lv.merrill.app.couchdb;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.json.bind.Jsonb;

import org.apache.http.client.HttpClient;

class ApacheHttpClient implements Client {

	private static final String TARGET_PATTERN = "%s/%s";

	private URL baseUrl;
	private HttpClient httpClient;
	private Jsonb jsonb;

	ApacheHttpClient(URL baseUrl, HttpClient httpClient, Jsonb jsonb) {
		super();
		this.baseUrl = baseUrl;
		this.httpClient = httpClient;
		this.jsonb = jsonb;
	}

	@Override
	public <T> Resource<T> getResource(String resource) throws MalformedCouchDbResourceException {
		try {
			String baseUrlString = baseUrl.toString();
			String targetFormatted = String.format(TARGET_PATTERN, baseUrlString, resource);
			URL target = new URL(targetFormatted);
			return new ResourceImpl<T>(target, httpClient, jsonb);
		} catch (MalformedURLException | URISyntaxException e) {
			throw new MalformedCouchDbResourceException(e);
		}
	}
}
