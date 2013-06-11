package composite.example2.structure;

import java.util.ArrayList;


/** "Composite" */
public class Rama extends Componente
{
        //Collection of child Componente
		private ArrayList<Componente> hijo = new ArrayList<Componente>();
        public Rama (String name)
        {
                super(name);
        }
        
        //Adds the graphic to the composition.
        @Override
        public void agregar(Componente componente)
        {
                hijo.add(componente);
        }
        
        //Removes the graphic from the composition.
        @Override
        public void eliminar(Componente componente)
        {
                hijo.remove(componente);
        }
        
        //Prints the graphic
        @Override
        public void mostrar(int profundidad)
        {
                System.out.println(nombre + " nivel: " + profundidad);
                for (int i = 0; i < hijo.size(); i++)
                        hijo.get(i).mostrar(profundidad + 1);
        }
}