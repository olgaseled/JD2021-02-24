package by.it.papruga.jd02_06.task_c;

import java.time.LocalTime;

public class Time {

    LocalTime localTime;

    public String getTime(){

        this.localTime = LocalTime.now();
        return localTime.getHour() + ":"+
                localTime.getMinute() + ":" +
                localTime.getSecond();
    }

}
