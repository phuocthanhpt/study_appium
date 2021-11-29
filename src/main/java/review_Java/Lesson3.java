package review_Java;

import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
        // Exercise 01: calculate how many minutes in total
        String str = "3 hrs and 10 minutes";
        int totalMinutes = calculateMinutes(str);
        System.out.printf("Total minutes %d%n", totalMinutes);

        // Exercise 02: Allow user to input maximum 3 times
        checkInputPassword();

        // Exercise 03: NOT using REGEX, extract digit character from that String
        String str3 = "124 minutes";
        String digits = extractDigitInString(str3);
        System.out.printf("<%s> to digits <%s>%n", str3, digits);

        // Exercise 04: Check http OR https; domain name, .com OR .net
        String url = "https://google.com";
        checkURLInfo(url);
    }

    /*
        Exercise 04: Check http OR https; domain name, .com OR .net
     */
    private static void checkURLInfo(String url) {
        System.out.println("Exercise 04: Check http OR https; domain name, .com OR .net");
        String[] splitURL = url.split("://");
        String[] splitDomain = splitURL[1].split("\\.");
        System.out.printf("Protocol: %s%n", splitURL[0]);
        System.out.printf("Domain name: %s%n", splitDomain[0]);
        System.out.printf("Domain info: %s%n", splitDomain[1]);
    }

    /*
        Exercise 03: NOT using REGEX, extract digit character from that String
     */
    private static String extractDigitInString(String str3) {
        System.out.println("Exercise 03: NOT using REGEX, extract digit character from that String");
        String digits = "";
        for (int i = 0; i < str3.length(); i++) {
            char c = str3.charAt(i);
            if(Character.isDigit(c)){
                digits += c;
            }
        }
        return digits;
    }

    /*
        Exercise 02: Allow user to input maximum 3 times
     */
    private static void checkInputPassword() {
        System.out.println("Exercise 02: Allow user to input maximum 3 times");
        String myPassword = "password123";
        int count = 1;
        boolean isCorrect = false;
        Scanner in = new Scanner(System.in);

        do{
            System.out.println("Please input password: ");
            String password = in.nextLine();
            if(password.equals(myPassword)){
                isCorrect = true;
                break;
            }
            else
                System.out.printf("<%s> is not correct, please try again (%d)%n", password,count);
            count++;
        }while(count<=3);

        if(!isCorrect)
            System.out.println("You inputted wrong password 3 times");
        else System.out.println("Correct password!");
    }

    /*
        Exercise 01: calculate how many minutes in total
     */
    private static int calculateMinutes(String str) {
        System.out.println("Exercise 01: calculate how many minutes in total");
        String[] times = str.split("hrs");
        int totalMinutes = (Integer.parseInt(times[0].replaceAll("[^0-9]",""))*60)
                + (Integer.parseInt(times[1].replaceAll("[^0-9]","")));
        return totalMinutes;
    }


}
