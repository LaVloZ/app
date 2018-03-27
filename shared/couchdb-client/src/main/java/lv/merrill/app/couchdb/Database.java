package lv.merrill.app.couchdb;

public interface Database<T> {

	public T get(CouchDbId id, Class<T> clazz) throws CouchDbException;

	public CouchDbId save(T value) throws CouchDbException;

	public void update(CouchDbId id, T value) throws CouchDbException;

	public void remove(CouchDbId id) throws CouchDbException;
}
