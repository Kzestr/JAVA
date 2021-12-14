import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() throws HeadlessException {


        JPanel menu = new JPanel();
        JButton withPlayer = new JButton("Игрок");
        JButton withBot = new JButton("Бот");
        JPanel buttons = new JPanel();
        JLabel label = new JLabel("Выберите соперника");

        buttons.add(withPlayer);
        buttons.add(withBot);
        buttons.setLayout(new GridLayout(1, 2));

        menu.add(label);
        menu.add(buttons);
        menu.setVisible(true);
        menu.setSize(500, 500);
        menu.setLayout(new FlowLayout());

        add(menu);



        withPlayer.addActionListener(action -> {
            menu.setVisible(false);
            remove(menu);
            add(new GameWithPlayer());
        });

        withBot.addActionListener(action -> {
            menu.setVisible(false);
            remove(menu);
            add(new GameWithBot());
        });
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

