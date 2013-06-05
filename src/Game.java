import java.util.Random;
import java.util.Stack;


public class Game 
{
	private Stack<Dice> diceCup;
	private Random r;
	
	public Game(Stack<Dice> diceCup)
	{
		this.diceCup = diceCup;
		r = new Random(System.currentTimeMillis());
	}
	
	public Game()
	{
		r = new Random(System.currentTimeMillis());
		diceCup = new Stack<Dice>();
		
		for(int i = 0; i < 6; i++)
		{
			diceCup.push(new Dice(2,3,1,"Green", r));
		}
		
		for(int i = 0; i < 4; i++)
		{
			diceCup.push(new Dice(r));
		}
		
		for(int i =0; i < 3; i++)
		{
			diceCup.push(new Dice(r));
		}
	}
	
	public Stack<Dice> getDiceCup()
	{
		return diceCup;
	}
	
	public Random getRandom()
	{
		return r;
	}

}
