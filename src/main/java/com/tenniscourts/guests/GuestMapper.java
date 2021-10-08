package com.tenniscourts.guests;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.tenniscourts.TennisCourtsMapper;

/**
 * Guest mapper.
 * @author Samir Scheide
 */
@Component
@Mapper(componentModel = "spring")
public interface GuestMapper extends TennisCourtsMapper<GuestDTO, Guest> {
  
  /**
   * 
   * @param source
   * @return
   */
  List<GuestDTO> map(List<Guest> source);
  
}