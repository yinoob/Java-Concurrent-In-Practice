package thread;

public class InterruptedTest1 {
    public static void main(String[] args)throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("threadOne begin sleep for 2000 seconds");
                    Thread.sleep(200000);
                    System.out.println("threadOne awaking");
                }catch(InterruptedException e){
                    System.out.println("threadOne is interrupted while sleeping");
                    return;
                }
                System.out.println("thread-leaving normally");
            }
        });

        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }
}
