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
