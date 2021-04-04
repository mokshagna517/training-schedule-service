package com.example.trainingschedule.trainingscheduleservice.model;

import javax.persistence.*;


@Embeddable
public class Schedule {
    private String startDate;
    private String endDate;
    private String time;
    private int duration;
    private boolean repeat;
    private Frequency frequency;

    public Schedule(){

    }

    public Schedule(String startDate, String endDate, String time, int duration, boolean repeat, Frequency frequency) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.duration = duration;
        this.repeat = repeat;
        this.frequency = frequency;
    }

    public String  getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
