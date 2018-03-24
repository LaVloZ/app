package lv.merrill.apprentissage.shared.evt;

import java.time.LocalDateTime;

public interface Event {

	/**
	 * Get occured time.
	 * 
	 * @return Occured time.
	 */
	public LocalDateTime getTime();
}
