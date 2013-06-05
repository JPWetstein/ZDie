import java.util.Random;
import java.util.Stack;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Game game = new Game();
		GameRound g = new GameRound(game.getDiceCup(), game.getRandom());
		g.oneRound();

	}

}
