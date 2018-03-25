package lv.merrill.app.couchdb;

public class CouchDbId {

	private String id;

	CouchDbId(String id) {
		this.id = id;
	}

	public String asString() {
		return id;
	}

	public static CouchDbId fromString(String id) {
		return new CouchDbId(id);
	}
};
