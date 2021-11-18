package Thread;

public class NewThread {
    public static class NewThreadExtend extends Thread{
        @Override
        public void run(){
            System.out.println("这是我的新线程，继承Thread类实现");
        }
    }

    public static void main(String[] args){
        NewThreadExtend newThreadExtend = new NewThreadExtend();
        newThreadExtend.start();
    }
}
