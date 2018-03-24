package lv.merrill.app.shared.repository;

public interface CrudRepository<T, V> extends ReadOnlyRepository<T, V> {

	public void add(V v) throws CrudException;

	public void update(V v) throws CrudException;

	public void remove(V v) throws CrudException;
}
