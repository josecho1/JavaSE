
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
package composite.example2.structure;

/** "Component" */
public abstract class Componente
{
        protected String nombre;
        public Componente (String nombre)
        {
                this.nombre = nombre;
        }
        //Adds the graphic to the composition.
        abstract public void agregar(Componente c);
        //Removes the graphic from the composition.
        abstract public void eliminar(Componente c);
        //Prints the graphic
        abstract public void mostrar(int profundidad);
}



