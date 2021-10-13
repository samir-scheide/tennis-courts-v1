package com.tenniscourts.schedules;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel("Create a schedule using thnis model.")
public class CreateScheduleRequestDTO {

  @ApiModelProperty("The tennis court unique identifier.")
  @NotNull
  private Long tennisCourtId;
  
  @ApiModelProperty("The start time of the schedule.")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  @NotNull
  private LocalDateTime startDateTime;

}
