package Test;

import Components.Journal;
import Main.Read;
import Main.Write;

import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {


        Scanner console = new Scanner(System.in);
        String volume = "31-1";

        Journal journal = Read.readJournal(volume);
        Write.writeJournal(volume, journal);






//        String language = "";
//        do {
//            System.out.println("Language : EN, KOR, or SPA");
//            language = console.next();
//        } while (!language.equals("EN") && !language.equals("KOR") && !language.equals("SPA"));


    }
}
