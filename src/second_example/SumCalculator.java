package second_example;

import first_example.MultiplierCheckRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class SumCalculator {

    private static final int GAP_RANGE = 100;

    public int initializeCallables(int max){
        List<List<Integer>> list = splitIntoChunks(max, GAP_RANGE);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(list.size());
        List<SumUpCallable> runnables = list.stream().map(SumUpCallable::new).toList();
        List<Future<Integer>> sum = null;
        try {
            sum = executor.invokeAll(runnables);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return sum.stream().mapToInt(x -> {
            try {
                return x.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum();
    }

    private List<List<Integer>> splitIntoChunks(int max, int gap){
        List<List<Integer>> list = new ArrayList<>();
        System.out.println("Attempt to split list");

        for(int i = 0; i * gap < max; i++){
            System.out.println("new split");
            list.add(new ArrayList<>());
            for(int j = 1; j <= gap; j++){
                if(j + (i * gap) > max) break;

                list.get(i).add(j + (i * gap));
                System.out.println(j + (i * gap));
            }
        }

        return list;
    }

}
