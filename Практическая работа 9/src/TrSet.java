import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmailValidator {
    // Email Regex java
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // static Pattern object, since pattern is fixed
    private static Pattern pattern;

    // non-static Matcher object because it's created from the input String
    private Matcher matcher;

    public EmailValidator() {
        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

public class TrSet {
    public static void main(String[] args) {
        TreeSet<String> emailList = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        String text = "";
        while (true)
        {
            text = in.nextLine();
            if (text.equals("LIST")) {
                for (String email : emailList) {
                    System.out.println(email);
                }
            }
            else if (text.contains("ADD")) {
                String[] info = text.split(" ");
                if (info.length > 2) {
                    System.out.println("Bad command, reenter");
                    continue;
                }
                EmailValidator validator = new EmailValidator();
                if (!validator.validateEmail(info[1])) {
                    System.out.println("Bad email, reenter");
                }
                else
                    emailList.add(info[1]);
            }
            else {
                System.out.println("unknown command, reenter");
            }
        }
    }
}
