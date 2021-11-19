package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Task1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception{
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String args[]) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Task1());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
