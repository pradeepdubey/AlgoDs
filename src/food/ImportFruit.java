package food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ExpSort implements Comparator<ImportFruit> {

	@Override
	public int compare(ImportFruit arg0, ImportFruit arg1) {
		// TODO Auto-generated method stub
		return arg0.exporter.compareToIgnoreCase(arg1.exporter);
		
	}
	
}
public class ImportFruit extends Fruit implements Comparable<ImportFruit>{
	String origin;
	String exporter;
	ImportFruit() {}
	ImportFruit(String name,String season,int rate,String origin,String exporter) {
		this.name=name;
		this.season=season;
		this.rate=rate;
		
		if(origin != null) {
			this.origin=origin;
		}
		if(exporter != null) {
			this.exporter=exporter;
		}
	}
	ImportFruit(String name,String season,int rate) {
		this.name=name;
		this.season=season;
		this.rate=rate;
		
	}
	
	public static void main (String args[]) {
		ArrayList<ImportFruit> list = new ArrayList<ImportFruit>();
		ImportFruit a = new ImportFruit("Apple","Winter",25,"canada","Uk");
		ImportFruit b = new ImportFruit("PineApple","Summer",15,"brazil","egypt");
		ImportFruit c = new ImportFruit("Orange","Rainy",35,"india","china");
		ImportFruit d = new ImportFruit("Strawberry","Snow",50,"norway","belgium");
		ImportFruit e = new ImportFruit("Grapes","Fall",75,"russia","Italy");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		
		Collections.sort(list);
		
		printArray(list);
		
		Collections.sort(list,new ExpSort());
		
		printArray(list);

		/*a.print();
		 * 
		b.print();
		c.print();
		d.print();
		e.print();
		((ImportFruit) c).printAll();
		d.printAll();
		e.printAll();*/
	}
	void print() {
		System.out.println("Fruits Description from Child");
		System.out.println("Fruit: "+name+ ",Season: "+season+",Price: "+ rate+ "\n");
	}
	void printAll() {
		System.out.println("Fruits Description from Child");
		System.out.println("Fruit: "+name+ ",Season: "+season+",Price: "+ rate+ ",Origin: "+ origin+",Exporter:" + exporter + "\n");
	}
	static void printArray(ArrayList<ImportFruit> f) {
		System.out.println("Fruits Description from ArrayList");
		for (ImportFruit fruit:f) {
			System.out.println("Fruit: "+fruit.name + ",Season: "+fruit.season+",Price: "+ fruit.rate+
					",Origin: "+ fruit.origin+",Exporter:" + fruit.exporter + "\n");
		}
		
		
	}
	void eat(Fruit f) {
		// TODO Auto-generated method stub
		f.rate = f.rate-1;
		
	
	}
	@Override
	public int compareTo(ImportFruit arg0) {
		//return this.name.compareToIgnoreCase(arg0.name);
		return -(this.rate - arg0.rate);
	}
	
}
