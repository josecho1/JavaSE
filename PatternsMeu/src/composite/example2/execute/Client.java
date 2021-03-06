
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
package composite.example2.execute;

import composite.example2.structure.*;
/** Client */
public class Client
{
	public static void main(String[] args)
    {
		//Initialize
		Rama raiz = new Rama("root");
		//Composes
		raiz.agregar(new Hoja("hoja A"));
		raiz.agregar(new Hoja("hoja B"));
		
		Rama comp = new Rama("rama X");
		//Composes
		comp.agregar(new Hoja("hoja XA"));
		comp.agregar(new Hoja("hoja XB"));
		raiz.agregar(comp);
		raiz.agregar(new Hoja("hoja C"));
		
		Hoja l = new Hoja("hoja D");
		//Composes
		raiz.agregar(l);
		//Delete
		raiz.eliminar(l);
		//Print
		raiz.mostrar(1);
    }
}
