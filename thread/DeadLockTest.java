package thread;

public class DeadLockTest {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();
    public static void main(String[] args){
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread()+"get ResourceA");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"waiting get B");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+"get B");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread()+"get ResourceB");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"waiting get A");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread()+"get A");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
