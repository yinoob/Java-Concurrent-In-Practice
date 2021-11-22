package thread;

import sun.misc.Unsafe;

public class TestUnSafe {

    static final Unsafe unsafe = Unsafe.getUnsafe();

    static final long stateOffset;

    private volatile long state = 0;

    static{
        try{
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args){
        TestUnSafe test = new TestUnSafe();
        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);
    }

}
