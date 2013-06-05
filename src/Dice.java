import java.util.ArrayList;
import java.util.Random;


public class Dice 
{
	ArrayList<String> sides;
	Random r;
	String diceType;
	
	public Dice(ArrayList<String> sides, String diceType, Random r)
	{
		this.sides = sides;
		this.diceType = diceType;
		this.r = r;
	}
	
	public Dice(int runSides, int brainSides, int shotSides, String diceType, Random r)
	{
		this.r = r;
		ArrayList<String> sides = new ArrayList<>(runSides + brainSides + shotSides);
		
		for(int i = 0; i< runSides; i++)
		{
			sides.add("Run");
		}
		
		for(int i = 0; i< brainSides; i++)
		{
			sides.add("Brain");
		}
		
		for(int i = 0; i< shotSides; i++)
		{
			sides.add("Shot");
		}
		
		this.sides = sides;
		this.diceType = diceType;
	}
	
	public Dice(Random r)
	{
		this(2, 2, 2, "Yellow", r);
	}
	
	public Dice(String string, Random r) {
		this(2,2,2, string, r);
	}

	public String roll()
	{
		int roll = r.nextInt(sides.size());
		
		System.out.println("Side: " + roll);
		return sides.get(roll);
	}
	
	public String getDiceType()
	{
		return diceType;
	}

}
