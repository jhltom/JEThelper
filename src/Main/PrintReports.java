package Main;
import Components.Journal;
import java.util.Scanner;

public class PrintReports {

    public static void printReports(Scanner console, Journal volume) {
        boolean cont = true;

        while(cont) {
            System.out.println("====================================");
            System.out.println("E          Editorial Report");
            System.out.println("F          Financial Report");
            System.out.println("X          Exit");
            System.out.println("====================================");
            System.out.println("What action would you like to perform?");

            String in = console.next();

            switch (in) {
                case "e":
                case "E":
                    volume.makeEditorialReport();
                    cont = false;
                    break;
                case "f":
                case "F":
                    volume.makeFinancialReport();
                    cont = false;
                    break;
                case "x":
                case "X":
                    System.out.println("Quiting...");
                    cont = false;
                    break;

                default:
                    break;
            }
        }
    }
}
