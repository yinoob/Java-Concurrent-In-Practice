package issues;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpDateFormatTest2 {

    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args){
        for(int i = 0; i<10; ++i){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println(safeSdf.get().parse("2021-11-26 00:30:00"));
                    }catch (ParseException e){
                        e.printStackTrace();
                    }finally {
                        safeSdf.remove();
                    }
                }
            });
            thread.start();
        }
    }
}
