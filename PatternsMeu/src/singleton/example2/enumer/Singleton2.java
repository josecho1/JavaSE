
package singleton.example2.enumer;

// Joshua Bloch
/*This is the only robust approach of creating a singleton class which is serializable and completely
thread-safe as enums by default thread-safe. What about reflection, using our above normal approach 
of reflection, you can not break singleton object as it has no constructor. What about serialization,
you will be able to serialize it but you will get the same instance every time. So finally we have to imbibe
this modern approach of creation of Singleton design class. However many developers do not know about it.
*/
public enum Singleton2 {
	
	INSTANCE;
	
	public void sayHello()
	 {
	    System.out.println("Hello World");
	 }

	 public void sayBye()
	 {
	   System.out.println("Bye Bye");
	 }
	 
}
