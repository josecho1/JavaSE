package singleton.example3.serializable;
//import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton3 implements Serializable{

	private static final long serialVersionUID = -4137189065490862968L;
	private static Singleton3 instance = null;

	private Singleton3()
	{
		super();
	}

	public static Singleton3 getInstance()
	{
		if( instance == null )
			instance = new Singleton3();
		return instance;
	}
	
	// Uncomment, that will be able to serialize the object and at any point of time we will get the consistent
	// singleton class, however still we can create multiple instance using Reflection.
	
	/*private Object readResolve() throws ObjectStreamException
	{
		return instance;
	}

	private Object writeReplace() throws ObjectStreamException
	{
		return instance;
	}*/

}
