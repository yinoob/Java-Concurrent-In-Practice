package juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycleBarrierTest1 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(1,new Runnable(){
        public void run(){
            System.out.println(Thread.currentThread()+"task1 merge result");
        }
    });
    public static void main(String[] args)throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+"task-1");
                    System.out.println(Thread.currentThread()+"enter in barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"enter out barrier");
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        executorService.submit(new Runnable() {
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+"task-2");
                    System.out.println(Thread.currentThread()+"enter in barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"enter out barrier");
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        executorService.shutdown();
    }
}
