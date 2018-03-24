package lv.merrill.app.couchdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.json.bind.Jsonb;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class ResourceImpl<T> implements Resource<T> {

	private URL target;
	private URI targetUri;
	private HttpClient httpClient;
	private Jsonb jsonb;

	ResourceImpl(URL target, HttpClient httpClient, Jsonb jsonb) throws URISyntaxException {
		this.target = target;
		targetUri = target.toURI().normalize();
		this.httpClient = httpClient;
		this.jsonb = jsonb;
	}

	@Override
	public T get(CouchDbId id, Class<T> clazz) throws CouchDbException {
		try {
			HttpUriRequest request = new HttpGet(targetUri);
			InputStream in = fetchFromRequest(request);
			return jsonb.fromJson(in, clazz);
		} catch (IOException e) {
			throw new CouchDbException(e);
		}
	}

	@Override
	public CouchDbId save(T value) throws CouchDbException {
		return null;
	}

	@Override
	public void update(CouchDbId id, T value) throws CouchDbException {

	}

	@Override
	public void remove(CouchDbId id) throws CouchDbException {
	}

	@Override
	public CouchDbId nextId() throws CouchDbException {
		return null;
	}

	URL getTarget() {
		return target;
	}

	private InputStream fetchFromRequest(HttpUriRequest request) throws ClientProtocolException, IOException {
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}
}
