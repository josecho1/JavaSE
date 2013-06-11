
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
package observer.example2.execution;

import observer.example2.structure.EventReadLine;
import observer.example2.structure.EventReadLineHandler;

public class RunEventReadLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Enter Text >");
		 
	        // create an event source - reads from stdin
	        final EventReadLine eventReadLine = new EventReadLine();
	 
	        // create an observer
	        final EventReadLineHandler responseHandler = new EventReadLineHandler();
	 
	        // subscribe the observer to the event source
	        eventReadLine.addObserver(responseHandler);
	 
	        // starts the event thread
	        Thread thread = new Thread(eventReadLine);
	        thread.start();

	}

}
