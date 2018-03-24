package lv.merrill.app.user.domain;

import lv.merrill.app.shared.repository.IdGenerationException;

public interface UserRepository {

	public User get(String id);

	public String nextId() throws IdGenerationException;
}
