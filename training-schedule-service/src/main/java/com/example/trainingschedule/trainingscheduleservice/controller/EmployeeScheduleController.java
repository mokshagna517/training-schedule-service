package com.example.trainingschedule.trainingscheduleservice.controller;

import com.example.trainingschedule.trainingscheduleservice.model.EmployeeSchedule;
import com.example.trainingschedule.trainingscheduleservice.model.Schedule;
import com.example.trainingschedule.trainingscheduleservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class EmployeeScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/book")
    public EmployeeSchedule saveEmployeeSchedule(@RequestBody EmployeeSchedule employeeSchedule){
       return scheduleService.saveEmployeeSchedule(employeeSchedule);
    }

    @GetMapping("/view/id/{id}")
    public EmployeeSchedule getEmployeeSchedule(@PathVariable String id){
       EmployeeSchedule employeeSchedule = scheduleService.getEmployeeScheduleById(id);
       return employeeSchedule;
    }

    @PutMapping("/update/{id}")
    public EmployeeSchedule updateEmployeeSchedule(@PathVariable String id, @RequestBody Schedule updatedEmployeeSchedule){
        EmployeeSchedule employeeSchedule=scheduleService.updateScheduleById(id, updatedEmployeeSchedule);
        return employeeSchedule;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus cancelSchedule(@PathVariable String id){
        scheduleService.deleteScheduleById(id);
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping("/view/date/{date}")
    public List<EmployeeSchedule> getScheduleByDate(@PathVariable String date) throws ParseException {
        return scheduleService.getScheduleByDate(date);
    }

}
