package com.tenniscourts.reservations;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReservationMapper {

  Reservation map(ReservationDTO source);
  
  ReservationDTO map(Reservation source);
  
  Reservation map(CreateReservationRequestDTO source);
  
}
