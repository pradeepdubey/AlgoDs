package vendingMachine;

import java.util.*;

public class VendingMachine {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		int SNICKERS = 55;
	    int MILKYWAY = 65;
	    int KITKAT = 50;
	    int ALMONDJOY = 45;
	    int orginalAmount, quarters, dimes, nickels, pennies;
	    int choice = 0;
	    int money = 0;
	    int amount = 0;
	     
	    System.out.println("VENDING MACHINE");
	    System.out.println("Candy Bar 55 cents Press 1");
	    System.out.println("Drink 65 cents Press 2");
	    System.out.println("Peanuts 50 cents Press 3");
	    System.out.println("Chips 45 cents Press 4");
	     
	    System.out.println("Please enter your selection.");
	    Scanner input = new Scanner(System.in);
	    choice = input.nextInt();
	     
	    {
	       System.out.println("Please enter your amount in cents");
	        
	        money = input.nextInt();
	         
	        if (money < 25)
	            System.out.println("You must enter an amount over 25 cents.");
	        if (money >100)
	            System.out.println("You must enter an amount less than 100.");
	        if ((money < 25) || (money > 100))
	            System.exit(0);
	         
	    }
	    switch(choice)
	         
	    {
	        case 1:
	             
	            System.out.println("You entered: " +money);
	            System.out.println("You chose SNICKERS - .55");
	            amount = money - SNICKERS;
	             
	            System.out.println("Your change is: " + amount + "cents");
	            System.out.println(amount + " cents in coins can be given as: ");
	             
	            quarters = amount/25;
	            amount = amount % 25;
	            dimes = amount/10;
	            amount = amount % 10;
	            nickels = amount/5;
	            amount = amount % 5;
	            pennies = amount;
	             
	            System.out.println(quarters + " quarter(s)");
	            System.out.println(dimes + " dime(s)");
	            System.out.println(nickels + " nickel(s) and");
	            System.out.println(pennies + " pennies");
	            System.out.println("Thank you! Enjoy your purchase!");
	             
	            break;
	             
	        case 2:
	             
	            System.out.println("You entered: " +money);
	            System.out.println("You chose a MILKYWAY -.65");
	            amount = money - MILKYWAY;
	            System.out.println("Your change is: " + amount + " cents");
	            System.out.println(amount + " cents in coins can be given as: ");
	             
	            quarters = amount/25;
	            amount = amount % 25;
	            dimes = amount/10;
	            amount = amount % 10;
	            nickels = amount/5;
	            amount = amount % 5;
	            pennies = amount;
	             
	            System.out.println(quarters + " quarter(s)");
	            System.out.println(dimes + " dime(s)");
	            System.out.println(nickels + " nickel(s) and");
	            System.out.println(pennies + " pennies");
	            System.out.println("Thank you! Enjoy your purchase!");
	             
	            break;
	             
	        case 3:
	             
	            System.out.println("You entered: " +money);
	            System.out.println("You chose KITKAT -.50");
	            amount = money - KITKAT;
	            System.out.println("Your change is: " + amount + " cents");
	            System.out.println(amount + " cents in coins can be given as: ");
	             
	            quarters = amount/25;
	            amount = amount % 25;
	            dimes = amount/10;
	            amount = amount % 10;
	            nickels = amount/5;
	            amount = amount % 5;
	            pennies = amount;
	             
	            System.out.println(quarters + " quarter(s)");
	            System.out.println(dimes + " dime(s)");
	            System.out.println(nickels + " nickel(s) and");
	            System.out.println(pennies + " pennies");
	            System.out.println("Thank you! Enjoy your purchase!");
	             
	            break;
	             
	        case 4:
	             
	            System.out.println("You entered: " +money);
	            System.out.println("You chose ALMONDJOY - .45");
	            amount = money - ALMONDJOY;
	            System.out.println("Your change is: " + amount + " cents");
	            System.out.println(amount + " cents in coins can be given as: ");
	             
	            quarters = amount/25;
	            amount = amount % 25;
	            dimes = amount/10;
	            amount = amount % 10;
	            nickels = amount/5;
	            amount = amount % 5;
	            pennies = amount;
	             
	            System.out.println(quarters + " quarter(s)");
	            System.out.println(dimes + " dime(s)");
	            System.out.println(nickels + " nickel(s) and");
	            System.out.println(pennies + " pennies");
	            System.out.println("Thank you! Enjoy your purchase!");
	             
	            break;
	             
	        default:
	             
	            System.out.println("You must enter a selection between 1 and 4. Thank you!");

	}

}

}
