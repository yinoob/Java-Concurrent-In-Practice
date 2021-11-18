package Thread;

public class NewThread1 {
    public static class NewThreadRunnable implements Runnable{
        @Override
        public void run(){
            System.out.println("这是我的新线程，实现Runnable接口实现");
        }
    }

    public static void main(String[] args){
        NewThreadRunnable newThreadRunnable = new NewThreadRunnable();

        new Thread(newThreadRunnable).start();
        //new Thread(new NewThreadRunnable()).start();

        /**错误示范
         newThreadRunnable.run();
         */

        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}
