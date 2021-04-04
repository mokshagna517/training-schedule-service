package com.example.trainingschedule.trainingscheduleservice.repository;

import com.example.trainingschedule.trainingscheduleservice.model.EmployeeSchedule;
import com.example.trainingschedule.trainingscheduleservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule, String> {
    EmployeeSchedule findByScheduleStartDate(String startDate);
}
