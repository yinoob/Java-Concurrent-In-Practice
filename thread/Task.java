package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception{
        Thread.sleep(5000);
        return 2;
    }

    public static void main(String args[])throws Exception{
        ExecutorService executorService  = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        System.out.println(result.get());
    }
}
