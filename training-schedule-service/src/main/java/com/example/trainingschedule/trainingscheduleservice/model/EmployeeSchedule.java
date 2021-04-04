package com.example.trainingschedule.trainingscheduleservice.model;

import javax.persistence.*;


@Entity
@Table
public class EmployeeSchedule {
    @Id
    @Column(name = "employee_Id", nullable = false)
    private String employeeId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(name = "start_Date")),
            @AttributeOverride(name = "endDate", column = @Column(name = "end_Date")),
            @AttributeOverride(name = "time", column = @Column(name = "time")),
            @AttributeOverride(name = "duration", column = @Column(name = "duration")),
            @AttributeOverride(name = "repeat", column = @Column(name = "repeat")),
            @AttributeOverride(name = "frequency", column = @Column(name = "frequency"))
    })
    private Schedule schedule;

    public EmployeeSchedule(String employeeId, Schedule schedule) {
        this.employeeId = employeeId;
        this.schedule = schedule;
    }

    public EmployeeSchedule(){

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
