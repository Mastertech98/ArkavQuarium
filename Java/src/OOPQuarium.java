import javax.swing.*;

public class OOPQuarium {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//creating instance of JFrame

        JButton b = new JButton("click"); //creating instance of JButton
        b.setBounds(130, 100, 100, 40); //x axis, y axis, width, height

        frame.add(b); //adding button in JFrame

        frame.setSize(400, 500);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);//making the frame visible

        Aquarium aquarium = new Aquarium(400, 500 - 192, 25, 20);
        boolean running = true;
        boolean win;

        while (running) {
            aquarium.tick();
        }

    }
}
