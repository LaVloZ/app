package lv.merrill.app.couchdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

import org.apache.http.client.methods.HttpUriRequest;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IdGeneratorImplTest {

	private IdGeneratorImpl generator;
	private ApacheHttpClient client;

	@BeforeEach
	public void initTestCase() throws IOException {
		client = mock(ApacheHttpClient.class);
		generator = spy(new IdGeneratorImpl(client));

		given(client.fetchFromRequestAndParseContent(any(HttpUriRequest.class), eq(CouchDbId.class)))
				.willReturn(TestUtil.DUMMY_ID);
		given(client.getBaseUrl()).willReturn(TestUtil.DUMMY_URL);
	}

	@Test
	public void next() throws IOException, CouchDbException {
		CouchDbId id = generator.next();

		assertThat(id).isEqualTo(TestUtil.DUMMY_ID);
		then(client).should().fetchFromRequestAndParseContent(any(HttpUriRequest.class), eq(CouchDbId.class));
	}

	@Test
	public void nextException() throws IOException, CouchDbException {
		given(client.fetchFromRequestAndParseContent(any(HttpUriRequest.class), eq(CouchDbId.class)))
				.willThrow(new IOException());

		Throwable t = assertThrows(CouchDbException.class, generator::next);
		BDDAssertions.then(t).isInstanceOfAny(CouchDbException.class);
		Throwable c = t.getCause();
		BDDAssertions.then(c).isInstanceOf(IOException.class);
	}

	@Test
	public void iterator() {
		Iterator<CouchDbId> iterator = generator.iterator();

		BDDAssertions.then(iterator).isNotNull();
	}

	@Test
	public void stream() {
		Stream<CouchDbId> stream = generator.stream();

		BDDAssertions.then(stream).isNotNull();
	}
}
