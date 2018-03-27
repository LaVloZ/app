package lv.merrill.app.user.domain;

import lv.merrill.app.couchdb.CouchDbException;
import lv.merrill.app.couchdb.CouchDbId;
import lv.merrill.app.couchdb.Database;
import lv.merrill.app.couchdb.IdGenerator;
import lv.merrill.app.couchdb.MalformedCouchDbDatabaseException;
import lv.merrill.app.shared.repository.CrudException;
import lv.merrill.app.shared.repository.IdGenerationException;

public class CouchDbUserRespository implements UserRepository {

	private IdGenerator idGenerator;
	private Database<User> userDatabase;

	public CouchDbUserRespository(IdGenerator idGenerator, Database<User> userDatabase)
			throws MalformedCouchDbDatabaseException {
		this.idGenerator = idGenerator;
		this.userDatabase = userDatabase;
	}

	@Override
	public User get(String id) throws CrudException {

		try {
			CouchDbId wrappedId = CouchDbId.fromString(id);
			return userDatabase.get(wrappedId, User.class);
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
