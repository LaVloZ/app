package lv.merrill.apprentissage.user.comm;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {

	private static final String CONNECTION_FACTORY_NAME = "mainJmsFactory";
	private static final String CREATE_DESTINATION_NAME = "person/create";
	private static final String GET_ALL_DESTINATION_NAME = "person/getAll";

	public static void main(String[] args) throws NamingException {

		try {
			Context context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup(CONNECTION_FACTORY_NAME);
			Destination createDestination = (Destination) context.lookup(CREATE_DESTINATION_NAME);
			Destination getAllDestination = (Destination) context.lookup(GET_ALL_DESTINATION_NAME);
			Connection connection = factory.createConnection();
			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageConsumer createConsumer = session.createConsumer(createDestination);
			MessageProducer createProducer = session.createProducer(createDestination);
			UserCreationDemandeConsumerListener creationListener = new UserCreationDemandeConsumerListener(createProducer);
			createConsumer.setMessageListener(creationListener);
			
			MessageConsumer getAllConsumer = session.createConsumer(getAllDestination);
			MessageProducer getAllProducer = session.createProducer(getAllDestination);
			UserGetAllConsumer getAllListener = new UserGetAllConsumer(getAllProducer);
			getAllConsumer.setMessageListener(getAllListener);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
