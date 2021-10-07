package com.tenniscourts.reservations;

import java.math.BigDecimal;

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
