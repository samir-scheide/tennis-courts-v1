package com.tenniscourts.schedules;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  Schedule map(ScheduleDTO source);
  
  ScheduleDTO map(Schedule source);
  
  List<ScheduleDTO> map(List<Schedule> source);
    
}
