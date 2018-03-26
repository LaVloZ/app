package lv.merrill.app.couchdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

import org.apache.http.client.methods.HttpUriRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IdGeneratorImplTest {

	private IdGeneratorImpl generator;
	private ApacheHttpClient client;

	@BeforeEach
	public void initTestCase() throws IOException {
		client = mock(ApacheHttpClient.class);
		generator = spy(new IdGeneratorImpl(client));

		when(client.fetchFromRequestAndParseContent(any(HttpUriRequest.class), eq(CouchDbId.class)))
				.thenReturn(TestUtil.DUMMY_ID);
		when(client.getBaseUrl()).thenReturn(TestUtil.DUMMY_URL);
	}

	@Test
	public void next() throws IOException, CouchDbException {
		CouchDbId id = generator.next();

		assertThat(id).isEqualTo(TestUtil.DUMMY_ID);
		verify(client).fetchFromRequestAndParseContent(any(HttpUriRequest.class), eq(CouchDbId.class));
	}

	@Test
	public void nextException() throws IOException, CouchDbException {
		when(client.fetchFromRequestAndParseContent(any(HttpUriRequest.class), eq(CouchDbId.class)))
				.thenThrow(new IOException());

		Throwable t = assertThrows(CouchDbException.class, generator::next);
		assertThat(t).isInstanceOfAny(CouchDbException.class);
		Throwable c = t.getCause();
		assertThat(c).isInstanceOf(IOException.class);
	}

	@Test
	public void iterator() {
		Iterator<CouchDbId> iterator = generator.iterator();

		assertThat(iterator).isNotNull();
	}

	@Test
	public void stream() {
		Stream<CouchDbId> stream = generator.stream();

		assertThat(stream).isNotNull();
	}
}
