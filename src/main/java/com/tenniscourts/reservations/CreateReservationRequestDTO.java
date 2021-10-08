package com.tenniscourts.reservations;

import javax.validation.constraints.NotNull;

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
public class CreateReservationRequestDTO {

  @NotNull
  private Long guestId;
  
  @NotNull
  private Long scheduleId;

}
