package singleton.example4;

// The solution of Bill Pugh
// http://en.wikipedia.org/wiki/Singleton_pattern#The_solution_of_Bill_Pugh

public class Singleton4 
{
        // Private constructor prevents instantiation from other classes
		private Singleton4() { }
       
        /**
        * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
        * or the first access to SingletonHolder.INSTANCE, not before.
        */
        private static class SingletonHolder { 
                public static final Singleton4 INSTANCE = new Singleton4();
        }

        public static Singleton4 getInstance() {
                return SingletonHolder.INSTANCE;
        }
      
}
