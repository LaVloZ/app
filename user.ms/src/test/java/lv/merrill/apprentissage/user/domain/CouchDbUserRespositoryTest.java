package lv.merrill.apprentissage.user.domain;

import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class CouchDbUserRespositoryTest {

	private CouchDbUserRespository repository;

	@Before
	public void initTestCase() throws MalformedURLException {
		URL baseUrl = new URL("http://127.0.0.1:5984");
		HttpClient client = HttpClientBuilder.create().build();
		Jsonb jsonb = JsonbBuilder.create();

		repository = new CouchDbUserRespository(baseUrl, client, jsonb);
	}

	@Test
	public void nextId() {
		String id = repository.nextId();
		assertThat(id, CoreMatchers.notNullValue());
	}
}
