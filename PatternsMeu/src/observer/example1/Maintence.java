package observer.example1;

import java.util.Observable;
import java.util.Observer;



public class Maintence {

	private String name;
	private OpenObserver openObserver = 
			new OpenObserver();
	private CloseObserver closeObserver = 
			new CloseObserver();
	
	public Maintence(String name)  { this.name = name; }
	
	/**
	 * A class can implement the <code>Observer</code> interface when it
	 * wants to be informed of changes in observable objects.
	*/
	// An inner class for observing openings:
	private class OpenObserver implements Observer{
		public void update(Observable ob, Object a) {
			System.out.println("Maintence " + name + " time!");
		}
	}
	
	/**
	 * A class can implement the <code>Observer</code> interface when it
	 * wants to be informed of changes in observable objects.
	*/
	// Another inner class for closings:
	private class CloseObserver implements Observer{
		public void update(Observable ob, Object a) {
			System.out.println("Maintence not " + name 
					+ " time, it's work time!");
		}
	}
	
	public Observer openObserver() { 
		return openObserver; 
	}
	public Observer closeObserver() { 
		return closeObserver;
	}


}
