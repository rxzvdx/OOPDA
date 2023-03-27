package college;

import java.util.Scanner;
import java.util.function.Consumer;

public class CollegeDriver {

	private static Player player = new Player("Chris");
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)  {
		
		System.out.println("Type T to test, or any other character to play.");
		String answer = sc.nextLine();
		try {
			if (answer.toUpperCase().equals("T")) test();
			else play();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void test() throws InterruptedException {
		while (player.getLocation() < Game.LAST_SQUARE) {
			player.move(1);
			if (player.getLocation() == 16 || player.getLocation() == 6) {
				// These squares move a player, but don't actually move the test player
				// Instead show the effect on a dummy player
				Player dummy = new Player("dummy");
				System.out.println(dummy);
				// TODO IF you want to test the change location squares,
				//      you will have to invoke the action for the player's square on a dummy player
				System.out.println(dummy);
			}
			else {
				if (player.getLocation() < Game.LAST_SQUARE) {
					// TODO invoke the action for the relevant square
					System.out.println(player);
				}
			}
			Thread.sleep(100);
	}
}		
	

	private static void play() throws InterruptedException {
		while (player.getLocation() < Game.LAST_SQUARE) {
			player.move(Game.roll());
			if (player.getLocation() < Game.LAST_SQUARE) {
				Consumer<Player> consumer = Game.squareEvents.get(Game.squareText.get(player.getLocation()));
				consumer.accept(player);
				System.out.println(player);
			}
			Thread.sleep(100);
		}
	}
}
