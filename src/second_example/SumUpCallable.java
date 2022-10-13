package second_example;

import java.util.List;
import java.util.concurrent.Callable;

public class SumUpCallable implements Callable<Integer>{

    private List<Integer> sumUpList;

    public SumUpCallable(List<Integer> sumUpList){
        this.sumUpList = sumUpList;
    }


    @Override
    public Integer call(){
        return sumUpList.stream().reduce(0, Integer::sum);
    }
}
