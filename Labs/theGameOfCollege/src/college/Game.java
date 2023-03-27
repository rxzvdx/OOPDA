package college;
import java.util.HashMap;
import java.util.function.Consumer;

public class Game {
	
	public static final int NUMBER_OF_CLUBS = 0;
	public static final int NUMBER_OF_FRIENDS = 1;
	public static final int MONEY = 225;
	public static final int HAPPINESS = 20;
	public static final double GPA = 3.0;
	public static final int LAST_SQUARE = 26;
	
	public static HashMap<Integer, String> squareText = new HashMap<Integer, String>();
	static {
		squareText.put(1, "Fall asleep in class.");
		squareText.put(2, "Roommate comforts you.");
		squareText.put(3, "Roommate needs a loan.");
		squareText.put(4, "Skip class to travel to New York.");
		squareText.put(5, "Pull an all nighter.");
		squareText.put(6, "Move ahead two spaces.");
		squareText.put(7, "Join a club.");
		squareText.put(8, "Help classmate study.");
		squareText.put(9, "Kick ass on midterms.");
		squareText.put(10, "Throw major party.");
		squareText.put(11, "Get caught buying paper from web.");
		squareText.put(12, "Roommate pays you back - with interest!");
		squareText.put(13, "Lose a friend.");
		squareText.put(14, "Join a club.");
		squareText.put(15, "Turn research entrepeneurial.");
		squareText.put(16, "Fail DSA");
		squareText.put(17, "Dean discovers your illegal party.");
		squareText.put(18, "Win eSports tournament.");
		squareText.put(19, "Join Honors Club.");
		squareText.put(20, "Gain 2 friends.");
		squareText.put(21, "Robbed!");
		squareText.put(22, "Study hard for Calculus III.");
		squareText.put(23, "Senioritis!");
		squareText.put(24, "Borry money from friend; forget to repay.");
		squareText.put(25, "Get graduation gift from Aunt June.");
		squareText.put(26, "GRADUATED!");
	}
	
	static Consumer<Player> fallAsleep = 
			player -> {player.setGpa(player.getGpa()*.9);};
	static Consumer<Player> roommateComforts = 
			player -> {player.setHappiness(player.getHappiness()+5);};
	static Consumer<Player> giveLoan = 
			player -> {player.setMoney(player.getMoney()-200);};
	static Consumer<Player> skipClass = 
			player -> {player.setHappiness(player.getHappiness()+10);player.setGpa(player.getGpa()*.2);};
	static Consumer<Player> pullAllNighter = 
			player -> {player.setHappiness(player.getHappiness()-3);player.setGpa(player.getGpa()+.1);};
	static Consumer<Player> moveTwoSpaces = 
			player -> {player.setLocation(player.getLocation()+2);};
	static Consumer<Player> joinClub = 
			player -> {player.setNumberOfClubs(player.getNumberOfClubs()+1);};
	static Consumer<Player> kickAssOnMidterm = 
			player -> {player.setGpa(player.getGpa()+.2);};
	static Consumer<Player> throwMajorParty = 
			player -> {player.setNumberOfFriends(player.getNumberOfFriends()+2);player.setMoney(player.getMoney()-100);};
	static Consumer<Player> getCaughtBuyingPaper = 
			player -> {player.setMoney(player.getMoney()-100);player.setGpa(player.getGpa()*.5);};
	static Consumer<Player> roommatePaysYouBack = 
			player -> {player.setMoney(player.getMoney()+220);};
	static Consumer<Player> loseAFriend = 
			player -> {player.setNumberOfFriends(player.getNumberOfFriends()-1);};
	static Consumer<Player> helpClassmateStudy = 
			player -> {player.setNumberOfFriends(player.getNumberOfFriends()+1);};
	static Consumer<Player> joinSecondClub = 
			player -> {player.setNumberOfClubs(player.getNumberOfClubs()+1);};
	static Consumer<Player> turnResearch = 
			player -> {player.setGpa(player.getGpa()+.8);player.setMoney(player.getMoney()+2000);};
	static Consumer<Player> failDSA = 
			player -> {player.setLocation(player.getLocation()-3);player.setGpa(player.getGpa()*.5);};
	static Consumer<Player> deanDiscovers = 
			player -> {player.setHappiness(player.getHappiness()-12);};
	static Consumer<Player> winEsportsTourney = 
			player -> {player.setHappiness(player.getHappiness()+10);player.setMoney(player.getMoney()+1000);};
	static Consumer<Player> joinThirdClub = 
			player -> {player.setNumberOfClubs(player.getNumberOfClubs()+1);};
	static Consumer<Player> gainTwoFriends = 
			player -> {player.setNumberOfFriends(player.getNumberOfFriends()+2);};
	static Consumer<Player> getRobbed = 
			player -> {player.setMoney(player.getMoney()-300);};
	static Consumer<Player> studyForCalcIII = 
			player -> {player.setHappiness(player.getHappiness()-7);player.setGpa(player.getGpa()+.3);};
	static Consumer<Player> getSenioritis = 
			player -> {player.setGpa(player.getGpa()*.2);player.setMoney(player.getMoney()-400);};
	static Consumer<Player> borrowMoney = 
			player -> {player.setMoney(player.getMoney()+150);player.setNumberOfFriends(player.getNumberOfFriends()-1);};
	static Consumer<Player> getGradGift = 
			player -> {player.setMoney(player.getMoney()+150);player.setHappiness(player.getHappiness()+15);};


	public static HashMap<Integer, Consumer<Player>> squareEvents = new HashMap<Integer, Consumer<Player>>();
	static {
		squareEvents.put(1, fallAsleep);
		squareEvents.put(2, roommateComforts);
		squareEvents.put(3, giveLoan);
		squareEvents.put(4, skipClass);
		squareEvents.put(5, pullAllNighter);
		squareEvents.put(6, moveTwoSpaces);
		squareEvents.put(7, joinClub);
		squareEvents.put(8, kickAssOnMidterm);
		squareEvents.put(9, throwMajorParty);
		squareEvents.put(10, getCaughtBuyingPaper);
		squareEvents.put(11, roommatePaysYouBack);
		squareEvents.put(12, loseAFriend);
		squareEvents.put(13, helpClassmateStudy);
		squareEvents.put(14, joinSecondClub);
		squareEvents.put(15, turnResearch);
		squareEvents.put(16, failDSA);
		squareEvents.put(17, deanDiscovers);
		squareEvents.put(18, winEsportsTourney);
		squareEvents.put(19, joinThirdClub);
		squareEvents.put(20, gainTwoFriends);
		squareEvents.put(21, getRobbed);
		squareEvents.put(22, studyForCalcIII);
		squareEvents.put(23, getSenioritis);
		squareEvents.put(24, borrowMoney);
		squareEvents.put(25, getGradGift);
	}
	
	public static int roll() {
	   return (int)(Math.random()*6+1);
	}

}
