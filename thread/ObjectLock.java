package thread;

public class ObjectLock {
    private static Object lock = new Object();

    static class ThreadA implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                for(int i = 0;i<1000;i++){
                    System.out.println("ThreadA " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                for(int i = 0;i<1000;i++){
                    System.out.println("ThreadB " + i);
                }
            }
        }
    }

    public static void main(String[] args){
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

    }
}
