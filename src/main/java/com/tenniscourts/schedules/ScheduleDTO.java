package com.tenniscourts.schedules;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tenniscourts.tenniscourts.TennisCourtDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleDTO {
  
  private Long id;
  
  private TennisCourtDTO tennisCourt;
  
  @NotNull
  private Long tennisCourtId;
  
  @NotNull
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
  private LocalDateTime startDateTime;
  
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
  private LocalDateTime endDateTime;

}
