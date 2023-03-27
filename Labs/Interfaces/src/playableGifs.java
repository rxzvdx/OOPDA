import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public interface playableGifs extends Playable { 

	public default void play(String filename) {
		System.out.println("Playing " + filename);

		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(filename);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocation(filename.length() * 10, filename.length() * 10);
		frame.setVisible(true);
	}

}
