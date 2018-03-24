package lv.merrill.apprentissage.shared.repository;

public class CrudException extends RuntimeException {

	private static final long serialVersionUID = 8264308539183940676L;

	public CrudException() {
	}

	public CrudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CrudException(String message, Throwable cause) {
		super(message, cause);
	}

	public CrudException(String message) {
		super(message);
	}

	public CrudException(Throwable cause) {
		super(cause);
	}
}
