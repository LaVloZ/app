package lv.merrill.app.couchdb;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class IdGeneratorImpl implements IdGenerator {
	
	private static final String UUID_ENDPOINT_PATTERN = "%s/_uuid/";

	private ApacheHttpClient client;
	private IteratorAdapter iteratorAdapter;

	IdGeneratorImpl(ApacheHttpClient client) {
		this.client = client;
	}

	@Override
	public Iterator<CouchDbId> iterator() {
		return iteratorAdapter;
	}

	@Override
	public CouchDbId next() throws CouchDbException {
		try {
			String baseUrlString = client.getBaseUrl().toURI().normalize().toString();
			String uuidEndpoint = String.format(UUID_ENDPOINT_PATTERN, baseUrlString);
			HttpUriRequest request = new HttpGet(uuidEndpoint);
			return client.fetchFromRequestAndParseContent(request, CouchDbId.class);
		} catch (URISyntaxException | IOException e) {
			throw new CouchDbException(e);
		}
	}

	private class IteratorAdapter implements Iterator<CouchDbId> {

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public CouchDbId next() {
			try {
				return IdGeneratorImpl.this.next();
			} catch (CouchDbException e) {
				throw new IllegalStateException(e);
			}
		}
	}
}
