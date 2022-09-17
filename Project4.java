import java.util.*;
import java.text.DecimalFormat;
public class Project4 {

    public static void main (String [] args) {
        DecimalFormat df=new DecimalFormat("#.##");
        Scanner s = new Scanner(System.in);
        int subTotal = menu_received(s);
        double tax = subTotal*0.085;
        System.out.println("Your total after tax is $ " + (subTotal + tax));
        double total = subTotal + tip_calculator(subTotal, s) + tax;

        System.out.println("Your total after tax and tip is $" + df.format(total));
        System.out.println("Thank you and enjoy the food and come again!");
    }
    public static double tip_calculator(int total, Scanner s) {
        DecimalFormat df=new DecimalFormat("#.##");
        System.out.print("1. tip 10%: " + df.format(total*0.1) + "\r\n" +
                "2. tip 15%: " + df.format(total*0.15) + "\r\n" +
                "3. tip 20%: " + df.format(total*0.2) + "\r\n" +
                "Please choose one option: (0 for no tip): \r\n");
        int input = s.nextInt();
        switch (input) {
            case 1:
                return total*0.1;
            case 2:
                return total*0.15;
            case 3:
                return total*0.2;
        }
        return 0;

    }
    public static int menu_received(Scanner s) {
        DecimalFormat df=new DecimalFormat("#.##");
        String text = "Thank you for ordering";
        int subTotal = 0;
        int option = 1;
        while (option != 0) {
            System.out.print("Here is our menu:\r\n" +
                    "1. Bulgogi -- $15.00\r\n" +
                    "2. Kalbi -- $18.00\r\n" +
                    "3. Kimchi Fried Rice -- $16.00\r\n" +
                    "Please choose one option at one time using the number (0 to end the order): \r");

            option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println(text + " Bulgogi");
                    subTotal += 15;
                    break;

                case 2:
                    System.out.println(text + " Kalbi");
                    subTotal += 18;
                    break;

                case 3:
                    System.out.println(text + " Kimchi");
                    subTotal += 16;
                    break;

            }
            System.out.println("Your total is $" + df.format(subTotal) + "\n");
        }
        return subTotal;

    }
}