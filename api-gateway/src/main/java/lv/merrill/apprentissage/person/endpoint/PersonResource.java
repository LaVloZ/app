package lv.merrill.apprentissage.person.endpoint;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class PersonResource {

	private Session session;
	private Destination destination;

	private MessageConsumer consumer;
	private MessageProducer producer;

	public PersonResource(Session session, Destination destination) throws JMSException {
		this.session = session;
		this.destination = destination;

		session.createConsumer(destination);
		session.createProducer(destination);
	}

	public void getAll() {

	}

	public void get() {

	}

	public void create() {

	}

	public void delete() {

	}
}
