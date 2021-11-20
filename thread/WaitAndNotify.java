package thread;

public class WaitAndNotify {
    private static Object lock = new Object();

    static class ThreadA implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                for(int i = 0; i < 100;i++){
                    try {
                        System.out.println("ThreadA " + i);
                        lock.notify();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                for(int i = 0; i < 100;i++){
                    try {
                        System.out.println("ThreadB " + i);
                        lock.notify();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args)throws InterruptedException{
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

    }
}
