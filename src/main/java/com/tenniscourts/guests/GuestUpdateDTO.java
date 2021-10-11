package com.tenniscourts.guests;

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
@ApiModel(description = "Update a guest using this model.")
public class GuestUpdateDTO {

  @ApiModelProperty(value = "Guest name.", required = true)
  @NotNull
  private String name;
  
}
