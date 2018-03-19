package lv.merrill.apprentissage.user.evt;

import java.time.LocalDateTime;

import lv.merrill.apprentissage.shared.evt.AbstractEvent;

public class UserCreationEvent extends AbstractEvent {

	public UserCreationEvent(LocalDateTime time) {
		super(time);
	}
}
