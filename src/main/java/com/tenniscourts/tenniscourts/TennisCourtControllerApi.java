package com.tenniscourts.tenniscourts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;

/**
 * @author Samir Scheide
 */
@Api("Tennis Courts")
public interface TennisCourtControllerApi {

  /**
   * Create a tennis court usin the given information.
   * @param tennisCourtCreateDTO {@link TennisCourtCreateDTO}
   * @return TennisCourtDTO {@link TennisCourtDTO} in case of success.
   */
  @ApiOperation(value = "Create tennis court.", httpMethod = "POST")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Schedule created.")
  })
  @ResponseStatus(code = HttpStatus.CREATED)
  ResponseEntity<TennisCourtDTO> addTennisCourt(TennisCourtCreateDTO tennisCourtCreateDTO);
  
  /**
   * Find a tennis court using the given unique identifier.
   * @param tennisCourtId the tennis court unique identfier.
   * @return TennisCourtDTO {@link TennisCourtDTO} in case of success.
   */
  @ApiOperation(value = "Find a tennis court by its unique identifer.", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Tennis court not found.", examples = @Example(value = {}))
  })
  ResponseEntity<TennisCourtDTO> findTennisCourtById(Long tennisCourtId);
  
  /**
   * Find all schedules for a given tennis court.
   * @param tennisCourtId the tennis court unique identifier.
   * @return TennisCourtDTO {@link TennisCourtDTO} in case of success.
   */
  @ApiOperation(value = "Find all schedules for a tennis court.", responseContainer = "List", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Guest not found.", examples = @Example(value = {}))
  })
  ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(Long tennisCourtId);
  
}
