package lv.merrill.app.couchdb;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class CrudDatabase<T> extends AbstractDatabase<T> implements Database<T> {

	CrudDatabase(URL target, ApacheHttpClient client) throws URISyntaxException {
		super(target, client);
	}

	@Override
	public T get(CouchDbId id, Class<T> clazz) throws CouchDbException {
		try {
			HttpUriRequest request = new HttpGet(targetUri);
			return client.fetchFromRequestAndParseContent(request, clazz);
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
}
