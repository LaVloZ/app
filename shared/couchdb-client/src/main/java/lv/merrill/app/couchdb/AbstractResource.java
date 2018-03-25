package lv.merrill.app.couchdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

abstract class AbstractResource<T> implements Resource<T> {

	URL target;
	URI targetUri;
	ApacheHttpClient client;

	AbstractResource(URL target, ApacheHttpClient client) throws URISyntaxException {
		this.target = target;
		targetUri = target.toURI().normalize();
		this.client = client;
	}

	URL getTarget() {
		return target;
	}
}
