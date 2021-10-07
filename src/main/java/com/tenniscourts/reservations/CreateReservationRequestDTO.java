package com.tenniscourts.reservations;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateReservationRequestDTO {

  @NotNull
  private Long guestId;
  
  @NotNull
  private Long scheduleId;

}
