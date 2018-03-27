package lv.merrill.app.couchdb;

public interface Client {

	public <T> Database<T> getDatabase(String database) throws MalformedCouchDbDatabaseException;
	
	public IdGenerator getGenerator();
}
