package first_example;

import java.util.List;

public class MultiplierCheckRunnable implements Runnable{

    private List<Integer> numbers;
    private int divider;

    public MultiplierCheckRunnable(List<Integer> numbers, int divider) {
        this.numbers = numbers;
        this.divider = divider;
    }

    @Override
    public void run() {
        numbers.stream().filter(x -> x % divider == 0).forEach(System.out::println);
    }
}
