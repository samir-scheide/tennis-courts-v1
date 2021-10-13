package com.tenniscourts.tenniscourts;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.tenniscourts.config.TennisCourtsMapper;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TennisCourtMapper extends TennisCourtsMapper<TennisCourtDTO, TennisCourt> {
  
  TennisCourt map(TennisCourtCreateDTO tennisCourt);
  
}
