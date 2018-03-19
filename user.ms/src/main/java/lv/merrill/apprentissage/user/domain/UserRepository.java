package lv.merrill.apprentissage.user.domain;

import lv.merrill.apprentissage.shared.repository.IdGenerationException;

public interface UserRepository {

	public User get(String id);

	public String nextId() throws IdGenerationException;
}
