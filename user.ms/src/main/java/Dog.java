
public class Dog {

	private static final String TOSTRING_PATTERN = "Dog [name = %s, age = %s, bitable = %s]";

	private String name;
	private int age;
	private boolean bitable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBitable() {
		return bitable;
	}

	public void setBitable(boolean bitable) {
		this.bitable = bitable;
	}

	@Override
	public String toString() {

		return String.format(TOSTRING_PATTERN, name, age, bitable);
	}
}
