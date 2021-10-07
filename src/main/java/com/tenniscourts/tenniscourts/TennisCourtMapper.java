package com.tenniscourts.tenniscourts;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TennisCourtMapper {
  
  TennisCourtDTO map(TennisCourt source);
  
  TennisCourt map(TennisCourtDTO source);
  
}
