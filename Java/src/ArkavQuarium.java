import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ArkavQuarium {
  static Aquarium aquarium;
  static int win = 0;

  public static final BufferedImage[] objectImage = new BufferedImage[21];

  private static void init() {
    String path = "C:\\Users\\User\\Documents\\GitHub\\ArkavQuarium\\Java\\src\\";
    try {
      objectImage[0] = ImageIO.read(new File(path + "guppy100.png"));
      objectImage[1] = ImageIO.read(new File(path + "guppy101.png"));
      objectImage[2] = ImageIO.read(new File(path + "guppy110.png"));
      objectImage[3] = ImageIO.read(new File(path + "guppy111.png"));
      objectImage[4] = ImageIO.read(new File(path + "guppy200.png"));
      objectImage[5] = ImageIO.read(new File(path + "guppy201.png"));
      objectImage[6] = ImageIO.read(new File(path + "guppy210.png"));
      objectImage[7] = ImageIO.read(new File(path + "guppy211.png"));
      objectImage[8] = ImageIO.read(new File(path + "guppy300.png"));
      objectImage[9] = ImageIO.read(new File(path + "guppy301.png"));
      objectImage[10] = ImageIO.read(new File(path + "guppy310.png"));
      objectImage[11] = ImageIO.read(new File(path + "guppy311.png"));
      objectImage[12] = ImageIO.read(new File(path + "piranha00.png"));
      objectImage[13] = ImageIO.read(new File(path + "piranha01.png"));
      objectImage[14] = ImageIO.read(new File(path + "piranha10.png"));
      objectImage[15] = ImageIO.read(new File(path + "piranha11.png"));
      objectImage[16] = ImageIO.read(new File(path + "snail0.png"));
      objectImage[17] = ImageIO.read(new File(path + "snail1.png"));
      objectImage[18] = ImageIO.read(new File(path + "food.png"));
      objectImage[19] = ImageIO.read(new File(path + "coin.png"));
      objectImage[20] = ImageIO.read(new File(path + "background.png"));
    } catch (IOException e) {
      System.out.println("File not found!");
    }
  }

  public static void main(String[] args) {
    init();

    JFrame frame = new JFrame("Aquarium");

    aquarium = new Aquarium(800, 600 - 128, 25, 20);

    frame.setSize(800, 600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(null);

    frame.setContentPane(aquarium);

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        // Win/Lose Condition
        if (aquarium.getEgg() >= 3) {
          timer.cancel();
          timer.purge();
          win = 1;
        } else {
          if (aquarium.getGuppies().isEmpty() && aquarium.getPiranhas().isEmpty()) {
            int money = aquarium.getMoney();
            if (money < Guppy.price && money < Piranha.price) {
              timer.cancel();
              timer.purge();
              win = -1;
            }
          }
        }

        aquarium.tick();
      }
    }, 0, 50);
  }
}