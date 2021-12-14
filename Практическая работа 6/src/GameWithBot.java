import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWithBot extends JPanel {
    private int[][] field = new int[3][3]; //1 - крестик, 0 - нолик
    private boolean first = false; //true - игрок играет за крестика, иначе за нолика
    JLabel whoIsMe = new JLabel();
    JLabel winner = new JLabel();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g2d.drawRect(50 + 100 * j, 100 + 100 * i, 100, 100);
                if(field[i][j]==1) {
                    g2d.drawLine(75 + 100 * j, 125 + 100 * i, 125 + 100 * j, 175 + 100 * i);
                    g2d.drawLine(125 + 100 * j, 125 + 100 * i, 75 + 100 * j, 175 + 100 * i);
                }
                else if(field[i][j]==0) {
                    g2d.drawOval(75 + 100 * j, 125 + 100 * i, 50, 50);
                }
                g2d.setColor(Color.BLACK);
            }
        }
        winner.setText(isGameOver());
        System.out.println(winner.getText());
    }

    public String isGameOver() {
        boolean isOver = true;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(field[i][j] == -1) {
                    isOver = false;
                    break;
                }
            }
            if(!isOver)
                break;
        }
        if( (field[0][0]==1 && field[0][1]==1 && field[0][2]==1)
                || (field[1][0]==1 && field[1][1]==1 && field[1][2]==1)
                || (field[2][0]==1 && field[2][1]==1 && field[2][2]==1)
                || (field[0][0]==1 && field[1][1]==1 && field[2][2]==1)
                || (field[0][2]==1 && field[1][1]==1 && field[2][0]==1)
                || (field[0][0]==1 && field[1][0]==1 && field[2][0]==1)
                || (field[0][1]==1 && field[1][1]==1 && field[2][1]==1)
                || (field[0][2]==1 && field[1][2]==1 && field[2][2]==1)) {
            return "Игрок X выиграл";
        }
        else if( (field[0][0]==0 && field[0][1]==0 && field[0][2]==0)
                || (field[1][0]==0 && field[1][1]==0 && field[1][2]==0)
                || (field[2][0]==0 && field[2][1]==0 && field[2][2]==0)
                || (field[0][0]==0 && field[1][1]==0 && field[2][2]==0)
                || (field[0][2]==0 && field[1][1]==0 && field[2][0]==0)
                || (field[0][0]==0 && field[1][0]==0 && field[2][0]==0)
                || (field[0][1]==0 && field[1][1]==0 && field[2][1]==0)
                || (field[0][2]==0 && field[1][2]==0 && field[2][2]==0)) {
            return "Игрок O выиграл";
        }
        else if(isOver)
            return "Ничья";
        else
            return "Игра не окончена";
    }

    public void initializeField() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                field[i][j] = -1;
            }
        }
        if(!first)
            field[(int)(Math.random()*3)][(int)(Math.random()*3)] = 1;
    }

    public GameWithBot() {
        initializeField();
        add(winner);
        whoIsMe.setText(first ? "Вы X" : "Вы O");
        add(whoIsMe);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getX() > 50 && e.getY() > 100 && e.getX() < 350 && e.getY() < 400) {
                    if(field[(e.getY()-100)/100][(e.getX()-50)/100] == -1 && winner.getText().equals("Игра не окончена")) {
                        field[(e.getY()-100)/100][(e.getX()-50)/100] = first ? 1 : 0;
                        int rand_x = (int) (Math.random()*3);
                        int rand_y = (int) (Math.random()*3);
                        while(field[rand_y][rand_x]!=-1) {
                            rand_x = (int) (Math.random()*3);
                            rand_y = (int) (Math.random()*3);
                        }
                            field[rand_y][rand_x]= first ? 0 : 1;
                        repaint();
                    }
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Игра");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new GameWithBot());
    }
}