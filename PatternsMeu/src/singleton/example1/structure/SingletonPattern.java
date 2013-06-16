package singleton.example1.structure;


//Since this isn't inherited from a Cloneable
//base class and cloneability isn't added,
//making it final prevents cloneability from
//being added through inheritance:
final class Singleton1 {
	
	private static Singleton1 singl = new Singleton1(11);

	private int i;

	private Singleton1(int x) {
		i = x;
	}

	public static Singleton1 getReference() {
		return singl;
	}

	public int getValue() {
		return i;
	}

	public void setValue(int x) {
		i = x;
	}
}

public class SingletonPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton1 singlA = Singleton1.getReference();

		String result = "" + singlA.getValue();

		System.out.println(result);

		Singleton1 singlB = Singleton1.getReference();

		singlB.setValue(22);

		result = "" + singlB.getValue();

		System.out.println(result);
		

		try {

			// Can't do this: compile-time error.

			//Singleton1 singlC = (Singleton1)singlB.clone();

		} catch (Exception e) {

			throw new RuntimeException(e);

		}
	}
}
