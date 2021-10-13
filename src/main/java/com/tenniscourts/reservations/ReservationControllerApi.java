package com.tenniscourts.reservations;

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
@Api("Reservations")
public interface ReservationControllerApi {

  /**
   * Book a reservation.
   * @param createReservationRequestDTO {@link CreateReservationRequestDTO} reservation information.
   * @return success if the reservation is created.
   */
  @ApiOperation(value = "Book a reservation.", httpMethod = "POST")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Reservation created.")
  })
  @ResponseStatus(value = HttpStatus.CREATED)
  ResponseEntity<Void> bookReservation(CreateReservationRequestDTO createReservationRequestDTO);
  
  /**
   * Get a reservatiion using its unique identifier.
   * @param reservationId the reservation unique identifier.
   * @return a {@link ReservationDTO} in case of a reservation is found.
   */
  @ApiOperation(value = "Find a reservation.", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Reservation not found.", examples = @Example({}))
  })
  ResponseEntity<ReservationDTO> findReservation(@ApiParam("The reservation unique identifier.") Long reservationId);
  
  /**
   * Cancel a reservation.
   * @param reservationId reservation unique identifier.
   * @return {@link ReservationDTO} in case of success with a refund value updated.
   */
  @ApiOperation(value = " Cancel a reservation.", httpMethod = "DELETE")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "No reservation found.")
  })
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  ResponseEntity<ReservationDTO> cancelReservation(@ApiParam("The reservation unique identifier.") Long reservationId);
  
  /**
   * Reschedule a reservation.
   * @param reservationId reservation unique identifier.
   * @param scheduleId reschedule unique identifier.
   * @return a {@link ReservationDTO} in case of success.
   */
  @ApiOperation(value = "Reschedule a reservation.", httpMethod = "POST")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "No reservation found.")
  })
  ResponseEntity<ReservationDTO> rescheduleReservation(Long reservationId, Long scheduleId);
  
}
