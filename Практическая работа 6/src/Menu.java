import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private String mode;

    public String getMode() {
        return mode;
    }

    public Menu() throws HeadlessException {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Выберите, с кем играть");
        JPanel buttons = new JPanel();
        JButton withPlayer = new JButton("Играть с игроком");
        JButton withBot = new JButton("Играть с ботом");


        buttons.add(withPlayer);
        buttons.add(withBot);
        buttons.setLayout(new GridLayout(1, 2));

        panel.add(label);
        panel.add(buttons);
        panel.setLayout(new FlowLayout());
        add(panel);

        withPlayer.addActionListener(action -> {
            mode = "Player";
            setVisible(false);
        });

        withBot.addActionListener(action -> {
            mode = "Bot";
            setVisible(false);
        });
    }
}
