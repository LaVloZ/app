package lv.merrill.app.couchdb;

public class MalformedCouchDbDatabaseException extends CouchDbException {

	private static final long serialVersionUID = 2984678102886520288L;

	public MalformedCouchDbDatabaseException() {
	}

	public MalformedCouchDbDatabaseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MalformedCouchDbDatabaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MalformedCouchDbDatabaseException(String arg0) {
		super(arg0);
	}

	public MalformedCouchDbDatabaseException(Throwable arg0) {
		super(arg0);
	}
}
