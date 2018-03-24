package lv.merrill.app.shared.couchdb;

import java.util.List;

public class UuidJson {

	private List<String> uuids;

	public UuidJson(List<String> uuids) {
		this.uuids = uuids;
	}

	public UuidJson() {
	}

	public List<String> getUuids() {
		return uuids;
	}

	public String getFirstUuids() {
		return uuids.get(0);
	}
}
