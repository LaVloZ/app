package lv.merrill.apprentissage.shared.evt;

import java.time.LocalDateTime;

public class AbstractEvent {

	private LocalDateTime time;

	public AbstractEvent(LocalDateTime time) {
		this.time = time;
	}

	public LocalDateTime getTime() {
		return time;
	}
}
