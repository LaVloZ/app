package lv.merrill.app.couchdb;

import java.net.URL;

import javax.json.bind.Jsonb;

import org.apache.http.client.HttpClient;

public class Builder {

	private URL baseUrl;
	private HttpClient httpClient;
	private Jsonb jsonb;

	public Builder(URL baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Client newClient() {
		return new ApacheHttpClient(baseUrl, httpClient, jsonb);
	}
}
