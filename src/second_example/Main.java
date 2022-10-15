package second_example;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in, "Windows-1252");

    public static void main(String[] args){
        SumCalculator calculator = new SumCalculator();
        System.out.println("Sum: " + calculator.initializeCallables(getN()));
    }

    private static int getN(){
        System.out.print("n> ");
        return input.nextInt();
    }

}