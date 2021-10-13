package com.tenniscourts.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenniscourts.config.BaseRestController;

import lombok.AllArgsConstructor;

/**
 * @author Samir Scheide
 */
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v2/api/reservation")
public class ReservationController extends BaseRestController implements ReservationControllerApi {

  private final ReservationService reservationService;

  /**
   * {@inheritDoc}
   */
  public ResponseEntity<Void> bookReservation(CreateReservationRequestDTO createReservationRequestDTO) {
    return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
  }

  /**
   * {@inheritDoc}
   */
  public ResponseEntity<ReservationDTO> findReservation(Long reservationId) {
    return ResponseEntity.ok(reservationService.findReservation(reservationId));
  }

  /**
   * {@inheritDoc}
   */
  public ResponseEntity<ReservationDTO> cancelReservation(Long reservationId) {
    return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
  }

  /**
   * {@inheritDoc}
   */
  public ResponseEntity<ReservationDTO> rescheduleReservation(Long reservationId, Long scheduleId) {
    return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
  }
}
