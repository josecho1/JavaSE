package state.example1;

public class State {

	//Default behavior can go in the base class
	public void push( Button b )  {              
	      b.setCurrent( OFF.instance() );
	      System.out.println( "   turning OFF" );
	  }

}
