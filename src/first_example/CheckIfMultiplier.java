package first_example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CheckIfMultiplier {

    public void initializeRunnables(List<Integer> numbers, int divider, int chunks){
        List<List<Integer>> list = splitList(numbers, chunks);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(chunks);
        List<MultiplierCheckRunnable> runnables = list.stream().map(x -> new MultiplierCheckRunnable(x, divider)).toList();
        runnables.forEach(executor::execute);
    }

    private List<List<Integer>> splitList(List<Integer> numbers, int chunks){
        List<List<Integer>> list = new ArrayList<>();
        System.out.println("Attempt to split list");

        for(int i = 0; i < chunks; i++) {
            list.add(new ArrayList<>());
            for (int j = i * (numbers.size() / chunks); j < (numbers.size() / chunks) * (i + 1); j++) {
                list.get(i).add(numbers.get(j));
            }
        }

        return list;
    }

}
