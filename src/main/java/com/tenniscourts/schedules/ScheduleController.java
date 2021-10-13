package com.tenniscourts.schedules;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenniscourts.config.BaseRestController;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v2/api/schedule")
public class ScheduleController extends BaseRestController implements ScheduleControllerApi {

  private final ScheduleService scheduleService;
  
  /**
   * {@inheritDoc}
   */
  @PostMapping
  public ResponseEntity<Void> addScheduleTennisCourt(@RequestBody CreateScheduleRequestDTO createScheduleRequestDTO) {
    return ResponseEntity.created(locationByEntity(scheduleService.addSchedule(createScheduleRequestDTO.getTennisCourtId(), createScheduleRequestDTO).getId())).build();
  }
  
  /**
   * {@inheritDoc}
   */
  @GetMapping
  public ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(@RequestParam LocalDate startDate, @RequestParam(required = false) LocalDate endDate) {
    return ResponseEntity.ok(scheduleService.findSchedulesByDates(LocalDateTime.of(startDate, LocalTime.of(0, 0)), LocalDateTime.of(endDate, LocalTime.of(23, 59))));
  }
  
  /**
   * {@inheritDoc}
   */
  @GetMapping("/{id}")
  public ResponseEntity<ScheduleDTO> findByScheduleId(@PathVariable Long scheduleId) {
    return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
  }
  
}
