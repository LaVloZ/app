package lv.merrill.app.user.domain;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2468031744389212826L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserNotFoundException(String arg0) {
		super(arg0);
	}

	public UserNotFoundException(Throwable arg0) {
		super(arg0);
	}
}
