package singleton.example2;


public class Singleton2 
{
        // Private constructor prevents instantiation from other classes
		private Singleton2() { }
       
        /**
        * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
        * or the first access to SingletonHolder.INSTANCE, not before.
        */
        private static class SingletonHolder { 
                public static final Singleton2 INSTANCE = new Singleton2();
        }

        public static Singleton2 getInstance() {
                return SingletonHolder.INSTANCE;
        }
      
}
