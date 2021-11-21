package thread;

public class VolatileExample {
    int a = 0;

    volatile boolean flag = false;

    public void writer(){
        a = 1;
        flag = true;
    }

    public void reader(){
        if(flag){
            System.out.println(a);
        }
    }
}
