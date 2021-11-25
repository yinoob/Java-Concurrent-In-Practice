package juc;

import java.util.concurrent.locks.LockSupport;

public class UnPark {
    public static void main(String[] args){
        System.out.println("begin park!");

        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();

        System.out.println("end park!");
    }
}
