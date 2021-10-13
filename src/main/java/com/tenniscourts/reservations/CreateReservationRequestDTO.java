package com.tenniscourts.reservations;

import javax.validation.constraints.NotNull;

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
@ApiModel("Create a reservation using this model.")
public class CreateReservationRequestDTO {

  @ApiModelProperty("Guest unique identifier.")
  @NotNull
  private Long guestId;
  
  @ApiModelProperty("Schedule unique identifier.")
  @NotNull
  private Long scheduleId;

}
