import java.util.ArrayList;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        System.out.println("Введите ФИО: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        int sp_sum = 0;
        String tmp = "";
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            String cr = Character.toString(c);
            tmp += cr;
            if (cr.equals(" ")) {
                sp_sum += 1;
                arr.add(tmp.replaceAll(" ", ""));
                tmp = "";
            }
            if (i == text.length() - 1) {
                arr.add(tmp);
            }
        }
        if (sp_sum != 2 && sp_sum != 1) {
            System.out.println("Введенная строка не является ФИО");
        }
        else {
            System.out.println("Фамилия: " + arr.get(0));
            System.out.println("Имя: " + arr.get(1));
            if (arr.size() == 3) {
                System.out.println("Отчество: " + arr.get(2));
            }

        }
    }
}
