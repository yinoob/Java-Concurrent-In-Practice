package thread;

public class ThreadLocalTest1 {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    public static void main(String[] args){
        threadLocal.set("hello world");

        Thread thread  = new Thread(new Runnable(){
            public void run(){
                System.out.println("thread:"+threadLocal.get());
            }
        });
        thread.start();
        System.out.println("main:" +threadLocal.get());

    }
}
