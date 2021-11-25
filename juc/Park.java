package juc;

import java.util.concurrent.locks.LockSupport;

public class Park {
    public static void main(String[] args){
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("end park!");
    }
}
