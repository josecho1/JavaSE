
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
package composite.example1.structure;


import java.util.ArrayList;
import java.util.Iterator;

/** 
     @autor: Jose Luis Villaverde
*/
public class Node extends ArrayList<Component> implements Component {

	private static final long serialVersionUID = 1L;
	private String name;
	public Node(String name) { this.name = name; }
	public String toString() { return name; }
	@Override
	public void operation() {
		System.out.println(this);
	    for(Iterator<Component> it = iterator(); it.hasNext(); )
	      ((Component)it.next()).operation();
	  }
}
