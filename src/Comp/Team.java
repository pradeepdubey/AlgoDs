   package Comp;

import java.util.*;

public class Team {
    private int points;
    private String name;

    public Team(String n)
    {
        name = n;
    }

    public int getPoints()
    {
        return points;
    }

    public void addPoints(boolean win)
    {
           if (win==true)
           {
        	   points = points + 3;
           }

           else if (win==false)
           {
        	   points = points + 1;
           }

           
}
    static void printTeam(List<Team> team) {
    	Iterator<Team> TeamIterator = ((List<Team>) team).iterator();
		while (TeamIterator.hasNext()) {
			Team curr = TeamIterator.next();
			System.out.println(curr.name + "  "+ curr.points);
		}
    }
//...
    public static void main(String args[]) {
    	List<Team> lteams = new ArrayList<Team>();

    	 lteams.add(new Team("FC Barcelona"));
    	 lteams.add(new Team("Arsenal FC"));
    	 lteams.add(new Team("Chelsea"));
    	 lteams.add(new Team("ManUnited"));

    	 //then adding 3 points to Chelsea and 1 point to Arsenal
    	 lteams.get(0).addPoints(true);
    	 lteams.get(0).addPoints(true);
    	 lteams.get(0).addPoints(true);
    	 lteams.get(2).addPoints(true);
    	 lteams.get(1).addPoints(false);
    	 
    	 printTeam(lteams);
    	 Collections.sort(lteams, new Comparator<Team>() {
    	          public int compare(Team p1, Team p2) {
    	            return p1.points- p2.points;
    	        }
    	 });
    	 
    	 printTeam(lteams);
    	 }
} 

