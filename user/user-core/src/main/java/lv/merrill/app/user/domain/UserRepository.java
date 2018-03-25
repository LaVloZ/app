package lv.merrill.app.user.domain;

import lv.merrill.app.shared.repository.CrudException;
import lv.merrill.app.shared.repository.IdGenerationException;

public interface UserRepository {

	public User get(String id) throws CrudException;

	public String nextId() throws IdGenerationException;
}
