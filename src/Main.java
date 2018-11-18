import Main.*;
import Components.Journal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;





public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner console = new Scanner(System.in);
        boolean cont = true;

        String volume = Read.readJournals(console);
        Journal journal = Read.readJournal(volume);

        while(cont){
            System.out.println("");
            System.out.println("Choice         Action");
            System.out.println("====================================");
            System.out.println("A          Manage Articles");
            System.out.println("R          Manage Reviewers");
            System.out.println("P          Print Reports");
            System.out.println("V          Re-select Volume");
            System.out.println("X          Exit and Save");
            System.out.println("====================================");
            System.out.println("What action would you like to perform?");
            String in = console.next();

            switch (in) {
                case "a":
                case "A":
                    System.out.println("");
                    System.out.println("Manage Articles------------");
                    ManageArticles.manageArticles(console, journal);
                    System.out.println("");break;

                case "r":
                case "R":
                    System.out.println("");
                    System.out.println("Manage Reviewers------------");
                    ManageReviewers.manageReviewers(console, journal);
                    System.out.println("");break;
                case "p":
                case "P":
                    System.out.println("");
                    System.out.println("Print Reports------------");
                    PrintReports.printReports(console, journal);
                    System.out.println("");break;
                case "v":
                case "V":
                    System.out.println("");
                    System.out.println("Saving Volume "+volume+"...");
                    Write.writeJournal(volume, journal);
                    System.out.println("Saving Done");
                    System.out.println("");
                    System.out.println("Re-select Volume------------");
                    volume = Read.readJournals(console);
                    journal = Read.readJournal(volume);
                    System.out.println("");break;
                case "x":
                case "X":
                    System.out.println("");
                    System.out.println("Saving Volume "+volume+"...");
                    System.out.println("");
                    Write.writeJournal(volume, journal);
                    System.out.println("Quiting...");
                    cont = false;
                    break;
                default: break;
            }
        }
    }















}













