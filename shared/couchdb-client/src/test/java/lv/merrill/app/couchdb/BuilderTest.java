package lv.merrill.app.couchdb;

import org.assertj.core.api.BDDAssertions;
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
		
		BDDAssertions.then(client).isNotNull();
	}
}
