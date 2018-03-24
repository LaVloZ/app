package lv.merrill.app.couchdb;

public class CouchDbException extends Exception {

	private static final long serialVersionUID = -4332182510131573627L;

	public CouchDbException() {
	}

	public CouchDbException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CouchDbException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CouchDbException(String arg0) {
		super(arg0);
	}

	public CouchDbException(Throwable arg0) {
		super(arg0);
	}
}
