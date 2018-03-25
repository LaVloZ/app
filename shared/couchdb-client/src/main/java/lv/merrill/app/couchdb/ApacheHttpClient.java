package lv.merrill.app.couchdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.json.bind.Jsonb;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

class ApacheHttpClient implements Client {

	private static final String TARGET_PATTERN = "%s/%s";

	private URL baseUrl;
	private HttpClient httpClient;
	private Jsonb jsonb;

	ApacheHttpClient(URL baseUrl, HttpClient httpClient, Jsonb jsonb) {
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
			return new CrudResource<T>(target, this);
		} catch (MalformedURLException | URISyntaxException e) {
			throw new MalformedCouchDbResourceException(e);
		}
	}

	@Override
	public IdGenerator getGenerator() {
		return null;
	}

	InputStream fetchFromRequest(HttpUriRequest request) throws ClientProtocolException, IOException {
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	<T> T parseContent(InputStream in, Class<T> clazz) {
		return jsonb.fromJson(in, clazz);
	}

	<T> T fetchFromRequestAndParseContent(HttpUriRequest request, Class<T> clazz) throws IOException {
		InputStream in = fetchFromRequest(request);
		return parseContent(in, clazz);
	}
	
	URL getBaseUrl() {
		return baseUrl;
	}
}
