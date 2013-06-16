// Extract of http://www.javacodegeeks.com/2013/06/singleton-design-pattern-a-lions-eye-view.html
//Java Code Geeks content is offered under Creative Commons Attribution-ShareAlike 3.0 Unported License.

/*Still we can not break the above approach of singleton using enum, but we can crack the above by writing a 
code to create more than one instance. The code is given below do not use the below code for your commercial
product. It is a nasty approach of breaking singleton. Let us see the code below.

However the above approach is just a technique to learn but not to implement anywhere. In this world every object
has a positive and a negative approach but we have to follow the positive approach for the smooth development of our
product or project.
*/

package singleton.example2.enumer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import sun.reflect.ConstructorAccessor;

public class CrackEnumSingleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set set = new HashSet();
		try 
		{
			Singleton2 firstInstance = Singleton2.INSTANCE;
			System.out.println(firstInstance.getClass() + " " + firstInstance + " = " + System.identityHashCode(firstInstance));
			set.add(firstInstance);

			Constructor constructor = Singleton2.class.getDeclaredConstructors()[0];
			Method acquire = constructor.getClass().getDeclaredMethod("acquireConstructorAccessor");//"acquireConstructorAccessor" fields for cracking
			acquire.setAccessible(true);
			acquire.invoke(constructor);

			Method get = constructor.getClass().getDeclaredMethod("getConstructorAccessor");//"getConstructorAccessor" fields for cracking
			get.setAccessible(true);
			ConstructorAccessor invoke = (ConstructorAccessor) get.invoke(constructor);
			Object secondInstance = invoke.newInstance(new Object[] {null,1});
			System.out.println(secondInstance.getClass() + " " + secondInstance + " = " + System.identityHashCode(secondInstance));
			set.add(secondInstance);

			System.out.println("Total No of Singletons :::"+set.size());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		

	}

}
