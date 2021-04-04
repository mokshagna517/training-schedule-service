package com.example.trainingschedule.trainingscheduleservice.service;

import com.example.trainingschedule.trainingscheduleservice.model.EmployeeSchedule;
import com.example.trainingschedule.trainingscheduleservice.model.Frequency;
import com.example.trainingschedule.trainingscheduleservice.model.Schedule;
import com.example.trainingschedule.trainingscheduleservice.repository.EmployeeScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    EmployeeScheduleRepository employeeScheduleRepository;

    public EmployeeSchedule saveEmployeeSchedule(EmployeeSchedule employeeSchedule){
        employeeSchedule=employeeScheduleRepository.save(employeeSchedule);
        return employeeSchedule;
    }

    public EmployeeSchedule getEmployeeScheduleById(String id){
       EmployeeSchedule employeeSchedule=employeeScheduleRepository.findById(id).orElse(new EmployeeSchedule());
       return employeeSchedule;
    }

    public EmployeeSchedule updateScheduleById(String id, Schedule newSchedule){
        EmployeeSchedule employeeScheduleOld;
        employeeScheduleOld=employeeScheduleRepository.findById(id).orElse(new EmployeeSchedule());
        employeeScheduleOld.setEmployeeId(id);
        employeeScheduleOld.setSchedule(newSchedule);
        return employeeScheduleRepository.save(employeeScheduleOld);
    }

    public void deleteScheduleById(String id){
        employeeScheduleRepository.deleteById(id);
        return;
    }

    public List<EmployeeSchedule> getScheduleByDate(String date) throws ParseException {
       List<EmployeeSchedule> employeeSchedules = employeeScheduleRepository.findAll();
       List<EmployeeSchedule> res=new ArrayList<>();
       for(EmployeeSchedule e: employeeSchedules){
          String startDate=e.getSchedule().getStartDate();
          String endDate=e.getSchedule().getEndDate();
          boolean repeat=e.getSchedule().isRepeat();
           Date startDate1=new SimpleDateFormat("dd MMM yyyy").parse(startDate);
           Date endDate1=new SimpleDateFormat("dd MMM yyyy").parse(endDate);
           Date requiredDate=new SimpleDateFormat("dd MMM yyyy").parse(date);
           if(requiredDate.equals(startDate1) || requiredDate.equals(endDate1)){
               res.add(e);
           }
           else if(requiredDate.after(startDate1) && requiredDate.before(endDate1) && repeat)
               res.add(e);
           else
               continue;
       }
       return res;
    }
}
