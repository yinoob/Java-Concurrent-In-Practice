package juc;

import java.util.concurrent.locks.LockSupport;

public class ParkTest1 {
    public void parkTest1(){
        LockSupport.park();
    }

    public static void main(String[] args){
        ParkTest1 parkTest1 = new ParkTest1();
        parkTest1.parkTest1();
    }
}
