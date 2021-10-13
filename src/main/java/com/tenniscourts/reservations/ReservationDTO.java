package com.tenniscourts.reservations;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.tenniscourts.schedules.ScheduleDTO;

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
@ApiModel("Most operations use this model to return some informarion.")
public class ReservationDTO {

  @ApiModelProperty("Reservation unique identifier.")
  private Long id;
  
  @ApiModelProperty("The time and wich court is scheduled to this reservation.")
  private ScheduleDTO schedule;
  
  @ApiModelProperty("The reservation status.")
  private String reservationStatus;
  
  @ApiModelProperty("The previous reservation.")
  private ReservationDTO previousReservation;
  
  @ApiModelProperty("The refund value in case of any.")
  private BigDecimal refundValue;
  
  @ApiModelProperty("The reservation value.")
  private BigDecimal value;
  
  @ApiModelProperty("The schedule unique identifier.")
  @NotNull
  private Long scheduledId;
  
  @ApiModelProperty("The guest unique identifier.")
  @NotNull
  private Long guestId;
  
}
