package observer.example1;

import java.util.Observable;
import java.util.Observer;

public class Child {

	private String name;
	private OpenObserver openObserver = 
			new OpenObserver();
	private CloseObserver closeObserver = 
			new CloseObserver();
	
	public Child(String name)  { this.name = name; }
	
	/**
	 * A class can implement the <code>Observer</code> interface when it
	 * wants to be informed of changes in observable objects.
	*/
	// An inner class for observing openings:
	private class OpenObserver implements Observer{
		public void update(Observable ob, Object a) {
			System.out.println("Child " + name 
					+ "'s play time!");
		}
	}
	
	/**
	 * A class can implement the <code>Observer</code> interface when it
	 * wants to be informed of changes in observable objects.
	*/
	// Another inner class for closings:
	private class CloseObserver implements Observer{
		public void update(Observable ob, Object a) {
			System.out.println("Child " + name 
					+ "'s not play time!");
		}
	}
	
	public Observer openObserver() { 
		return openObserver; 
	}
	public Observer closeObserver() { 
		return closeObserver;
	}

}
