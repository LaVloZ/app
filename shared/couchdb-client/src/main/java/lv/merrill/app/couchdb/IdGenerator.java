package lv.merrill.app.couchdb;

import java.util.Iterator;

public interface IdGenerator extends Iterable<CouchDbId> {

	@Override
	public Iterator<CouchDbId> iterator();

	public CouchDbId next() throws CouchDbException;
}
