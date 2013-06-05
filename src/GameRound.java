import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class GameRound 
{
	int roundShots;
	int roundBrains;
	Random r;

	final int DEFAULT_DICE = 3;
	final int DEFAULT_SHOTS = 3;
	private static Scanner scanner;
	Stack<Dice> diceCup; 
	Stack<Dice> usedDice;
	Stack<Dice> runDice ;
	
	public GameRound(Stack<Dice> diceCup, Random r)
	{
		this.r = r;
		scanner = new Scanner( System.in );
		this.diceCup = diceCup;
		usedDice = new Stack<Dice>();
		runDice = new Stack<Dice>();
	}
	
	public int oneRound()
	{
		boolean continueRolling = true;
		roundShots = 0;
		roundBrains = 0;
		shuffleDiceCup();
		
		while (continueRolling)
		{
			int nDiceToRoll = DEFAULT_DICE;
			if(nDiceToRoll > diceCup.size())
			{
				nDiceToRoll = diceCup.size();
			}
			
			rollDice(nDiceToRoll);
			displayRound();
			
			if(roundShots >= DEFAULT_SHOTS)
			{
				System.out.println("BLAM! YOU DED...");
				return 0;
			}
			else
			{
				continueRolling = askToContinue();
			}
			displayTotal();
		}
		
		//returns all dice to the diceCup
		while(runDice.elements().hasMoreElements())
		{
			diceCup.push(runDice.pop());
		}
		
		while(usedDice.elements().hasMoreElements())
		{
			diceCup.push(usedDice.pop());
		}
		
		return roundBrains;
	}
	
	
	private boolean askToContinue() 
	{
		System.out.println("Keep rolling? (Y for yes, N for no)");
		String continueRolling = scanner.nextLine();
		return continueRolling.toUpperCase().equals("Y");
	}

	private void displayTotal() 
	{
		System.out.println("Total Brains: " + roundBrains);
	}

	private void displayRound() 
	{
		System.out.println("Shots: " + roundShots);
		System.out.println("Brains: " + roundBrains);
		
	}

	private void rollDice(int nDiceToRoll) 
	{

		for(int i = 0; i< nDiceToRoll ; i++)
		{
			Dice result = diceCup.pop();
			
			String face = result.roll();
			
			displayResult(result, face);
			
			switch (face)
			{
				case "Run":
					runDice.push(result);
					break;
				case "Shot":
					roundShots++;
					usedDice.push(result);
					break;
				case "Brain":
					roundBrains++;
					usedDice.push(result);
					break;
				default:
					//error, error!!
					break;
			}
			

		}
		
		while(runDice.elements().hasMoreElements())
		{
			diceCup.push(runDice.pop());
		}
		
		
	}

	private void displayResult(Dice result, String face) 
	{
		System.out.println(result.diceType + " dice rolled a " + face);
	}
	
	public void shuffleDiceCup()
	{
		Stack<Dice> s1 = new Stack<Dice>();
		Stack<Dice> s2 = new Stack<Dice>();
		
		for(int i = 0; i<(r.nextInt(3) + 4) ; i++)
		{
			for(int j=0; j < diceCup.size()/2 ; j++)
			{
				s1.push(diceCup.pop());
			}
			
			while(!diceCup.isEmpty())
			{
				s2.push(diceCup.pop());
			}
			
			shuffleOnce(s1, s2);
		}
	}
	
	public void shuffleOnce(Stack<Dice> s1, Stack<Dice> s2)
	{
		boolean isEmpty = false;
		
		while(!isEmpty)
		{
			for(int i= 0; i<= (r.nextInt(2) + 1); i++)
			{
				diceCup.push(s1.pop());
				if (s1.isEmpty())
					break;
			}
			
			for(int i= 0; i<= (r.nextInt(2) + 1); i++)
			{
				diceCup.push(s2.pop());
				if (s2.isEmpty())
					break;
			}
			
			isEmpty = s1.isEmpty() || s2.isEmpty();
		}
		
		while(!s1.isEmpty())
		{
			diceCup.push(s1.pop());
		}
		
		while(!s2.isEmpty())
		{
			diceCup.push(s2.pop());
		}
		
	}
	
	



}
