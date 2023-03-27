import java.util.ArrayList;

public class driver {
	public static void main(String args[]) {
		ArrayList<Playable> mediaCollection = new ArrayList<>();

		darkClip dc1 = new darkClip("Dark-Jonas.gif", "Jonas Walking Into Cave");
		darkClip dc2 = new darkClip("Dark-TheStranger.gif", "Stranger Leaving Cave");
		darkShadowsClip dsc1 = new darkShadowsClip("DarkShadows-Angelique.wav", "Angelique", "606");
		darkShadowsClip dsc2 = new darkShadowsClip("DarkShadows-DoctorHoffman.wav", "Doctor Hoffman", "613");
		darkShadowsClip dsc3 = new darkShadowsClip("DarkShadows-ProfessorStokes.wav", "Professor Stokes", "506");
		darkShadowsClip dsc4 = new darkShadowsClip("DarkShadows-Zombie.wav", "Zombie Sheriff Davenport", "942");
		gameOfThronesClip gotc1 = new gameOfThronesClip("GameOfThrones-Joffrey.gif", "Joffrey Baratheon");
		gameOfThronesClip gotc2 = new gameOfThronesClip("GameOfThrones-Jon.gif", "Jon Snow");
		rockyAndBullwinkleClip rabwc1 = new rockyAndBullwinkleClip("RockyAndBullWinkle-Natasha.wav", "[Natasha]");
		rockyAndBullwinkleClip rabwc2 = new rockyAndBullwinkleClip("RockyAndBullWinkle-RockyAndBullwinkle.wav",
				"[Rocky, Bullwinkle]");
		seinfeldClip sc1 = new seinfeldClip("Seinfeld-Jerry.wav", "Jerry", "1997");
		seinfeldClip sc2 = new seinfeldClip("Seinfeld-Kramer.wav", "Kramer", "1993");

		mediaCollection.add(dc1);
		mediaCollection.add(dc2);
		mediaCollection.add(dsc1);
		mediaCollection.add(dsc2);
		mediaCollection.add(dsc3);
		mediaCollection.add(dsc4);
		mediaCollection.add(dsc4);
		mediaCollection.add(gotc1);
		mediaCollection.add(gotc2);
		mediaCollection.add(rabwc1);
		mediaCollection.add(rabwc2);
		mediaCollection.add(sc1);
		mediaCollection.add(sc2);
		
		mediaCollection.forEach(file -> file.play("C:\\Users\\ranto\\eclipse-workspace\\Interfaces\\MediaFiles (1)\\" + file.getFilename()));
	}

}
