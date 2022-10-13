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

    public int initializeCallables(int max) throws InterruptedException {
        List<List<Integer>> list = splitIntoChunks(max, GAP_RANGE);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(list.size());
        List<SumUpCallable> runnables = list.stream().map(SumUpCallable::new).toList();
        List<Future<Integer>> sum = executor.invokeAll(runnables);

        return 0;
    }

    private List<List<Integer>> splitIntoChunks(int max, int gap){
        List<List<Integer>> list = new ArrayList<>();
        System.out.println("Attempt to split list");

        for(int i = 0; i * gap < max; i++){
            list.add(new ArrayList<>());
            for(int j = i; j < j + gap; j++) list.get(i).add(j);
        }

        return list;
    }

}
