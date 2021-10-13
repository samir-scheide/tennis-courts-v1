package com.tenniscourts.reservations;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.tenniscourts.config.TennisCourtsMapper;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReservationMapper extends TennisCourtsMapper<ReservationDTO, Reservation> {

  Reservation map(CreateReservationRequestDTO source);
  
}
