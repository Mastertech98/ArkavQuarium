import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

class Tick extends TimerTask {
    public void run() {
        ArkavQuarium.aquarium.tick();

        // Win/Lose Condition
        if (ArkavQuarium.aquarium.getEgg() >= 3) {

        } else {
            if (ArkavQuarium.aquarium.getGuppies().isEmpty() && ArkavQuarium.aquarium.getPiranhas().isEmpty()) {
                int money = ArkavQuarium.aquarium.getMoney();
                if (money < Guppy.price && money < Piranha.price) {

                }
            }
        }
    }
}

public class ArkavQuarium {
    static Aquarium aquarium;
    public static BufferedImage[] objectImage = new BufferedImage[20];

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
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public static void main(String[] args) {
        init();

        JFrame frame = new JFrame("Aquarium");

        aquarium = new Aquarium(800, 600 - 128, 25, 20);

        JButton buyGuppy = new JButton("Buy Guppy");
        buyGuppy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aquarium.add(new Guppy(aquarium));
            }
        });

        JButton buyPiranha = new JButton("Buy Piranha");
        buyPiranha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aquarium.add(new Piranha(aquarium));
            }
        });

        aquarium.add(buyGuppy);
        aquarium.add(buyPiranha);

        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.setContentPane(aquarium);

        Timer timer = new Timer();
        timer.schedule(new Tick(), 0, 50);
    }
}
