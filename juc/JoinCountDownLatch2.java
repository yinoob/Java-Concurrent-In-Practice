package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoinCountDownLatch2 {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args)throws InterruptedException{

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
                System.out.println("child threadOne over!");
            }
        });

        executorService.submit(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
                System.out.println("child threadTwo over!");
            }
        });



        System.out.println("wait all child thread over!");

        countDownLatch.await();
        System.out.println("all child thread over!");

        executorService.shutdown();
    }
}
