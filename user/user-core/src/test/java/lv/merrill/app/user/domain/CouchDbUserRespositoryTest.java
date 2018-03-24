package lv.merrill.app.user.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

public class CouchDbUserRespositoryTest {

	private CouchDbUserRespository repository;

	public void initTestCase() throws MalformedURLException {
		URL baseUrl = new URL("http://127.0.0.1:5984");
		HttpClient client = HttpClientBuilder.create().build();
		Jsonb jsonb = JsonbBuilder.create();

		repository = new CouchDbUserRespository(baseUrl, client, jsonb);
	}

	@Test
	public void nextId() {
		String id = repository.nextId();
		assertThat(id).isNotNull();
	}
}
