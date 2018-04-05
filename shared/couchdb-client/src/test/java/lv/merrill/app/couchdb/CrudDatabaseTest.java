package lv.merrill.app.couchdb;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpUriRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrudDatabaseTest {

	private CrudDatabase<String> database;
	private ApacheHttpClient client;

	@BeforeEach
	public void initTestCase() throws URISyntaxException {
		client = mock(ApacheHttpClient.class);
		database = spy(new CrudDatabase<String>(TestUtil.DUMMY_DATABASE_URL, client));
	}

	@Test
	public void get() throws URISyntaxException, CouchDbException, IOException {
		given(client.fetchFromRequestAndParseContent(any(HttpUriRequest.class), String.class));

		database.save("Hello world");
	}
}
