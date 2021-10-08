package com.tenniscourts.guests;

/**
 * 
 * @author Samir Scheide
 */
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
