package com.tenniscourts.schedules;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateScheduleRequestDTO {

  @NotNull
  private Long tennisCourtId;
  
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  @NotNull
  private LocalDateTime startDateTime;

}
