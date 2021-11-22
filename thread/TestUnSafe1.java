package thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe1 {
    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state =0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnSafe1.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

     public static void main(String[] args){

        TestUnSafe1 testUnSafe1 = new TestUnSafe1();
        Boolean success = unsafe.compareAndSwapInt(testUnSafe1, stateOffset, 0, 1);
        System.out.println(success);
        }
}
