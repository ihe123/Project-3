import java.util.Random;

public class RPSGame {
	private int numOfUserWins;
	private int numOfComputerWins;
	private int numOfTies;
	
	
	public enum Moves{ ROCK, PAPER, SCISSORS};
	public enum Outcomes{COMPUTER_WIN, USER_WIN, TIE};
	
	public int getNumOfUserWins() {
		return numOfUserWins;
	}
	
	public int getNumOfComputerWins() {
		return numOfComputerWins;
	}
	
	public int getNumOfTies() {
		return numOfTies;
	}
	
	
	/*public void setNumOfUserWins(int newNumOfUserWins) {
		numOfUserWins = newNumOfUserWins;
	}
	
	public void setNumOfComputerWins(int newNumOfComputerWins) {
		numOfComputerWins = newNumOfComputerWins;
	}
	
	public void setNumOfTies(int newNumOfTies) {
		numOfTies = newNumOfTies;
	}*/
	
	public Moves computerPlay() {
		Random random = new Random();
		int numOfMove = random.nextInt(3);
		return Moves.values()[numOfMove];
	}
	
	public Outcomes findWinner(Moves userMove, Moves computerMove) {
		if (userMove == computerMove) {
			numOfTies++;
			return Outcomes.TIE;
			
		} else if (userMove != computerMove) {
			if (userMove == Moves.ROCK) {
				if (computerMove == Moves.PAPER) {
					numOfComputerWins++;
					return Outcomes.COMPUTER_WIN;
				}
				else if (computerMove == Moves.SCISSORS) {
					numOfUserWins++;
					return Outcomes.USER_WIN;
				}
			}
			if (userMove == Moves.PAPER) {
				if (computerMove == Moves.ROCK) {
					numOfUserWins++;
					return Outcomes.USER_WIN;
				}
				else if (computerMove == Moves.SCISSORS) {
					numOfComputerWins++;
					return Outcomes.COMPUTER_WIN;
				}
			}
			
			if (userMove == Moves.SCISSORS) {
				if (computerMove == Moves.ROCK) {
					numOfComputerWins++;
					return Outcomes.COMPUTER_WIN;
				}
				else if (computerMove == Moves.PAPER) {
					numOfUserWins++;
					return Outcomes.USER_WIN;
				}
			}
		}
		return Outcomes.TIE; // should never get here but added this here because compiler was complaining
	}
	
	
	
	
	

	public static void main(String[] args) {
		RPSGame rp = new RPSGame();
		Moves move = rp.computerPlay();
		System.out.println(move);
		System.out.println(rp.findWinner(Moves.SCISSORS, move));

	}

}
