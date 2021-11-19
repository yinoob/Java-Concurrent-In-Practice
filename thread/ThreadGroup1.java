package thread;

public class ThreadGroup1 {
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            System.out.println("线程组名字"+
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("线程名称"+
                    Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("执行main所在线程的线程组名称"+ Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main所在线程的线程名称"+ Thread.currentThread().getName());
    }
}
