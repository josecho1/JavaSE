
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
package observer.example1.strutcture;

import java.util.Observable;
import java.util.Observer;



public class Maintence {

	private String name;
	private OpenObserver openObserver = 
			new OpenObserver();
	private CloseObserver closeObserver = 
			new CloseObserver();
	
	public Maintence(String name)  { this.name = name; }
	
	/**
	 * A class can implement the <code>Observer</code> interface when it
	 * wants to be informed of changes in observable objects.
	*/
	// An inner class for observing openings:
	private class OpenObserver implements Observer{
		public void update(Observable ob, Object a) {
			System.out.println("Maintence " + name + " time!");
		}
	}
	
	/**
	 * A class can implement the <code>Observer</code> interface when it
	 * wants to be informed of changes in observable objects.
	*/
	// Another inner class for closings:
	private class CloseObserver implements Observer{
		public void update(Observable ob, Object a) {
			System.out.println("Maintence not " + name 
					+ " time, it's work time!");
		}
	}
	
	public Observer openObserver() { 
		return openObserver; 
	}
	public Observer closeObserver() { 
		return closeObserver;
	}


}
