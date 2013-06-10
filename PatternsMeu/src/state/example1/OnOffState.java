package state.example1;

import java.io.IOException;
import java.io.InputStreamReader;

public class OnOffState {

	public static void main( String[] args ) throws IOException {
	      InputStreamReader is = new InputStreamReader( System.in );
	      int ch;
	      Button btn = new Button();
	      while (true) {
	         System.out.print( "Press 'Enter'" );
	         ch = is.read();
	         btn.push();
	      }
	   }

}
