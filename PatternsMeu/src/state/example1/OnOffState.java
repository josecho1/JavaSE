
/*DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2013 José Luis Villaverde Balsa.

This file is part of PatternsMeu.

    PatternsMeu is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PatternsMeu is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/
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
