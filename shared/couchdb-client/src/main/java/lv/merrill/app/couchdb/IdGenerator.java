package lv.merrill.app.couchdb;

import java.util.Iterator;
import java.util.stream.Stream;

public interface IdGenerator extends Iterable<CouchDbId> {

	@Override
	public Iterator<CouchDbId> iterator();

	public CouchDbId next() throws CouchDbException;
	
	public Stream<CouchDbId> stream();
}
