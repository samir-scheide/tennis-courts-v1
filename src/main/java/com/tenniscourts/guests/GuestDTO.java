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
@ApiModel(description = "Most operations use this model to return some informarion.")
public class GuestDTO {

  @ApiModelProperty(value = "Guest unique identifier.", required = true)
  @NotNull
  private Long id;
  
  @ApiModelProperty(value = "Guest name.", required = true)
  @NotNull
  private String name;
 
}
