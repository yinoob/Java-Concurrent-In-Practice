package juc;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    private double x,y;
    private final StampedLock s1 = new StampedLock();

    //排它写锁
    void move(double deltaX, double deltaY){

        long stamp = s1.writeLock();
        try{
            x += deltaX;
            y += deltaY;
        }finally {
            s1.unlockWrite(stamp);
        }
    }

    //乐观读锁
    double distanceFromOrigin(){
        long stamp = s1.tryOptimisticRead();
        double currentX = x, currentY = y;
        if(!s1.validate(stamp)){
            stamp = s1.readLock();
            try{
                currentX = x;
                currentY = y;
            }finally {
                s1.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX*currentX+currentY*currentY);
    }

    void moveIfAtOrigin(double newX, double newY){
        long stamp = s1.readLock();
        try{
            while(x == 0.0 && y == 0.0){
                long ws = s1.tryConvertToWriteLock(stamp);
                if(ws != 0L){
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }else {
                    s1.unlockRead(stamp);
                    stamp = s1.writeLock();
                }
            }
        }finally {
            s1.unlock(stamp);
        }
    }


}
