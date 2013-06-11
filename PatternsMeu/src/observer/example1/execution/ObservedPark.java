
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

package observer.example1.execution;

import observer.example1.strutcture.Child;
import observer.example1.strutcture.Maintence;
import observer.example1.strutcture.Park;

public class ObservedPark {

	public static void main(String[] args) {
		
		Park park = new Park();
		Child 
	    	childAna = new Child("Ana"), 
	    	childPeter = new Child("Peter");
		Maintence 
	    	maintenceA = new Maintence("work"), 
	    	maintenceB = new Maintence("surveillance");
				
		//adding the observers
		park.opening().addObserver(maintenceA.openObserver());
		park.opening().addObserver(maintenceB.openObserver());
		park.opening().addObserver(childAna.openObserver());
		park.opening().addObserver(childPeter.openObserver());
		park.closing().addObserver(maintenceA.closeObserver());
	    park.closing().addObserver(maintenceB.closeObserver());
	    park.closing().addObserver(childAna.closeObserver());
	    park.closing().addObserver(childPeter.closeObserver());
	    
	    // OperatorA stop work:
	    park.opening().deleteObserver(
	    		maintenceA.openObserver());
	    // A change that interests observers:
	    park.open();
	    park.open(); // It's already open, no change.
	    // Operator A go to work
	    park.closing().deleteObserver(
	    		maintenceA.closeObserver());
	    park.close();
	    park.close(); // It's already closed; no change
	    park.opening().deleteObservers();
	    park.open();
	    park.close();

	}

}
