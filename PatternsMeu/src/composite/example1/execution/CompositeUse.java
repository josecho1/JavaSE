
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


package composite.example1.execution;

import composite.example1.structure.Leaf;
import composite.example1.structure.Node;


public class CompositeUse {

	public static void main(String[] args) {
		
		Node root = new Node("NodeRoot");
	    root.add(new Leaf("Leaf1"));
	    Node injert = new Node("NodePrimary");
	    injert.add(new Leaf("Leaf2"));
	    injert.add(new Leaf("Leaf3"));
	    //first 
	    root.add(injert);
	    injert = new Node("NodeSecundary");
	    injert.add(new Leaf("Leaf4"));
	    injert.add(new Leaf("Leaf5"));
	    //second
	    root.add(injert);
	    
	    root.operation();

	}

}
