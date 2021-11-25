package juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList1 {
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
    public static void main(String[] args)throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("wanyisong");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("zhuhai");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1, "hahaha");
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });

        Iterator<String> itr = arrayList.iterator();

        threadOne.start();
        threadOne.join();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
