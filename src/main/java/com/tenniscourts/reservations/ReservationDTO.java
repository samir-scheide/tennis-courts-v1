package com.tenniscourts.reservations;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.tenniscourts.schedules.ScheduleDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationDTO {

  private Long id;
  
  private ScheduleDTO schedule;
  
  private String reservationStatus;
  
  private ReservationDTO previousReservation;
  
  private BigDecimal refundValue;
  
  private BigDecimal value;
  
  @NotNull
  private Long scheduledId;
  
  @NotNull
  private Long guestId;
  
}
