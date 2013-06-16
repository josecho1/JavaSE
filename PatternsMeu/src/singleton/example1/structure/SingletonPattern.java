package singleton.example1.structure;

import java.lang.reflect.Constructor;
/*import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.security.Permission;*/


//Since this isn't inherited from a Cloneable
//base class and cloneability isn't added,
//making it final prevents cloneability from
//being added through inheritance:
final class Singleton1 {
	
	private static Singleton1 singl = new Singleton1(11);

	private int i;

	private Singleton1(int x) {
		i = x;
		//Add the following piece of code so that it can not be invoked using relection
				/*System.setSecurityManager(new SecurityManager() {
		            @Override
		            public void checkPermission(Permission perm) 
		            {
		            	if (perm instanceof ReflectPermission )
		            	{
		            		System.out.println("\nYes I will not allow you to create the instance using Reflection...\n");
		            		throw new SecurityException();
		            	}
		            	else
		            	{
		            		//Do nothing
		            	}
		            }});*/
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

		Singleton1 singlA = Singleton1.getReference();
		System.out.println(singlA);
		String result = "" + singlA.getValue();
		System.out.println(result);
		Singleton1 singlB = Singleton1.getReference();
		System.out.println(singlB);
		singlB.setValue(22);
		result = "" + singlB.getValue();
		System.out.println(result);
		try {
			// Can't do this: compile-time error.
			//Singleton1 singlC = (Singleton1)singlB.clone();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		System.out.println("\n** MULTIPLE INSTANCES FROM SINGLETO **\n");
		System.out.println("** Using Reflection you can break singleton **");
		/*
		 * Using Reflection you can break singleton
		 */
		try 
		{
			Class clazz = Class.forName("singleton.example1.structure.Singleton1");
			Constructor constructor = clazz.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			Singleton1 instance1 = (Singleton1)constructor.newInstance(33);
			Singleton1 instance2 = (Singleton1)constructor.newInstance(44);
			Singleton1 instance3 = (Singleton1)constructor.newInstance(55);

			System.out.printf( "%-15s %-15s %n", "SERIAL NO", "MULTI INSTANCES");
			System.out.printf( "%-15s %-15s %n", "---------", "---------------");

			System.out.format("%-15s %-15s %n", "INSTANCE 1 ",instance1);
			System.out.format("%-15s %-15s %n", "INSTANCE 2 ",instance2);
			System.out.format("%-15s %-15s %n", "INSTANCE 3 ",instance3);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
		
}

