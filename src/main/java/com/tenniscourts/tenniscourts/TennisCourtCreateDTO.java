package com.tenniscourts.tenniscourts;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tenniscourts.schedules.ScheduleDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TennisCourtCreateDTO {

  @NotNull
  private String name;
  
  @NotEmpty
  private List<ScheduleDTO> tennisCourtSchedules;
  
}
