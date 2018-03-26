package lv.merrill.app.user.comm;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
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
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
