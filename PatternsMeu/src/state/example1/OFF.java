package state.example1;

public class OFF extends State {

	private static OFF inst = new OFF();
	
	private OFF() { }

	public static State instance() { return inst; }
	
	public void push( Button b ) {
		b.setCurrent( ON.instance() );
		System.out.println( "   turning ON" ); 
	}

}
