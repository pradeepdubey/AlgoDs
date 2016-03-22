package food;

import java.util.ArrayList;
import java.util.Collections;

public class ExportFruit extends Fruit implements Comparable<ExportFruit>{
	String origin;
	String exporter;
	ExportFruit() {}
	ExportFruit(String name,String season,int rate,String origin,String exporter) {
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
	ExportFruit(String name,String season,int rate) {
		this.name=name;
		this.season=season;
		this.rate=rate;
		
	}
	
	public static void main (String args[]) {
		ArrayList<ExportFruit> list = new ArrayList<ExportFruit>();
		ExportFruit a = new ExportFruit("Apple","Winter",25,"canada","Uk");
		ExportFruit b = new ExportFruit("PineApple","Summer",15,"brazil","egypt");
		ExportFruit c = new ExportFruit("Orange","Rainy",35,"india","china");
		ExportFruit d = new ExportFruit("Strawberry","Snow",50,"norway","belgium");
		ExportFruit e = new ExportFruit("Grapes","Fall",75,"russia","Italy");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		
		Collections.sort(list);
		
		printArray(list);
		/*a.print();
		b.print();
		c.print();
		d.print();
		e.print();
		((ExportFruit) c).printAll();
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
	static void printArray(ArrayList<ExportFruit> f) {
		System.out.println("Fruits Description from ArrayList");
		for (ExportFruit fruit:f) {
			System.out.println("Fruit: "+fruit.name + ",Season: "+fruit.season+",Price: "+ fruit.rate+
					",Origin: "+ fruit.origin+",Exporter:" + fruit.exporter + "\n");
		}
		
		
	}
	void eat(Fruit f) {
		// TODO Auto-generated method stub
		f.rate = f.rate-1;
		
	
	}
	@Override
	public int compareTo(ExportFruit arg0) {
		//return this.name.compareToIgnoreCase(arg0.name);
		return -(this.rate - arg0.rate);
	}
	
}
