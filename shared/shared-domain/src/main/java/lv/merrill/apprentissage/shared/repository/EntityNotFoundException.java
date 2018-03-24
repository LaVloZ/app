package lv.merrill.apprentissage.shared.repository;

public class EntityNotFoundException extends CrudException {

	private static final long serialVersionUID = -900168743733911615L;

	public EntityNotFoundException() {
	}

	public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}
}
