package thread;
public class Reorder{
    public static class ReadThread extends Thread{

        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                if(ready){
                    System.out.println(num+num);
                }
                System.out.println("read thread...");
            }
        }
    }

    public static class WriteThread extends Thread{
        public void run(){
            num = 2;
            ready = true;
            System.out.println("write set over...");
        }
    }

    private static volatile int num = 0;
    private static volatile boolean ready = false;


    public static void main(String[] args)throws InterruptedException{
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }


}
