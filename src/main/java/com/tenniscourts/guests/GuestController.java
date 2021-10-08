package com.tenniscourts.guests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Samir Scheide
 */
@Controller
@AllArgsConstructor
@RequestMapping("/guest")
public final class GuestController {

  @Autowired
  private final GuestService guestService;
  
  @GetMapping
  public ResponseEntity<List<GuestDTO>> list() {
    return ResponseEntity.ok(guestService.list());
  }
  
}
