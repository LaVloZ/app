package lv.merrill.app.couchdb;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.net.URISyntaxException;

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
	public void get() throws URISyntaxException {

	}
}
