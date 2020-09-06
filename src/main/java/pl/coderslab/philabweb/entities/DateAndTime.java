package pl.coderslab.philabweb.entities;

import java.time.LocalDateTime;

public class DateAndTime {
    private LocalDateTime time;

    public DateAndTime() {
    }

    public DateAndTime(LocalDateTime time) {
        this.time = time;
    }

    public String getActualDateAndTime() {
        time = LocalDateTime.now();
        return time.getDayOfWeek() + " " + time.getDayOfMonth() + " " + time.getMonth() + " " + time.getYear();
    }
}
