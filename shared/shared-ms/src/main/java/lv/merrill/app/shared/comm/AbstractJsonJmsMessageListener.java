package lv.merrill.app.shared.comm;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public abstract class AbstractJsonJmsMessageListener<T> implements MessageListener {

	public void onMessage(Message message) {

	}

	protected abstract void doOnMessage(T json);

	protected abstract void doOnMessageParseFailed(TextMessage message);
}
