package lv.merrill.app.couchdb;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApacheHttpClientTest {

	private ApacheHttpClient client;

	@BeforeEach
	public void initTestCase() {
		client = new ApacheHttpClient(TestUtil.DUMMY_URL, TestUtil.HTTP_CLIENT, TestUtil.JSONB);
	}

	@Test
	public void getResource() throws MalformedCouchDbResourceException, MalformedURLException {
		ResourceImpl<?> resource = (ResourceImpl<?>) client.getResource("test");
		URL expected = new URL(TestUtil.DUMMY_URL + "/test");
		URL actual = resource.getTarget();
		assertThat(actual).isEqualTo(expected);
	}
}
