package lv.merrill.app.user.domain;

public class InvalideUserDataException extends Exception {

	private static final long serialVersionUID = -7281153575800996193L;

	public InvalideUserDataException() {
	}

	public InvalideUserDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalideUserDataException(String message) {
		super(message);
	}

	public InvalideUserDataException(Throwable cause) {
		super(cause);
	}
}
