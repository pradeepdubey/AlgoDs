package food;

public class Fruit {
	String name;
	protected String season;
	int rate;
	Fruit(){}
	Fruit(String name,String season,int rate) {
		this.name=name;
		this.season=season;
		this.rate=rate;
		
	}
	void print() {
		System.out.println("Fruits Description from Super");
		System.out.println("Fruit: "+name+ ",Season: "+season+",Price: "+ rate+ "\n");
	}
 
}
