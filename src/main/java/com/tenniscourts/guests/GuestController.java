package com.tenniscourts.guests;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenniscourts.config.BaseRestController;

import lombok.AllArgsConstructor;

/**
 * @author Samir Scheide
 */
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v2/api/guest")
public class GuestController extends BaseRestController implements GuestControllerApi  {

  private GuestServiceImpl guestService;
  
  /**
   * {@inheritDoc}
   */
  @PostMapping
  public ResponseEntity<GuestDTO> create(@RequestBody @Valid GuestCreateDTO guest) {
    GuestDTO entity = guestService.create(guest);
    return ResponseEntity.created(locationByEntity(entity.getId())).body(guestService.create(guest));
  }
  
  /**
   * {@inheritDoc}
   * @throws GuestNotFoundException 
   */
  @GetMapping
  public ResponseEntity<List<GuestDTO>> list(@RequestParam(required = false) String name) throws GuestNotFoundException {
    List<GuestDTO> reponse = name == null || name.isEmpty() ? guestService.list() : guestService.find(name);
    if (reponse.isEmpty()) return ResponseEntity.noContent().build();
    else {
      return ResponseEntity.ok(reponse);
    }
  }
  
  /**
   * {@inheritDoc}
   */
  @GetMapping("/{id}")
  public ResponseEntity<GuestDTO> get(@PathVariable Long id) throws GuestNotFoundException {
    return ResponseEntity.ok(guestService.get(id));
  }

  /**
   * {@inheritDoc}
   */
  @PatchMapping("/{id}")
  public ResponseEntity<GuestDTO> update(@RequestBody GuestUpdateDTO guest, @PathVariable Long id) throws GuestNotFoundException {
    return ResponseEntity.ok(guestService.update(guest, id));
  }

  /**
   * {@inheritDoc}
   */  
  @DeleteMapping("/id")
  public ResponseEntity<Void> delete(@PathVariable Long id) throws GuestNotFoundException {
    GuestDTO dto = guestService.get(id);
    if (dto != null) guestService.delete(id);
    else {
      throw new GuestNotFoundException(id);
    }
    return ResponseEntity.noContent().build();
  }

}
