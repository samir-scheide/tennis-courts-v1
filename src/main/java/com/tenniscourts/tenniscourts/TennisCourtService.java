package com.tenniscourts.tenniscourts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.schedules.ScheduleService;

import lombok.AllArgsConstructor;

/**
 * @author Samir Scheide
 */
@Service
@AllArgsConstructor
public class TennisCourtService {

  @Autowired
  private final TennisCourtRepository tennisCourtRepository;
  
  @Autowired
  private final ScheduleService scheduleService;
  
  @Autowired
  private final TennisCourtMapper tennisCourtMapper;
  
  /**
   * @param tennisCourt
   * @return
   */
  public TennisCourtDTO addTennisCourt(TennisCourtCreateDTO tennisCourt) {
    return tennisCourtMapper.map(tennisCourtRepository.saveAndFlush(tennisCourtMapper.map(tennisCourt)));
  }

  /**
   * 
   * @param id
   * @return
   */
  public TennisCourtDTO findTennisCourtById(Long id) {
    return tennisCourtRepository.findById(id).map(tennisCourtMapper::map).orElseThrow(() -> {
        throw new EntityNotFoundException("Tennis Court not found.");
    });
  }
  
  /**
   * 
   * @param tennisCourtId
   * @return
   */
  public TennisCourtDTO findTennisCourtWithSchedulesById(Long tennisCourtId) {
    TennisCourtDTO tennisCourtDTO = findTennisCourtById(tennisCourtId);
    tennisCourtDTO.setTennisCourtSchedules(scheduleService.findSchedulesByTennisCourtId(tennisCourtId));
    return tennisCourtDTO;
  }
  
}
