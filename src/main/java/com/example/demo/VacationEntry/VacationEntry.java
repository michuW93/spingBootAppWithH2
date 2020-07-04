package com.example.demo.VacationEntry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Embeddable
public class VacationEntry {
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Calendar startDate;

    @Column(name = "days")
    private int daysTaken;

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getDaysTaken() {
        return daysTaken;
    }

    public void setDaysTaken(int daysTaken) {
        this.daysTaken = daysTaken;
    }

    @Override
    public String toString() {
        return "VacationEntry{" +
                "startDate=" + startDate +
                ", daysTaken=" + daysTaken +
                '}';
    }
}
