package lv.merrill.app.couchdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuilderTest {

	private Builder builder;

	@BeforeEach
	public void initTestCase() {
		builder = new Builder(TestUtil.DUMMY_URL);
	}

	@Test
	public void newClient() {
		Client client = builder.newClient();
		assertThat(client).isNotNull();
	}
}
