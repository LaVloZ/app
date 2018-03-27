package lv.merrill.app.couchdb;

import java.net.MalformedURLException;
import java.net.URL;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

class TestUtil {

	static final URL DUMMY_URL;
	static final URL DUMMY_DATABASE_URL;

	static {
		URL url = null;
		URL databaseUrl = null;
		try {
			url = new URL("http:/localhost:8080/");
			url = new URL("http:/localhost:8080/test/");
		} catch (MalformedURLException e) {
			// Ignored.
		}
		DUMMY_URL = url;
		DUMMY_DATABASE_URL = databaseUrl;
	}

	static final HttpClient HTTP_CLIENT = HttpClientBuilder.create().build();

	static final Jsonb JSONB = JsonbBuilder.create();

	static final CouchDbId DUMMY_ID = new CouchDbId("id_couchdb_123456");
}
