package third_example;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamsTester {

    public static void main(String[] args){
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < 10; i++) strings.add("test");
        for(int i = 0; i < 5; i++) strings.add((int) (Math.random() * strings.size()), "");
        for(int i = 0; i < 7; i++) strings.add((int) (Math.random() * strings.size()), "Hey");

        System.out.println("Strings:");
        System.out.println("Count of empty strings: " + getCountEmptyString(strings));
        System.out.println("Count of 3 length strings: " + getCountLength3(strings));
        System.out.println("Without empty strings: " + deleteEmptyStrings(strings));
        System.out.println("Merged string: " + getMergedString(strings, " | "));
        System.out.println();

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < (int) (Math.random() * 10 + 10); i++) numbers.add((int) (Math.random() * 256));

        System.out.println("Numbers:");
        System.out.println("Square of Numbers: " + getSquares(numbers));
        System.out.println("Max of Numbers: " + getMax(numbers));
        System.out.println("Min of Numbers: " + getMin(numbers));
        System.out.println("Sum of Numbers: " + getSum(numbers));
        System.out.println("Average of Numbers: " + getAverage(numbers));
    }

    private static int getCountEmptyString(List<String> strings){
        return strings.stream().mapToInt(x ->  x.isEmpty() ? 1 : 0).sum();
    }

    private static int getCountLength3(List<String> strings){
        return strings.stream().mapToInt(x -> x.length() == 3 ? 1 : 0).sum();
    }

    private static List<String> deleteEmptyStrings(List<String> strings){
        return strings.stream().filter(x -> !x.isEmpty()).toList();
    }

    private static String getMergedString(List<String> strings, String seperator){
        return strings.stream().reduce("", (x, y) -> x + seperator + y);
    }

    private static List<Integer> getSquares(List<Integer> numbers){
        return numbers.stream().map(x -> x * x).toList();
    }

    private static int getMax(List<Integer> numbers){
        return numbers.stream().reduce(0, (x, y) -> x > y ? x : y);
    }

    private static int getMin(List<Integer> numbers){
        return numbers.stream().reduce(getMax(numbers), (x, y) -> x < y ? x : y);
    }

    private static int getSum(List<Integer> numbers){
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static int getAverage(List<Integer> numbers){
        return numbers.stream().reduce(0, (x, y) -> x + y / numbers.size());
    }
}
