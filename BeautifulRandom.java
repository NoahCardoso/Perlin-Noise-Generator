// BeautifulRandom
// Creates images of PerlinNoise
// Noah Cardoso
// An experment into Chat GPT
// I used varius examples online as well as help from Chat GPT to write this code
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class BeautifulRandom extends JFrame {
  private static final int WIDTH = 500;
  private static final int HEIGHT = 500;
  private static final int OCTAVES = 16;
  private static final double PERSISTENCE = 0.5;

  public BeautifulRandom() {
    super("Beautiful Random");
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void paint(Graphics g) {
    Random random = new Random();
    PerlinNoise perlin = new PerlinNoise(random.nextLong(), OCTAVES, PERSISTENCE);

    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
	double value = perlin.getNoise(x / 100.0, y / 100.0);
	
	int color = (int) Math.abs(value * 255);
	
	g.setColor(new Color(color, color, color));
	g.fillRect(x, y, 1, 1);
      }
    }
  }

  public static void main(String[] args) {
    BeautifulRandom br = new BeautifulRandom();
  }
}
