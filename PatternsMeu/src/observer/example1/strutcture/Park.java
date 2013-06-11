
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
package observer.example1.strutcture;

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
