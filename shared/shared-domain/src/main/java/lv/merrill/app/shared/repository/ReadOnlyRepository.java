package lv.merrill.app.shared.repository;

public interface ReadOnlyRepository<T, V> {

	public V get(T id) throws EntityNotFoundException;
}
