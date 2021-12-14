import java.util.*;


public class MapPhone {
    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.UnicodeBlock.of(s.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) &&
            !(s.matches("^[a-zA-Z]+$"))) {
                return false;
            }
        }
        return true;
    }

    private static String  get_phone(String text) {
        String r = text.replaceAll("\\D+", "");
        String phone_number = "";
        if (r.length() == 11 && r.charAt(0) == '7') {
            phone_number = "+" + r.charAt(0) + " (" + r.substring(1, 4) + ") " +
                    r.substring(4, 7) + "-" + r.substring(7, 9) +
                    "-" + r.substring(9, 11);
        }
        else if (r.length() == 11 && r.charAt(0) == '8') {
            phone_number = "+7" + " (" + r.substring(1, 4) + ") " +
                    r.substring(4, 7) + "-" + r.substring(7, 9) +
                    "-" + r.substring(9, 11);
        }
        else if (r.length() == 10 && r.charAt(0) == '9') {
            phone_number = "+7" + " (" + r.substring(0, 3) + ") " +
                    r.substring(3, 6) + "-" + r.substring(6, 8) +
                    "-" + r.substring(8, 10);
        }
        return (phone_number);
    }

    public static void main(String[] args) {
        Map<String, String> PhoneBook =  new HashMap<String, String>();
        Scanner in = new Scanner(System.in);
        String text = "";
        while (true)
        {
            text = in.nextLine();

            if (text.equals("LIST")) {
                Map sortedMap = new TreeMap<>(PhoneBook);
                sortedMap.entrySet().forEach(System.out::println);
            }
            else
            {
                String phone_number = get_phone(text);
                if (!phone_number.equals("")) {
                    System.out.println("Вы ввели номер телефона, введите имя");
                    String name = in.nextLine();
                    if (!isValid(name)) {
                        System.out.println("Неправильный формат имени");
                        continue;
                    }
                    PhoneBook.put(name, phone_number);
                }
                else if (isValid(text)){
                    System.out.println("Вы ввели имя, введите номер телефона");
                    String ph_number = in.nextLine();
                    String phh_number = get_phone(ph_number);
                    if (phh_number.equals("")) {
                        System.out.println("Неправильный формат телефона");
                        continue;
                    }
                    PhoneBook.put(text, phh_number);
                }
                else {
                    System.out.println("Повторите ввод");
                }
            }
        }
    }

}
