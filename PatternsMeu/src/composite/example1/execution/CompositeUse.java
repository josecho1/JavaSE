
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node root = new Node("root");
	    root.add(new Leaf("Leaf1"));
	    Node c2 = new Node("Node1");
	    c2.add(new Leaf("Leaf2"));
	    c2.add(new Leaf("Leaf3"));
	    root.add(c2);
	    c2 = new Node("Node2");
	    c2.add(new Leaf("Leaf4"));
	    c2.add(new Leaf("Leaf5"));
	    root.add(c2);
	    root.operation();

	}

}
