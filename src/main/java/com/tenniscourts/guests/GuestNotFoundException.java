package com.tenniscourts.guests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Samir Scheide
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GuestNotFoundException extends Exception {

  private static final long serialVersionUID = -5819527803634611380L;
  
  /**
   * @param id guest unique identifier
   */
  public GuestNotFoundException(final Long id) {
    super(String.format("Guest [%s] not found by its unique identifier.", id));
  }
  
  /**
   * @param id guest unique identifier
   */
  public GuestNotFoundException(final String name) {
    super(String.format("Guest [%s] not found by its name.", name));
  }

}
