package observer.example1;

import java.util.Observable;



public class Park {

	private boolean isOpen;
	
	//is a Observable
	private OpenNotifier openNotify = 
			new OpenNotifier();
	
	//is a Observable
	private CloseNotifier closeNotify = 
			new CloseNotifier();
	
	
	public Park(){
		isOpen=false;
	}
	
	public void open() { // Opens its doors
		isOpen = true;
		openNotify.notifyObservers();
		closeNotify.open();
	}

	public void close() { // Closes its doors
		isOpen = false;
		closeNotify.notifyObservers();
		openNotify.close();
	}
	
	public Observable opening() { return openNotify; }
	public Observable closing() { return closeNotify; }
	
	//inner Class
	private class OpenNotifier extends Observable {
		private boolean alreadyOpen = false;
		public void notifyObservers() {
			if(isOpen && !alreadyOpen) {
				//changed = true;
				setChanged();
				//then notify all of its observers and changed = false;
				super.notifyObservers();
				alreadyOpen = true;
			}
		}
		public void close() { alreadyOpen = false; }
	}
	
	//inner Class
	private class CloseNotifier extends Observable{
		private boolean alreadyClosed = false;
		public void notifyObservers() {
			if(!isOpen && !alreadyClosed) {
				//changed = true;
				setChanged();
				//then notify all of its observers and changed = false;
				super.notifyObservers();
				alreadyClosed = true;
			}
		}
		public void open() { alreadyClosed = false; }
	}
}
