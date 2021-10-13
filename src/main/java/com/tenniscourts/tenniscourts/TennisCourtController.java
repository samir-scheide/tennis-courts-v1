package com.tenniscourts.tenniscourts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenniscourts.config.BaseRestController;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v2/api/tennis-court")
public class TennisCourtController extends BaseRestController implements TennisCourtControllerApi {

  private final TennisCourtService tennisCourtService;
  
  /**
   * {@inheritDoc}
   */
  @PostMapping
  public ResponseEntity<TennisCourtDTO> addTennisCourt(@RequestBody TennisCourtCreateDTO tennisCourtDTO) {
    TennisCourtDTO entity = tennisCourtService.addTennisCourt(tennisCourtDTO);
    return ResponseEntity.created(locationByEntity(entity.getId())).body(entity);
  }
  
  /**
   * {@inheritDoc}
   */
  @GetMapping("/{id}")
  public ResponseEntity<TennisCourtDTO> findTennisCourtById(@PathVariable(name = "id") Long tennisCourtId) {
    return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
  }
  
  /**
   * {@inheritDoc}
   */
  @GetMapping("/{id}/schedules")
  public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(@PathVariable Long tennisCourtId) {
    return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
  }
  
}
