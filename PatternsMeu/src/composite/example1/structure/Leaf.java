package composite.example1.structure;


public class Leaf implements Component {
	
	 private String name;
	 public Leaf(String name) { this.name = name; }
	 public String toString() { return name; }
	 @Override
	 public void operation() {
	    System.out.println(this);
	  }
	
}
