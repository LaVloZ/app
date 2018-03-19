import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Test {

	public static void main(String[] args) {

		String j = "{\"age\":4,\"bitable\":false,\"name\":\"Falco\"}";
		
		Dog dog = new Dog();
		dog.setName("Falco");
		dog.setAge(4);
		dog.setBitable(false);

		Jsonb jsonb = JsonbBuilder.create();
		Dog d = jsonb.fromJson(j, Dog.class);

		System.out.println(d);
	}
}
