package thread;

public class Join {
    static class ThreadA implements Runnable{
        @Override
        public void run(){
            try{
                System.out.println("sleep one second");
                Thread.sleep(1000);
                System.out.println("already sleep one second ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws InterruptedException{
        Thread thread = new Thread(new ThreadA());
        thread.start();
        //thread.join();
        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");
    }
}
