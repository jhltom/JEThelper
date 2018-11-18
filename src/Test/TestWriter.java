package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestWriter {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);
        Scanner scanner = new Scanner(file);

        writer.write("0");
        writer.newLine();
        writer.write("1");
        writer.close();
        fw.close();

        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }



    }
}
