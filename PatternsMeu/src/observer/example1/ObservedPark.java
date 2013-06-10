package observer.example1;

public class ObservedPark {

	public static void main(String[] args) {
		
		Park park = new Park();
		Child 
	    	childAna = new Child("Ana"), 
	    	childPeter = new Child("Peter");
		Maintence 
	    	maintenceA = new Maintence("work"), 
	    	maintenceB = new Maintence("surveillance");
				
		//adding the observers
		park.opening().addObserver(maintenceA.openObserver());
		park.opening().addObserver(maintenceB.openObserver());
		park.opening().addObserver(childAna.openObserver());
		park.opening().addObserver(childPeter.openObserver());
		park.closing().addObserver(maintenceA.closeObserver());
	    park.closing().addObserver(maintenceB.closeObserver());
	    park.closing().addObserver(childAna.closeObserver());
	    park.closing().addObserver(childPeter.closeObserver());
	    
	    // OperatorA stop work:
	    park.opening().deleteObserver(
	    		maintenceA.openObserver());
	    // A change that interests observers:
	    park.open();
	    park.open(); // It's already open, no change.
	    // Operator A go to work
	    park.closing().deleteObserver(
	    		maintenceA.closeObserver());
	    park.close();
	    park.close(); // It's already closed; no change
	    park.opening().deleteObservers();
	    park.open();
	    park.close();

	}

}
