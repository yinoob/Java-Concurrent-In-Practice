package thread;

public class Join {
    public static int i = 0;
    static class ThreadA implements Runnable{
        @Override
        public void run(){
            try{
                i++;
                System.out.println("sleep one second");
                Thread.sleep(1000);
                System.out.println("already sleep one second ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run(){
            try{
                i++;
                System.out.println("sleep one second");
                Thread.sleep(1000);
                System.out.println("already sleep one second ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws InterruptedException{
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadA());
        threadA.start();
        threadB.start();
        //threadA.join();
        //threadB.join();
        System.out.println("i的值为"+i);
        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");

    }
}
