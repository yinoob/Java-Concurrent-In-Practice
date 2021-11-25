package issues;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    static Timer timer = new Timer();

    public static void main(String[] args){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("===one Task===");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                throw new RuntimeException("error");
            }
        },500);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (; ; ) {
                    System.out.println("===two Task===");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    throw new RuntimeException("error");
                }
            }
        },1000);
    }

}
