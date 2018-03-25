package lv.merrill.app.user.domain;

import lv.merrill.app.couchdb.CouchDbException;
import lv.merrill.app.couchdb.CouchDbId;
import lv.merrill.app.couchdb.IdGenerator;
import lv.merrill.app.couchdb.MalformedCouchDbResourceException;
import lv.merrill.app.couchdb.Resource;
import lv.merrill.app.shared.repository.CrudException;
import lv.merrill.app.shared.repository.IdGenerationException;

public class CouchDbUserRespository implements UserRepository {

	private IdGenerator idGenerator;
	private Resource<User> userResource;

	public CouchDbUserRespository(IdGenerator idGenerator, Resource<User> userResource)
			throws MalformedCouchDbResourceException {
		this.idGenerator = idGenerator;
		this.userResource = userResource;
	}

	@Override
	public User get(String id) throws CrudException {

		try {
			CouchDbId wrappedId = CouchDbId.fromString(id);
			return userResource.get(wrappedId, User.class);
		} catch (CouchDbException e) {
			throw new CrudException(e);
		}
	}

	@Override
	public String nextId() throws IdGenerationException {

		try {
			return idGenerator.next().asString();
		} catch (Exception e) {
			throw new IdGenerationException(e);
		}
	}
}
