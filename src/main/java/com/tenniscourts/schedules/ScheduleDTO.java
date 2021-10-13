package com.tenniscourts.schedules;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tenniscourts.tenniscourts.TennisCourtDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Using in most schedule operations.")
public class ScheduleDTO {
  
  @ApiModelProperty("Schedule unique identifier.")
  private Long id;
  
  @ApiModelProperty("Tennis court information.")
  private TennisCourtDTO tennisCourt;
  
  @NotNull
  @ApiModelProperty("Tennis court unique identifier.")
  private Long tennisCourtId;
  
  @NotNull
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
  @ApiModelProperty("The schedule start time.")
  private LocalDateTime startDateTime;
  
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
  @ApiModelProperty("The schedule end time.")
  private LocalDateTime endDateTime;

}
