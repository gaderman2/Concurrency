package first_example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String FILE_PATH = "C:\\Users\\user\\Documents\\Schule\\3. Klasse\\POS\\Concurrency\\numbers.csv";

    private static Scanner input = new Scanner(System.in, "Windows-1252");

    public static void main(String[] args) {
        try {
            List<Integer> numbers = FileReader.readFile(FILE_PATH);

            int chunks = chunks();
            int divider = divider();

            CheckIfMultiplier multiplierCheck = new CheckIfMultiplier();
            System.out.println("Initializing MultiplierCheck ...");
            multiplierCheck.initializeRunnables(numbers, divider, chunks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static int chunks(){
        System.out.print("chunks> ");
        return input.nextInt();
    }

    private static int divider(){
        System.out.print("divider> ");
        return input.nextInt();
    }
}