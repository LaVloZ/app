package lv.merrill.apprentissage.shared.comm;

import java.io.StringReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;

public abstract class AbstractJsonJmsMessageListener implements MessageListener {

	public void onMessage(Message message) {

		try {
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			StringReader reader = new StringReader(text);
			JsonParser parser = Json.createParser(reader);
			JsonObject json = parser.getObject();
			doOnMessage(json);
		} catch (JMSException e) {
		}
	}

	protected abstract void doOnMessage(JsonObject json);

	protected abstract void doOnMessageParseFailed(TextMessage message);
}
