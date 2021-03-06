// Extract of http://www.javacodegeeks.com/2013/06/singleton-design-pattern-a-lions-eye-view.html
//Java Code Geeks content is offered under Creative Commons Attribution-ShareAlike 3.0 Unported License.

package singleton.example3.serializable;

import java.io.Serializable;

public class BreakSingleton3 implements Serializable{

	private static final long serialVersionUID = 5904306999023481976L;

	private Singleton3 instance2 = Singleton3.getInstance();

	public Singleton3 getInstance2() {
		return instance2;
	}

	public void setInstance1(Singleton3 instance2) {
		this.instance2 = instance2;
	}

}
