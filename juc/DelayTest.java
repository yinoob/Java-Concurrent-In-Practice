package juc;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTest {
    static class DelayedEle implements Delayed{
        private final long delayTime;//延迟时间
        private final long expire;//到期时间
        private String taskName;//任务名称

        public DelayedEle(long delay,String taskName){
            delayTime = delay;
            this.taskName = taskName;
            expire = System.currentTimeMillis() +delay;
        }

        @Override
        public long getDelay(TimeUnit unit){
            return unit.convert(this.expire-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o){
            return (int)(this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString(){
            final StringBuilder sb = new StringBuilder("DelayedEle{");
            sb.append("delay=").append(delayTime);
            sb.append(",expire=").append(expire);
            sb.append(",taskName='").append(taskName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args){
        DelayQueue<DelayedEle> delayedEles = new DelayQueue<DelayedEle>();
        Random random = new Random();
        for(int i = 0;i < 10; ++i){
            DelayedEle ele = new DelayedEle(random.nextInt(500),"task:"+i);
            delayedEles.offer(ele);
        }

        DelayedEle ele = null;
        try{
            for(;;){
                while((ele = delayedEles.take()) != null){
                    System.out.println(ele.toString());
                }
            }


        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
