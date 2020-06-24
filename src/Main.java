import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Number Of Lab");
            int number = 0;
            try {
                number = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            switch (number) {
                case 2:
                    Lab2.Main.main(new String[1]);
                    break;
                case 3:
                    Lab3.Main.main(new String[1]);
                    break;
                case 4:
                    Lab4.Main.main(new String[1]);
                    break;
                case 5:
                    Lab5.Main.main(new String[1]);
                    break;
                case 6:
                    Lab6.Main.main(new String[1]);
                    break;
                case 7:
                    Lab7.Main.main(new String[1]);
                    break;
                case 8:
                    Lab8.Main.main(new String[1]);
                    break;
                case 9:
                    Lab9.Main.main(new String[1]);
                    break;
                default:
                    System.out.println("Wrong number of Lab");
            }
            boolean a = true;
            while (a) {
                System.out.println("Do you want run one more Lab? y/n ");
                String res = new Scanner(System.in).nextLine();
                if (res.equals("n")) flag = a = false;
                else if (res.equals("y")) a = false;
                else {
                    System.out.println("Wrong symbol");
                }

            }
        }
    }
}
