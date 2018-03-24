package lv.merrill.apprentissage.user.domain;

import java.time.LocalDate;
import java.util.Objects;

public class UserFactory {

	private UserRepository repository;

	public UserFactory(UserRepository repository) {
		this.repository = repository;
	}

	public User create(String firstname, String lastname, LocalDate birthday)
			throws InvalideUserDataException {

		if (Objects.isNull(firstname) || firstname.isEmpty()) {
			throw new InvalideUserDataException(
					"firstname shouldn't be null or empty.");
		}

		if (Objects.isNull(lastname) || lastname.isEmpty()) {
			throw new InvalideUserDataException(
					"lastname shouldn't be null or empty.");
		}

		LocalDate now = LocalDate.now();
		if (Objects.isNull(birthday) || birthday.isAfter(now)) {
			throw new InvalideUserDataException(
					"birthday shouldn't be null or less than current date.");
		}

		String id = repository.nextId();
		return new User(id, firstname, lastname, birthday);
	}
}
