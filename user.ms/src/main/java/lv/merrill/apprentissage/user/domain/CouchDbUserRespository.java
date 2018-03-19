package lv.merrill.apprentissage.user.domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.bind.Jsonb;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import lv.merrill.apprentissage.shared.couchdb.UuidJson;
import lv.merrill.apprentissage.shared.repository.IdGenerationException;

public class CouchDbUserRespository implements UserRepository {

	private static final String ENDPOINT_PATTERN = "%s/%s/";
	private static final String UUID_ENDPOINT = "_uuids";
	private static final String USER_ENDPOINT = "user";

	private URL baseUrl;
	private HttpClient client;
	private Jsonb jsonb;

	public CouchDbUserRespository(URL baseUrl, HttpClient client, Jsonb jsonb) {
		this.baseUrl = baseUrl;
		this.client = client;
		this.jsonb = jsonb;
	}

	@Override
	public User get(String id) {
		try {
			return fetchAndParse(USER_ENDPOINT, User.class);
		}
		catch (Exception e) {
		}

		return null;
	}

	@Override
	public String nextId() throws IdGenerationException {

		try {
			UuidJson uuids = fetchAndParse(UUID_ENDPOINT, UuidJson.class);
			return uuids.getFirstUuids();
		}
		catch (Exception e) {
			throw new IdGenerationException(e);
		}
	}

	private <T> T fetchAndParse(String endpoint, Class<T> clazz)
			throws ClientProtocolException, IOException {

		String base = baseUrl.toString();
		String target = String.format(ENDPOINT_PATTERN, base, endpoint);
		HttpUriRequest request = new HttpGet(target);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		InputStream in = entity.getContent();
		IOUtils.copy(in, System.out);
		return jsonb.fromJson(in, clazz);
	}
}
