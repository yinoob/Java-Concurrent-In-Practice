package issues;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpDateFormatTest {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args){
        for(int i=0; i<10; ++i){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (sdf) {
                            System.out.println(sdf.parse("2021-11-26 00:30:00"));
                        }
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
