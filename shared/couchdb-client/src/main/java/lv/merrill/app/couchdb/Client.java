package lv.merrill.app.couchdb;

public interface Client {

	public <T> Resource<T> getResource(String resource) throws MalformedCouchDbResourceException;
	
	public IdGenerator getGenerator();
}
