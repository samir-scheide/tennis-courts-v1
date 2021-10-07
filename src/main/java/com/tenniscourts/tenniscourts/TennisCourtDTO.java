package com.tenniscourts.tenniscourts;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.tenniscourts.schedules.ScheduleDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisCourtDTO {

  private Long id;
  
  @NotNull
  private String name;
  
  private List<ScheduleDTO> tennisCourtSchedules;

}
