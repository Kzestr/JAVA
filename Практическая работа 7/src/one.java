public class one {
    public static boolean Numer(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int sum = 0;
        String numbers = "0123456789";
        String number = "";
        int cur = 0;

        for (int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            String ch = Character.toString(c);
            if(numbers.contains(ch)) {
                number += ch;
            }
            if (ch.equals(" ") && !number.equals("")) {
                if (cur == 0 || cur == 2) {
                    sum += Integer.parseInt(number);
                }
                cur += 1;
                number = "";
            }
        }
        System.out.println(sum);
    }
}
