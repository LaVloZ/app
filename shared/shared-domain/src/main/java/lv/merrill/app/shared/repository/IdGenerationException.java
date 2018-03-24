package lv.merrill.app.shared.repository;

public class IdGenerationException extends RuntimeException {

	private static final long serialVersionUID = -8591726194732040765L;

	public IdGenerationException() {
		super();
	}

	public IdGenerationException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdGenerationException(String message) {
		super(message);
	}

	public IdGenerationException(Throwable cause) {
		super(cause);
	}
}
