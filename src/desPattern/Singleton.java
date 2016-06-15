package desPattern;

import java.util.ArrayList;
import java.util.Collection;

public class Singleton {
	private static Singleton firstInstance  = null;
	private Singleton() {
		doit();
		
	}

	private void doit() {
		// TODO Auto-generated method stub
		
	}

	public static Singleton getInstance(){
		if(firstInstance == null) {
			firstInstance = new Singleton();
		}
		final Collection<? extends Number> foo = new ArrayList<Number>();
	//	foo.add(new Integer(4));
		//foo.add(new Object());
		foo.add(null);
		//foo=null;
		
		return firstInstance;
	}
}
