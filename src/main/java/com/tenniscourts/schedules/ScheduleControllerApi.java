package com.tenniscourts.schedules;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;

/**
 * @author Samir Scheide
 */
@Api("Schedules")
public interface ScheduleControllerApi {

  /**
   * Create a scedule in the given tennis court using the given start date.
   * @param createScheduleRequestDTO tennis court information and schedule time.
   * @return a message
   */
  @ApiOperation(value = "Create a schedule.", httpMethod = "POST")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Scheduled created.", examples = @Example({}))
  })
  @ResponseStatus(value = HttpStatus.CREATED)
  ResponseEntity<Void> addScheduleTennisCourt(CreateScheduleRequestDTO createScheduleRequestDTO);
  
  /**
   * Retrieve a schedule by dates.
   * @param startDate the start date. It is required.
   * @param endDate the end date. Not required and, if not provided, the actual date will be used.
   * @return a {@link List} containing the schedules.
   */
  @ApiOperation(value = "Retrieve a schedule by dates.", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Scheduled not found.", examples = @Example({}))
  })
  ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(@ApiParam(format = "yyyy-MM-dd'T'HH:mm") LocalDate startDate, @ApiParam(format = "yyyy-MM-dd'T'HH:mm") LocalDate endDate);
  
  /**
   * Retrue a schedule by its unique identifier. 
   * @param scheduleId the schedule unique identifier.
   * @return a {@link ScheduleDTO} in case of success.
   */
  @ApiOperation(value = "Retrieve a schedule by its unique identifier.", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Scheduled not found.", examples = @Example({}))
  })
  ResponseEntity<ScheduleDTO> findByScheduleId(@ApiParam("The schedule unique identifier.") Long scheduleId);
    
}
