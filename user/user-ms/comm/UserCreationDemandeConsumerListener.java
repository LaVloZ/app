package lv.merrill.apprentissage.user.comm;

import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.json.JsonObject;

import lv.merrill.apprentissage.shared.comm.AbstractJsonJmsMessageListener;

public class UserCreationDemandeConsumerListener extends AbstractJsonJmsMessageListener {

	private MessageProducer producer;

	public UserCreationDemandeConsumerListener(MessageProducer producer) {
		this.producer = producer;
	}

	@Override
	protected void doOnMessage(JsonObject json) {
		
	}

	@Override
	protected void doOnMessageParseFailed(TextMessage message) {
		
	}
}
