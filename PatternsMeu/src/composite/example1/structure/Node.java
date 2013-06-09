package composite.example1.structure;


import java.util.ArrayList;
import java.util.Iterator;


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
