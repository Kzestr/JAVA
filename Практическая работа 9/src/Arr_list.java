import java.util.ArrayList;
import java.util.Scanner;

public class Arr_list {
    public static void main(String[] args) {
        ArrayList <String> workList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        while (true)
        {
            if (text.equals("LIST")) {
                for (int i = 0; i < workList.size(); i++) {
                    System.out.println(String.valueOf(i) + ". " + workList.get(i));
                }
            }
            else if (text.contains("ADD")) {
                String[] info = text.split(" ");
                int where = -1;
                if (info.length == 3) {
                    where = Integer.parseInt(info[1]) - 1;
                    workList.add(where, info[2]);
                }
                else
                    workList.add(info[1]);
            }
            else if (text.contains("EDIT")) {
                String[] info = text.split(" ");
                int where = -1;
                if (info.length == 3) {
                    where = Integer.parseInt(info[1]) - 1;
                    workList.set(where, info[2]);
                }
            }
            else if (text.contains("DELETE")) {
                String[] info = text.split(" ");
                int where = -1;
                if (info.length == 2) {
                    where = Integer.parseInt(info[1]) - 1;
                    workList.remove(where);
                }
            }
            else {
                System.out.println("unknown command, reenter");
            }
            text = in.nextLine();
        }
    }
}
