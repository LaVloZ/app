package lv.merrill.app.user.evt;

import java.time.LocalDateTime;

import lv.merrill.app.shared.evt.AbstractEvent;

public class UserCreationEvent extends AbstractEvent {

	public UserCreationEvent(LocalDateTime time) {
		super(time);
	}
}
