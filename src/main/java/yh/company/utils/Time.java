package yh.company.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public boolean Compare(){
        Date time = new Date();
        Date time2 = new Date();
        Calendar now = Calendar.getInstance();
        int i = now.get(Calendar.YEAR);
        //System.out.println("==========="+i);
        int i1 = now.get(Calendar.MONTH)+1;
        //System.out.println("==========="+i1);
        int i2 = now.get(Calendar.DAY_OF_MONTH);
        //System.out.println("=============="+i2);
        now.set(i,i1-1,i2,9,0,0);
        long timeInMillis = now.getTimeInMillis();
        Calendar now2 = Calendar.getInstance();
        now2.set(i,i1,i2,0,0,0);
        long timeInMillis2 = now2.getTimeInMillis();
        if(timeInMillis>=time.getTime()&&time.getTime()>=timeInMillis2){
            return true;
        }else{
            return false;
        }
    }
    public long isToday(){
        Calendar now = Calendar.getInstance();
        int i = now.get(Calendar.YEAR);
        int i1 = now.get(Calendar.MONTH)+1;
        int i2 = now.get(Calendar.DAY_OF_MONTH);
        now.set(i,i1-1,i2,0,0,0);
        long timeInMillis = now.getTimeInMillis();
        return timeInMillis;
    }
}
