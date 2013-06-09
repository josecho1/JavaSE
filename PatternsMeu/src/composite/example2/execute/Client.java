
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

import java.util.*;

import composite.example2.structure.Componente;


class Rama extends Componente
{
        private ArrayList<Componente> hijo = new ArrayList<Componente>();
        public Rama (String name)
        {
                super(name);
        }
        @Override
        public void agregar(Componente componente)
        {
                hijo.add(componente);
        }
        @Override
        public void eliminar(Componente componente)
        {
                hijo.remove(componente);
        }
        @Override
        public void mostrar(int profundidad)
        {
                System.out.println(nombre + " nivel: " + profundidad);
                for (int i = 0; i < hijo.size(); i++)
                        hijo.get(i).mostrar(profundidad + 1);
        }
}
class Hoja extends Componente
{
        public Hoja (String nombre)
        {
                super(nombre);
        }
        public void agregar(Componente c)
        {
                System.out.println("no se puede agregar la hoja");
        }
        public void eliminar(Componente c)
        {
                System.out.println("no se puede quitar la hoja");
        }
        public void mostrar(int depth)
        {
                System.out.println('-' + "" + nombre);
        }
}
public class Client
{
        public static void main(String[] args)
        {
                Rama raiz = new Rama("root");
                raiz.agregar(new Hoja("hoja A"));
                raiz.agregar(new Hoja("hoja B"));
                Rama comp = new Rama("rama X");
                comp.agregar(new Hoja("hoja XA"));
                comp.agregar(new Hoja("hoja XB"));
                raiz.agregar(comp);
                raiz.agregar(new Hoja("hoja C"));
                Hoja l = new Hoja("hoja D");
                raiz.agregar(l);
                raiz.eliminar(l);
                raiz.mostrar(1);
        }
}
